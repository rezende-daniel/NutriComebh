package org.example.nutricomebh.ItemReceita;

import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.example.nutricomebh.Ingrediente.IngredientesMapper;
import org.example.nutricomebh.Medidas.MedidasDTO;
import org.example.nutricomebh.Medidas.MedidasMapper;
import org.example.nutricomebh.Quantidade.QuantidadeDTO;
import org.example.nutricomebh.Quantidade.QuantidadeMapper;
import org.example.nutricomebh.Receitas.ReceitasDTO;
import org.example.nutricomebh.Receitas.ReceitasMapper;
import org.example.nutricomebh.Receitas.ReceitasService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ItemService {


    private final ItemMapper itemMapper;
    private final IngredientesMapper ingredientesMapper;
    private final MedidasMapper medidasMapper;
    private final QuantidadeMapper quantidadeMapper;
    private final ReceitasMapper receitasMapper;
    private final ReceitasService receitasService;
    private final ItemRepository itemRepository;

    public ItemService(ItemMapper itemMapper, IngredientesMapper ingredientesMapper, MedidasMapper medidasMapper, QuantidadeMapper quantidadeMapper, ReceitasMapper receitasMapper, ReceitasService receitasService, ItemRepository itemRepository) {
        this.itemMapper = itemMapper;
        this.ingredientesMapper = ingredientesMapper;
        this.medidasMapper = medidasMapper;
        this.quantidadeMapper = quantidadeMapper;
        this.receitasMapper = receitasMapper;
        this.receitasService = receitasService;
        this.itemRepository = itemRepository;
    }

    //Cria uma lista de intens
    public List<ItemDTO> criaItem(List <IngredientesDTO> ingredientesDTO, List<MedidasDTO> medidasDTO, List <QuantidadeDTO> quantidadeDTO, ReceitasDTO receitasDTO){
        List<ItemDTO> itemDTO= new ArrayList<>();
        for(int i=0;i>= ingredientesDTO.size();i++){
            ItemDTO itemDTO1 = new ItemDTO();
            //itemDTO1.setId(ingredientesDTO.get(i).getId());
            itemDTO1.setIngrediente(ingredientesMapper.mapIngrediente(ingredientesDTO.get(i)));
            itemDTO1.setMedida(medidasMapper.mapMedidas(medidasDTO.get(i)));
            itemDTO1.setQuantidade((quantidadeDTO.get(i).getQuantidade()));
            itemDTO1.setReceita(receitasMapper.mapReceitas(receitasDTO));
            itemDTO.add(itemDTO1);
        }
        return itemDTO;

    }
    //Listar ingredientes da receita escolhinda
    public List<ItemDTO> listarIngredientesReceita(Long id){
        ReceitasDTO receitaListando = receitasService.listarReceitasPorId(id);
        List<ItemDTO> itens;
        itens  =itemMapper.mapitem(receitaListando.getItens());
        System.out.println(itens.size());
        System.out.println(receitaListando.getItens().size());

        /*Stream<ItemDTO> itens;
        System.out.println(receitaListando.getNome());
        List<ItemModel> itemModels= itemRepository.findAll();
        System.out.println("itemModels"+itemModels);
        itens =itemMapper.mapitem(itemModels.stream()
                .filter(itemModel-> itemModel.getReceita().equals(receitaListando)));
        //System.out.println( itens.count());


        /*int i =0;
        while (itemModels.size() > i){
            itens.add(itemMapper.mapitem(itemRepository.findById(itemModels.get(i).getId())));
            System.out.println(itemModels.get(i));
            i++;
        }
        //System.out.println(itens.getFirst());
         */
        return itens;
    }
}
