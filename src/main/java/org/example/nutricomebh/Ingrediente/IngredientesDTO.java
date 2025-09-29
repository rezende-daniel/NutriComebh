package org.example.nutricomebh.Ingrediente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Receitas.ReceitasModel;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientesDTO {

        private Long id;
        private String nome;
        private List<ReceitasModel> receita;



}
