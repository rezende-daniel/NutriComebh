package org.example.nutricomebh.Cardapio;

import jakarta.persistence.Column;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.example.nutricomebh.ItemReceita.ItemDTO;
import org.example.nutricomebh.ItemReceita.ItemMapper;
import org.example.nutricomebh.ItemReceita.ItemModel;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Quantidade.QuantidadeModel;
import org.example.nutricomebh.Receitas.ReceitasDTO;
import org.example.nutricomebh.Receitas.ReceitasModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
@Component
public class ConsolidadorIngredientes {

    public List<ItemDTO> consolidar(List<ReceitasDTO> receitas,int numeroDePessoas) {
        System.out.println(receitas.size());
        Map<String, ItemDTO> mapa = new HashMap<>();
        final ItemMapper itemMapper = new ItemMapper();



        for (ReceitasDTO receita : receitas) {
            for (ItemDTO ing : itemMapper.mapitem( receita.getItens())) {
                String chave = ing.getIngrediente().getNome().toLowerCase(); // normaliza o nome
                ing.setQuantidade(ing.getQuantidade().multiply(BigDecimal.valueOf(numeroDePessoas/10)));
                if (mapa.containsKey(chave)) {
                    // já existe → soma quantidade
                    ItemDTO existente = mapa.get(chave);
                    existente.setQuantidade(existente.getQuantidade().add( ing.getQuantidade()));
                } else {
                    // novo ingrediente → adiciona cópia
                    mapa.put(chave, new ItemDTO(
                            new IngredienteModel(ing.getIngrediente().getNome()),new MedidasModel(ing.getMedida().getMedida()),
                            new QuantidadeModel(ing.getQuantidade()).getQuantidade()));
                }
            }
        }

        return new ArrayList<>(mapa.values());
    }
}

