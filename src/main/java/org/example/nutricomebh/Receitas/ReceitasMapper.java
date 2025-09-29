package org.example.nutricomebh.Receitas;


import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReceitasMapper {
    public ReceitasModel mapReceitas(ReceitasDTO receitasDTO){
        ReceitasModel receitasModel = new ReceitasModel();
        receitasModel.setId(receitasDTO.getId());
        receitasModel.setCategoria(receitasDTO.getCategoria());
        receitasModel.setNome(receitasDTO.getNome());
        receitasModel.setPreparo(receitasDTO.getPreparo());
        receitasModel.setIngrediente(receitasDTO.getIngrediente());
        receitasModel.setQuantidade(receitasDTO.getQuantidade());
        return receitasModel;
    }
    public ReceitasDTO mapReceitas(ReceitasModel receitasModel){
        ReceitasDTO receitasDTO = new ReceitasDTO();
        receitasDTO.setId(receitasModel.getId());
        receitasDTO.setCategoria(receitasModel.getCategoria());
        receitasDTO.setNome(receitasModel.getNome());
        receitasDTO.setPreparo(receitasModel.getPreparo());
        receitasDTO.setIngrediente(receitasModel.getIngrediente());
        receitasDTO.setQuantidade(receitasModel.getQuantidade());
        return receitasDTO;
    }

}
