package org.example.nutricomebh.Ingrediente;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredienteService {
    private final IngredientesMapper ingredientesMapper;
    private IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository, IngredientesMapper ingredientesMapper) {
        this.ingredienteRepository = ingredienteRepository;
        this.ingredientesMapper = ingredientesMapper;
    }

    //Adicionar um ingrediente


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
    public IngredientesDTO alterarIngrediente(IngredienteModel ingrediente,Long id){
        Optional<IngredienteModel> ingredienteExiste = ingredienteRepository.findById(id);
        if(ingredienteExiste.isPresent()){
            IngredienteModel ingredienteAlterado = ingredienteExiste.get();
            ingredienteAlterado.setId(id);
            IngredienteModel ingredienteAtualizado = ingredienteRepository.save(ingredienteAlterado);
            return ingredientesMapper.mapIngrediente(ingredienteAlterado);
        }
        return null;
    }

    //Remover ingrediente
    public void deletarIngrediente(Long id){
        ingredienteRepository.deleteById(id);
    }
}
