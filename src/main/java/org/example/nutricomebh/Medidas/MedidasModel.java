package org.example.nutricomebh.Medidas;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_medidas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedidasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medidas")
    private String medida;


}
