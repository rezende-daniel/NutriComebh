package org.example.nutricomebh.Receitas;


import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.example.nutricomebh.Ingrediente.IngredientesMapper;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitasService {
    private final ReceitasMapper receitasMapper;
    private final IngredientesMapper ingredientesMapper;
    private final ReceitasRepository receitasRepository;


    public ReceitasService(ReceitasRepository receitasRepository, ReceitasMapper receitasMapper, IngredientesMapper ingredientesMapper) {
        this.receitasRepository = receitasRepository;
        this.receitasMapper = receitasMapper;
        this.ingredientesMapper = ingredientesMapper;
    }

    //listar todas as receitas
    public List<ReceitasDTO> listaReceitas() {
        List<ReceitasModel> receitas = receitasRepository.findAll();
        return receitas.stream().
                map(receitasMapper::mapReceitas)
                .collect(Collectors.toList());
    }
    //Listar receitas por id
    public ReceitasDTO listarReceitasPorId(Long id) {
        Optional<ReceitasModel> receitasModel = receitasRepository.findById(id);
        return  receitasModel.map(receitasMapper::mapReceitas).orElse(null);
    }
    //Criar nova receita
    public ReceitasDTO criarReceita(ReceitasDTO receitasDTO) {
        ReceitasModel receitaNova = receitasMapper.mapReceitas(receitasDTO);
        receitaNova = receitasRepository.save(receitaNova);
        return receitasMapper.mapReceitas(receitaNova);
    }
    //Deletar receita
    public void deletarReceita(Long id) {
        receitasRepository.deleteById(id);
    }
    //Editar receita
    public  ReceitasDTO editarReceita(ReceitasDTO receitasDTO,Long id) {
        Optional<ReceitasModel> receitaExiste = receitasRepository.findById(id);
        if(receitaExiste.isPresent()) {
            ReceitasModel receitaAtualizado = receitasMapper.mapReceitas(receitasDTO);
            receitaAtualizado.setId(id);
            ReceitasModel receitaModificado = receitasRepository.save(receitaAtualizado);
            return receitasMapper.mapReceitas(receitaModificado);
        }return  null;
    }
}
