package org.example.nutricomebh.Ingrediente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.nutricomebh.ItemReceita.ItemModel;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Quantidade.QuantidadeModel;
import org.example.nutricomebh.Receitas.ReceitasModel;

import java.util.List;


//Transforma uma classe em uma entidade do BD
@Entity
@Table(name="tb_ingrediente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = {"item"})
public class IngredienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingrediente_id")
    private Long id;

    @Column(name = "nome",unique = true)
    private String nome;

    //@ManyToMany(mappedBy = "ingrediente")
    //private List<ReceitasModel> receita;


    //@OneToMany(mappedBy = "ingrediente")
    //private List<QuantidadeModel> quantidade;

    @JsonIgnore
    @OneToMany(mappedBy = "ingrediente")
    private List<ItemModel> itens;

    public IngredienteModel(String nome) {
        this.nome = nome;
    }
}
