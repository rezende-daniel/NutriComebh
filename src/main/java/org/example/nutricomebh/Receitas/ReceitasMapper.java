package org.example.nutricomebh.Receitas;


import org.example.nutricomebh.ItemReceita.ItemDTO;
import org.example.nutricomebh.ItemReceita.ItemModel;
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
        List<ItemModel> itemsModel=receitasDTO.getItens().stream()
                .map(itemDTO -> {
            ItemModel itemModel = new ItemModel();
            itemModel.setId(itemDTO.getId());
            itemModel.setIngrediente(itemDTO.getIngrediente());
            itemModel.setMedida(itemDTO.getMedida());
            itemModel.setQuantidade(itemDTO.getQuantidade());
            itemModel.setReceita(receitasModel);
            return itemModel;
        })
                .toList();
        return receitasModel;
    }
    public ReceitasDTO mapReceitas(ReceitasModel receitasModel){
        ReceitasDTO receitasDTO = new ReceitasDTO();
        receitasDTO.setId(receitasModel.getId());
        receitasDTO.setCategoria(receitasModel.getCategoria());
        receitasDTO.setNome(receitasModel.getNome());
        receitasDTO.setPreparo(receitasModel.getPreparo());
        List<ItemDTO> itemsDTO = receitasModel.getItens().stream()
                .map(itemModel -> {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(itemModel.getId());
            itemDTO.setIngrediente(itemModel.getIngrediente());
            itemDTO.setMedida(itemModel.getMedida());
            itemDTO.setQuantidade(itemModel.getQuantidade());
            itemDTO.setReceita(itemModel.getReceita());
            return itemDTO;
        }).toList();
        return receitasDTO;
    }

}
