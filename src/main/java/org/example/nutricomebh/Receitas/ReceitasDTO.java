package org.example.nutricomebh.Receitas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Categoria.CategoriaModel;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.ItemReceita.ItemModel;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Quantidade.QuantidadeModel;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitasDTO {


    private Long id;
    private String nome;
    private String preparo;
    private CategoriaModel categoria;
    private List<ItemModel> itens;


}
