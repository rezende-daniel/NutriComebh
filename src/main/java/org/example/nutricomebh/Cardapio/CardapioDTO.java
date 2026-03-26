package org.example.nutricomebh.Cardapio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Receitas.ReceitasModel;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardapioDTO {


    private Long id;


    private List<ReceitasModel> receitasCardapio = new ArrayList<>();



    private Integer numeroPessoas;

}
