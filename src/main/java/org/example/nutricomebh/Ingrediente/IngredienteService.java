package org.example.nutricomebh.Ingrediente;


import org.example.nutricomebh.ItemReceita.ItemDTO;
import org.example.nutricomebh.ItemReceita.ItemMapper;
import org.example.nutricomebh.ItemReceita.ItemModel;
import org.example.nutricomebh.Medidas.*;
import org.example.nutricomebh.Receitas.ReceitasDTO;
import org.example.nutricomebh.Receitas.ReceitasRepository;
import org.example.nutricomebh.Receitas.ReceitasService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredienteService {
    private final IngredientesMapper ingredientesMapper;
    private final MedidasRepository medidasRepository;
    private final MedidasMapper medidasMapper;
    private final MedidasService medidasService;
    private final ReceitasService receitasService;
    private final ReceitasRepository receitasRepository;
    private IngredienteRepository ingredienteRepository;
    private final ItemMapper itemMapper;

    public IngredienteService(IngredienteRepository ingredienteRepository, IngredientesMapper ingredientesMapper, MedidasRepository medidasRepository, MedidasMapper medidasMapper, MedidasService medidasService, ReceitasService receitasService, ReceitasRepository receitasRepository, ItemMapper itemMapper) {
        this.ingredienteRepository = ingredienteRepository;
        this.ingredientesMapper = ingredientesMapper;
        this.medidasRepository = medidasRepository;
        this.medidasMapper = medidasMapper;
        this.medidasService = medidasService;
        this.receitasService = receitasService;
        this.receitasRepository = receitasRepository;
        this.itemMapper = itemMapper;
    }

    //Adicionar um ingrediente
    public IngredientesDTO criarIngrediente( IngredientesDTO ingredientesDTO) {
        //Long medidasId = medidasDTO.getId();
        IngredienteModel ingredienteNovo = ingredientesMapper.mapIngrediente(ingredientesDTO);
        //ingredienteNovo.setMedidas(medidasRepository.findById(medidasId).get());
        ingredienteNovo = ingredienteRepository.save(ingredienteNovo);

        return ingredientesMapper.mapIngrediente(ingredienteNovo);
    }

    //Listar todos os ingredientes
    public List<IngredientesDTO> listarIngredientes(){
        List<IngredienteModel> ingredientes = ingredienteRepository.findAll();

        return ingredientes.stream().
                map(ingredientesMapper::mapIngrediente)
                .collect(Collectors.toList());
    }

    //Listar ingredientes por Id
    public IngredientesDTO buscarIngredientePorId(Long id){
        Optional<IngredienteModel> ingredientePorId = ingredienteRepository.findById(id);
        return ingredientePorId.map(ingredientesMapper::mapIngrediente).orElse(null);
    }

    //Alterar ingrediente
    public IngredientesDTO alterarIngrediente(IngredientesDTO ingrediente,Long id){
        Optional<IngredienteModel> ingredienteExiste = ingredienteRepository.findById(id);
        if(ingredienteExiste.isPresent()){
            IngredienteModel ingredienteAtualizado = ingredientesMapper.mapIngrediente(ingrediente);
            ingredienteAtualizado.setId(id);
            IngredienteModel ingredienteAlterado = ingredienteRepository.save(ingredienteAtualizado);
            return ingredientesMapper.mapIngrediente(ingredienteAlterado);
        }
        return null;
    }

    //Remover ingrediente
    public void deletarIngrediente(Long id){
        ingredienteRepository.deleteById(id);
    }

    //Listar ingredientes da receita escolhinda
    public List<ItemDTO> listarIngredientesReceita(Long id){
        ReceitasDTO receita = receitasService.listarReceitasPorId(id);
        List <ItemModel> ingrediente = receita.getItens();
        return ingrediente.stream().
                map(itemMapper::mapitem)
                .collect(Collectors.toList());
    }


}
