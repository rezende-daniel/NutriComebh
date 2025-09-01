package org.example.nutricomebh.Categoria;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Receitas.receitasModel;

import java.util.List;

@Entity
@Table(name = "tb_categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private int id;

    @Column(name = "nome_categoria")
    private String nome;


    @OneToMany(mappedBy = "categoria")
    private List<receitasModel> receitas;



}
