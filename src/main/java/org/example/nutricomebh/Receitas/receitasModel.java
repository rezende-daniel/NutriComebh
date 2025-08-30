package org.example.nutricomebh.Receitas;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Ingrediente.IngredienteModel;

import java.util.List;

@Entity
@Table(name = "tb_receitas")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class receitasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome_Receita")
    private String nome;


    private List<IngredienteModel> ingredientes;

    @Column(name = "preparo")
    private String preparo;
}
