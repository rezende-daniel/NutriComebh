package org.example.nutricomebh.ItemReceita;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Quantidade.QuantidadeModel;
import org.example.nutricomebh.Receitas.ReceitasModel;


@Entity
@Table(name = "tb_itens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private IngredienteModel ingrediente;

    @ManyToOne
    @JoinColumn(name = "medida_id")
    private MedidasModel medida;

    @OneToOne
    private QuantidadeModel quantidade;

    @ManyToOne
    @JoinColumn(name = "receita")
    private ReceitasModel receita;
}
