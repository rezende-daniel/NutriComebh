package org.example.nutricomebh.Quantidade;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuantidadeService {

    private final QuantidadeMapper quantidadeMapper;
    private final QuantidadeRepository quantidadeRepository;

    public QuantidadeService(QuantidadeMapper quantidadeMapper, QuantidadeRepository quantidadeRepository) {
        this.quantidadeMapper = quantidadeMapper;
        this.quantidadeRepository = quantidadeRepository;
    }

    //Criar nova quantidade
    public QuantidadeDTO criarQuantidade(QuantidadeDTO quantidade) {
        QuantidadeModel novaQuantidade = quantidadeMapper.mapQuantidade(quantidade);
        novaQuantidade = quantidadeRepository.save(novaQuantidade);
        return quantidadeMapper.mapQuantidade(novaQuantidade);

    }
    //Editar quantidade
    public QuantidadeDTO atualizarQuantidade(QuantidadeDTO quantidade,Long id) {
        Optional<QuantidadeModel> quantidadeModel = quantidadeRepository.findById(id);
        if (quantidadeModel.isPresent()) {
            QuantidadeModel novaquantidade = quantidadeMapper.mapQuantidade(quantidade);
            novaquantidade.setId(id);
            QuantidadeModel novaquantidadeModel = quantidadeRepository.save(novaquantidade);
            return quantidadeMapper.mapQuantidade(novaquantidade);
        }return null;
    }
}
