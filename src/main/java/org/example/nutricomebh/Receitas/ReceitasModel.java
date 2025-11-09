package org.example.nutricomebh.Receitas;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Categoria.CategoriaModel;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.ItemReceita.ItemModel;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Quantidade.QuantidadeModel;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_receitas")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ReceitasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receita_id")
    private Long id;

    @Column(name = "nome_receita")
    private String nome;

    @Column(name = "preparo")
    private String preparo;


    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemModel> itens = new ArrayList<>();



    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoria;
}
