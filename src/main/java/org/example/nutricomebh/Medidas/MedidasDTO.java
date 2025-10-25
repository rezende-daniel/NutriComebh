package org.example.nutricomebh.Medidas;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.ItemReceita.ItemModel;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedidasDTO {

    private Long id;
    private String medida;
    private List<ItemModel> item;
}
