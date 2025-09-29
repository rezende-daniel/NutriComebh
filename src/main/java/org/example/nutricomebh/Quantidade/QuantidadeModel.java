package org.example.nutricomebh.Quantidade;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Ingrediente.IngredienteModel;

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
    private long quantidade;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private IngredienteModel ingrediente;
}
