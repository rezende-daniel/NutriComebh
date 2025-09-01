package org.example.nutricomebh.Receitas;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Categoria.CategoriaModel;
import org.example.nutricomebh.Ingrediente.IngredienteModel;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_receitas")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class receitasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receita_id")
    private Long id;



    @Column(name = "nome_receita")
    private String nome;




    @Column(name = "preparo")
    private String preparo;


    @ManyToMany
    @JoinTable(
            name = "ingredientes_receita",
            joinColumns = @JoinColumn(name = "receita_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<IngredienteModel> ingrediente;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoria;
}
