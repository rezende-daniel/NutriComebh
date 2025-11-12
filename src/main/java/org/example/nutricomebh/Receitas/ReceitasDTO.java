package org.example.nutricomebh.Receitas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Categoria.CategoriaModel;
import org.example.nutricomebh.ItemReceita.ItemDTO;
import org.example.nutricomebh.ItemReceita.ItemModel;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitasDTO {


    private Long id;
    private String nome;
    private String preparo;
    private CategoriaModel categoria = new CategoriaModel();
    private List<ItemModel> itens=new ArrayList<>();



}
