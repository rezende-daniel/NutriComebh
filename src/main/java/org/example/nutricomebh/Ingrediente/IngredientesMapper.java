package org.example.nutricomebh.Ingrediente;


import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IngredientesMapper {

    public IngredienteModel mapIngrediente(IngredientesDTO ingredientesDTO){
        IngredienteModel ingredienteModel = new IngredienteModel();
        ingredienteModel.setId(ingredientesDTO.getId());
        ingredienteModel.setNome(ingredientesDTO.getNome());
        ingredienteModel.setReceita(ingredientesDTO.getReceita());

        return ingredienteModel;
    }

    public IngredientesDTO mapIngrediente(IngredienteModel ingredienteModel){
        IngredientesDTO ingredientesDTO = new IngredientesDTO();
        ingredientesDTO.setId(ingredienteModel.getId());
        ingredientesDTO.setNome(ingredienteModel.getNome());
        ingredientesDTO.setReceita(ingredienteModel.getReceita());
        return ingredientesDTO;
    }
}
