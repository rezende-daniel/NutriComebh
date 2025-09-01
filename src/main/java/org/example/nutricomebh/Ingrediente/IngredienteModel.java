package org.example.nutricomebh.Ingrediente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Receitas.receitasModel;

import java.util.List;
import java.util.Set;


//Transforma uma classe em uma entidade do BD
@Entity
@Table(name="tb_ingrediente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngredienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingrediente_id")
    private Long id;

    @Column(name = "nome")
    private String nome;


    @ManyToMany(mappedBy = "ingrediente")
    private List<receitasModel> receita;

}
