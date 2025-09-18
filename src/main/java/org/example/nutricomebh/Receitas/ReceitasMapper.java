package org.example.nutricomebh.Receitas;


import org.springframework.stereotype.Component;

@Component
public class ReceitasMapper {
    public ReceitasModel mapReceitas(ReceitasDTO receitaDTO){
        ReceitasModel receitasModel = new ReceitasModel();
        receitasModel.setId(receitaDTO.getId());
        receitasModel.setCategoria(receitaDTO.getCategoria());
        receitasModel.setNome(receitaDTO.getNome());
        receitasModel.setPreparo(receitaDTO.getPreparo());
        receitasModel.setPreparo(receitaDTO.getPreparo());
        receitasModel.setMedidas(receitaDTO.getMedidas());
        return receitasModel;
    }
    public ReceitasDTO mapReceitas(ReceitasModel receitasModel){
        ReceitasDTO receitasDTO = new ReceitasDTO();
        receitasDTO.setId(receitasModel.getId());
        receitasDTO.setCategoria(receitasModel.getCategoria());
        receitasDTO.setNome(receitasModel.getNome());
        receitasDTO.setPreparo(receitasModel.getPreparo());
        receitasDTO.setIngrediente(receitasModel.getIngrediente());
        receitasDTO.setMedidas(receitasModel.getMedidas());
        return receitasDTO;
    }

}
