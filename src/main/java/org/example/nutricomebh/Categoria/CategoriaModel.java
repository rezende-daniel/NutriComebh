package org.example.nutricomebh.Categoria;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Receitas.ReceitasModel;

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
    private Long id;

    @Column(name = "nome_categoria")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<ReceitasModel> receitas;

    @Override
    public String toString() {
        return  nome;
    }
}
