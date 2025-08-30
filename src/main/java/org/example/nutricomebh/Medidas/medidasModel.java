package org.example.nutricomebh.Medidas;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_medidas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class medidasModel {

    @Column(name = "medidas")
    private String medida;


}
