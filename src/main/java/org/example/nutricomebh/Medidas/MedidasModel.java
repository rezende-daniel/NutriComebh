package org.example.nutricomebh.Medidas;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.Ingrediente.IngredienteModel;

import java.util.List;

@Entity
@Table(name = "tb_medidas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedidasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "nome_medida")
    private String medida;


    @OneToMany(mappedBy = "medidas")
    @JsonIgnore
    private List<IngredienteModel> ingredientes;


}
