package org.example.nutricomebh.Ingrediente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Transforma uma classe em uma entidade do BD
@Entity
@Table(name="tb_ingrediente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngredienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;
}
