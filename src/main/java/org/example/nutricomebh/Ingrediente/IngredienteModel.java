package org.example.nutricomebh.Ingrediente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Receitas.ReceitasModel;

import java.util.List;


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

    //cada ingredienten tem uma unica media
    @ManyToOne
    @JoinColumn(name = "medidas_id")
    private MedidasModel medidas;





    @ManyToMany(mappedBy = "ingrediente")
    private List<ReceitasModel> receita;

}
