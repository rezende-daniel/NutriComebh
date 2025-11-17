package org.example.nutricomebh.Receitas;


import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.example.nutricomebh.Ingrediente.IngredientesMapper;
import org.example.nutricomebh.ItemReceita.ItemDTO;
import org.example.nutricomebh.ItemReceita.ItemMapper;
import org.example.nutricomebh.ItemReceita.ItemModel;
import org.example.nutricomebh.ItemReceita.ItemRepository;
import org.example.nutricomebh.Quantidade.QuantidadeDTO;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitasService {
    private final ReceitasMapper receitasMapper;
    private final IngredientesMapper ingredientesMapper;
    private final ReceitasRepository receitasRepository;
    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;
    public ReceitasService(ReceitasRepository receitasRepository, ReceitasMapper receitasMapper, IngredientesMapper ingredientesMapper, ItemRepository itemRepository, ItemMapper itemMapper, ItemRepository itemRepository1) {
        this.receitasRepository = receitasRepository;
        this.receitasMapper = receitasMapper;
        this.ingredientesMapper = ingredientesMapper;
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository1;
    }

    //listar todas as receitas
    public List<ReceitasDTO> listaReceitas() {
        List<ReceitasModel> receitas = receitasRepository.findAll();
        return receitas.stream().
                map(receitasMapper::mapReceitas)
                .collect(Collectors.toList());
    }
    //Listar receitas por id
    public ReceitasDTO listarReceitasPorId(Long id) {
        Optional<ReceitasModel> receitasModel = receitasRepository.findById(id);
        return  receitasModel.map(receitasMapper::mapReceitas).orElse(null);
    }
    //Listar receita por categoria
    public List<ReceitasDTO> listarReceitaPorCategoria(Long categoria) {
        //categoria = 2l;
        List <ReceitasModel> receitasModel =receitasRepository.findAllByCategoria_Id(categoria);
          List<ReceitasDTO> receitasDTOS = new ArrayList<>();
          for (int i=0;i<receitasModel.size();) {
              receitasDTOS.add(receitasMapper.mapReceitas( receitasModel.get(i)));

              i++;
              }

        //System.out.println(receitasModel.get(1).getCategoria());
      return  receitasDTOS;

    }
    //Criar nova receita
    public ReceitasDTO criarReceita(ReceitasDTO receitasDTO) {
        ReceitasModel receitaNova = receitasMapper.mapReceitas(receitasDTO);
        receitaNova = receitasRepository.save(receitaNova);
        Long idReceita = receitaNova.getId();
        System.out.println(receitaNova+" fora do for");
        List<ItemModel> itens = new ArrayList<>();
        for (ItemModel item : receitasDTO.getItens()) {

            item.setReceita(receitaNova); // vincula à receita principal
            itemRepository.save(item);
            itens.add(item);
            System.out.println(itens+ " dentro do for");
        }

        System.out.println(itens);
        receitaNova.setItens((itens));
        receitaNova.setId(idReceita);
        System.out.println(receitaNova+" fora do for2");
        //receitasRepository.save(receitaNova);
        return receitasMapper.mapReceitas(receitaNova);
    }
    //Deletar receita
    public void deletarReceita(Long id) {
        receitasRepository.deleteById(id);
    }
    //Editar receita
    public  ReceitasDTO editarReceita(ReceitasDTO receitasDTO,Long id) {
        Optional<ReceitasModel> receitaExiste = receitasRepository.findById(id);
        if(receitaExiste.isPresent()) {
            ReceitasModel receitaAtualizado = receitasMapper.mapReceitas(receitasDTO);
            receitaAtualizado.setId(id);
            ReceitasModel receitaModificado = receitasRepository.save(receitaAtualizado);
            return receitasMapper.mapReceitas(receitaModificado);
        }return  null;
    }

}
