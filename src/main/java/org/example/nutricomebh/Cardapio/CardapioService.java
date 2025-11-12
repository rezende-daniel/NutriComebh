package org.example.nutricomebh.Cardapio;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardapioService {


    private final CardapioRepository cardapioRepository;
    private final CardapioMapper cardapioMapper;

    public CardapioService(CardapioRepository cardapioRepository, CardapioMapper cardapioMapper) {
        this.cardapioRepository = cardapioRepository;
        this.cardapioMapper = cardapioMapper;
    }

    //Listar o cardapio
    public List<CardapioDTO> listarCardapio(){
        List<CardapioModel> cardapio = cardapioRepository.findAll();
        return cardapio.stream().
                map(cardapioMapper::mapCardapio).collect(Collectors.toList());

    }

    //Listar cardapio por id
    public CardapioDTO listarCardapioPorId(Long id){
        CardapioModel cardapio = cardapioRepository.findById(id).orElse(null);
        return cardapioMapper.mapCardapio(cardapio);
    }
    //Criar novo cardapio
    public CardapioDTO criarCardapio(CardapioDTO cardapioDTO){
        CardapioModel cardapioNovo = cardapioMapper.mapCardapio(cardapioDTO);
        cardapioRepository.save(cardapioNovo);
        return cardapioMapper.mapCardapio(cardapioNovo);
    }
    //Deletar receita
    public void deletarCardapio(Long id){
        cardapioRepository.deleteById(id);
    }


}
