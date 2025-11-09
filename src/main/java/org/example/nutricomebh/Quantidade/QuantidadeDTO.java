package org.example.nutricomebh.Quantidade;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.ItemReceita.ItemModel;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeDTO {


    private Long id;
    private BigDecimal quantidade;
    private ItemModel item;
}
