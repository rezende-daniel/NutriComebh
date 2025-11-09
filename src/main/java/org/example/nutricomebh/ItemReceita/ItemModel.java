package org.example.nutricomebh.ItemReceita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Quantidade.QuantidadeModel;
import org.example.nutricomebh.Receitas.ReceitasModel;

import java.math.BigDecimal;


@Entity
@Table(name = "tb_itens")
@Data
@ToString(exclude = {"receita", "ingrediente", "medida"})
@AllArgsConstructor
@NoArgsConstructor
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private IngredienteModel ingrediente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "medida_id")
    private MedidasModel medida;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    @JsonIgnore
    private ReceitasModel receita;
}
