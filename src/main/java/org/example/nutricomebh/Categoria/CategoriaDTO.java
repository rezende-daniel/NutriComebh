package org.example.nutricomebh.Categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Receitas.ReceitasModel;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {


    private Long id;
    private String nome;
    private List<ReceitasModel> receitas;

}
