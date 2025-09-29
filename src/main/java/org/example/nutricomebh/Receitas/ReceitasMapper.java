package org.example.nutricomebh.Receitas;


import org.springframework.stereotype.Component;



@Component
public class ReceitasMapper {
    public ReceitasModel mapReceitas(ReceitasDTO receitasDTO){
        ReceitasModel receitasModel = new ReceitasModel();
        receitasModel.setId(receitasDTO.getId());
        receitasModel.setCategoria(receitasDTO.getCategoria());
        receitasModel.setNome(receitasDTO.getNome());
        receitasModel.setPreparo(receitasDTO.getPreparo());
        receitasModel.setIngrediente(receitasDTO.getIngrediente());
        return receitasModel;
    }
    public ReceitasDTO mapReceitas(ReceitasModel receitasModel){
        ReceitasDTO receitasDTO = new ReceitasDTO();
        receitasDTO.setId(receitasModel.getId());
        receitasDTO.setCategoria(receitasModel.getCategoria());
        receitasDTO.setNome(receitasModel.getNome());
        receitasDTO.setPreparo(receitasModel.getPreparo());
        receitasDTO.setIngrediente(receitasModel.getIngrediente());
        return receitasDTO;
    }

}
