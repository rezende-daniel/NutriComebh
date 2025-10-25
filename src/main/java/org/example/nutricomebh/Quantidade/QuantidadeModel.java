package org.example.nutricomebh.Quantidade;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.ItemReceita.ItemModel;

import java.util.List;

@Entity
@Table(name = "tb_quantidade")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuantidadeModel {
    @Id
    @Column(name = "id_quantidade")
    private Long id;

    @Column(name = "quantidade")
    private double quantidade;

    //@ManyToOne
    //@JoinColumn(name = "ingrediente_id")
    //private IngredienteModel ingrediente;

    @OneToOne
    private ItemModel item;
}
