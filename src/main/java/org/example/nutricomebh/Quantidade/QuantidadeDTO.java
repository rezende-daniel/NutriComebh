package org.example.nutricomebh.Quantidade;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nutricomebh.ItemReceita.ItemModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeDTO {


    private Long id;
    private double quantidade;
    private ItemModel item;
}
