package org.example.nutricomebh.Quantidade;


import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class QuantidadeMapper {
    public QuantidadeModel mapQuantidade(QuantidadeDTO quantidadeDTO) {
        QuantidadeModel quantidadeModel = new QuantidadeModel();
        quantidadeModel.setId(quantidadeDTO.getId());
        quantidadeModel.setQuantidade(quantidadeDTO.getQuantidade());
        quantidadeModel.setItem(quantidadeDTO.getItem());
        return quantidadeModel;
    }
    public QuantidadeDTO mapQuantidade(QuantidadeModel quantidadeModel) {
        QuantidadeDTO quantidadeDTO = new QuantidadeDTO();
        quantidadeDTO.setId(quantidadeModel.getId());
        quantidadeDTO.setQuantidade(quantidadeModel.getQuantidade());
        quantidadeDTO.setItem(quantidadeModel.getItem());
        return quantidadeDTO;
    }
}
