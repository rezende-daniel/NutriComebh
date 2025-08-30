package org.example.nutricomebh;


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
public class medidas {

    @Column(name = "medidas")
    private String medida;


}
