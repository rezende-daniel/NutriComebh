package org.example.nutricomebh.ItemReceita;

import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.example.nutricomebh.Medidas.MedidasDTO;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Quantidade.QuantidadeDTO;
import org.example.nutricomebh.Quantidade.QuantidadeModel;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemModel mapitem(ItemDTO itemDTO) {
        ItemModel itemModel = new ItemModel();
        itemModel.setId(itemDTO.getId());
        itemModel.setMedida(itemDTO.getMedida());
        itemModel.setQuantidade(itemDTO.getQuantidade());
        itemModel.setIngrediente(itemDTO.getIngrediente());
        itemModel.setReceita(itemDTO.getReceita());
        return itemModel;
    }
    public ItemDTO mapitem(ItemModel itemModel) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(itemModel.getId());
        itemDTO.setMedida(itemModel.getMedida());
        itemDTO.setQuantidade(itemModel.getQuantidade());
        itemDTO.setIngrediente(itemModel.getIngrediente());
        itemDTO.setReceita(itemModel.getReceita());
        return itemDTO;
    }


}
