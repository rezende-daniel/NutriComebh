package org.example.nutricomebh.ItemReceita;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Quantidade.QuantidadeModel;
import org.example.nutricomebh.Receitas.ReceitasModel;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private long id;
    private IngredienteModel ingrediente;
    private MedidasModel medida;
    private QuantidadeModel quantidade;
    private ReceitasModel receita;
}
