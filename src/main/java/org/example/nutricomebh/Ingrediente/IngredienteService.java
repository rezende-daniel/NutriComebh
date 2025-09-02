package org.example.nutricomebh.Ingrediente;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {
    private IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    //Adicionar um ingrediente


    //Listar todos os ingredientes
    public List<IngredienteModel> listarIngredientes(){
        return ingredienteRepository.findAll();
    }

    //Listar ingredientes por Id
    public IngredienteModel buscarIngredientePorId(Long id){
        Optional<IngredienteModel> ingredientePorId = ingredienteRepository.findById(id);
        return ingredientePorId.orElse(null);
    }

    //Alterar ingrediente


    //Remover ingrediente

}
