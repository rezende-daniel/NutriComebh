package org.example.nutricomebh.ItemReceita;

import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.example.nutricomebh.Ingrediente.IngredientesMapper;
import org.example.nutricomebh.Medidas.MedidasDTO;
import org.example.nutricomebh.Medidas.MedidasMapper;
import org.example.nutricomebh.Quantidade.QuantidadeDTO;
import org.example.nutricomebh.Quantidade.QuantidadeMapper;
import org.example.nutricomebh.Receitas.ReceitasDTO;
import org.example.nutricomebh.Receitas.ReceitasMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {


    private final ItemMapper itemMapper;
    private final IngredientesMapper ingredientesMapper;
    private final MedidasMapper medidasMapper;
    private final QuantidadeMapper quantidadeMapper;
    private final ReceitasMapper receitasMapper;

    public ItemService(ItemMapper itemMapper, IngredientesMapper ingredientesMapper, MedidasMapper medidasMapper, QuantidadeMapper quantidadeMapper, ReceitasMapper receitasMapper) {
        this.itemMapper = itemMapper;
        this.ingredientesMapper = ingredientesMapper;
        this.medidasMapper = medidasMapper;
        this.quantidadeMapper = quantidadeMapper;
        this.receitasMapper = receitasMapper;
    }

    //Cria uma lista de intens
    public List<ItemDTO> criaItem(List <IngredientesDTO> ingredientesDTO, List<MedidasDTO> medidasDTO, List <QuantidadeDTO> quantidadeDTO, ReceitasDTO receitasDTO){
        List<ItemDTO> itemDTO= new ArrayList<>();
        for(int i=0;i>= ingredientesDTO.size();i++){
            ItemDTO itemDTO1 = new ItemDTO();
            //itemDTO1.setId(ingredientesDTO.get(i).getId());
            itemDTO1.setIngrediente(ingredientesMapper.mapIngrediente(ingredientesDTO.get(i)));
            itemDTO1.setMedida(medidasMapper.mapMedidas(medidasDTO.get(i)));
            itemDTO1.setQuantidade(quantidadeMapper.mapQuantidade(quantidadeDTO.get(i)));
            itemDTO1.setReceita(receitasMapper.mapReceitas(receitasDTO));
            itemDTO.add(itemDTO1);
        }
        return itemDTO;

    }
}
