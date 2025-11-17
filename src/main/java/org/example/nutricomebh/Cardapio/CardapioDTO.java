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


    private List<ReceitasModel> diaUm = new ArrayList<>();

    private List<ReceitasModel> diaDois = new ArrayList<>();

    private List<ReceitasModel> diaTreis = new ArrayList<>();

    private List<ReceitasModel> diaQuatro = new ArrayList<>();

    private Integer numeroPessoas;

}
