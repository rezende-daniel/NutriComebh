package org.example.nutricomebh.Cardapio;

import jakarta.persistence.Column;
import org.example.nutricomebh.Receitas.ReceitasDTO;
import org.example.nutricomebh.Receitas.ReceitasModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardapioMapper {
    public CardapioModel mapCardapio(CardapioDTO cardapioDTO){
        CardapioModel cardapioModel = new CardapioModel();
        cardapioModel.setNumeroPessoas(cardapioDTO.getNumeroPessoas());
        cardapioModel.setId(cardapioDTO.getId());
        List<ReceitasModel> receitas = cardapioDTO.getReceitasCardapio().stream()
                .map(receitaDto ->{
            ReceitasModel receitaModel =new ReceitasModel();
            receitaModel.setId(receitaDto.getId());
            receitaModel.setNome(receitaDto.getNome());
            receitaModel.setCategoria(receitaDto.getCategoria());
            return  receitaModel;
                }).toList();

            return cardapioModel;
    }
    public CardapioDTO mapCardapio(CardapioModel cardapioModel){
        CardapioDTO cardapioDTO = new CardapioDTO();
        cardapioDTO.setNumeroPessoas(cardapioModel.getNumeroPessoas());
        cardapioDTO.setId(cardapioModel.getId());
        List<ReceitasDTO> receitas1DTO = cardapioModel.getReceitasCardapio().stream()
                .map(receitasModel -> {
                    ReceitasDTO receitaDTO =new ReceitasDTO();
                    receitaDTO.setId(receitasModel.getId());
                    receitaDTO.setNome(receitasModel.getNome());
                    receitaDTO.setCategoria(receitasModel.getCategoria());
                    return  receitaDTO;
                }).toList();

        return cardapioDTO;
    }
}
