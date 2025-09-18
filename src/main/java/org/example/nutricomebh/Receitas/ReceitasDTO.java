package org.example.nutricomebh.Receitas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Categoria.CategoriaModel;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Medidas.MedidasModel;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitasDTO {


    private Long id;
    private String nome;
    private String preparo;
    private List<IngredienteModel> ingrediente;
    private List<MedidasModel> medidas;
    private CategoriaModel categoria;
}
