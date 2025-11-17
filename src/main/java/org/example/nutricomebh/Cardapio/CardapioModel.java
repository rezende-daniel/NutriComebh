package org.example.nutricomebh.Cardapio;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Receitas.ReceitasModel;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cardapio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardapioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardapio_id")
    private Long id;

    @ManyToMany
    @Column(name = "dia_um")
    private List<ReceitasModel> diaUm = new ArrayList<>();
    @ManyToMany
    @Column(name = "dia_dois")
    private List<ReceitasModel> diaDois = new ArrayList<>();
    @ManyToMany
    @Column(name = "dia_tres")
    private List<ReceitasModel> diaTreis = new ArrayList<>();
    @ManyToMany
    @Column(name = "dia_quatro")
    private List<ReceitasModel> diaQuatro = new ArrayList<>();

    @Column(name = "numero_pessoas")
    private Integer numeroPessoas;
}
