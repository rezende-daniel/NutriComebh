package org.example.nutricomebh.Cardapio;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class CardapioMapper {
    public CardapioModel mapCardapio(CardapioDTO cardapioDTO){
        CardapioModel cardapioModel = new CardapioModel();
        cardapioModel.setId(cardapioDTO.getId());
        cardapioModel.setDiaUm(cardapioDTO.getDiaUm());
        cardapioModel.setDiaDois(cardapioDTO.getDiaDois());
        cardapioModel.setDiaTreis(cardapioDTO.getDiaTreis());
        cardapioModel.setDiaQuatro(cardapioDTO.getDiaQuatro());
        return cardapioModel;
    }
    public CardapioDTO mapCardapio(CardapioModel cardapioModel){
        CardapioDTO cardapioDTO = new CardapioDTO();
        cardapioDTO.setId(cardapioModel.getId());
        cardapioDTO.setDiaUm(cardapioModel.getDiaUm());
        cardapioDTO.setDiaDois(cardapioModel.getDiaDois());
        cardapioDTO.setDiaTreis(cardapioModel.getDiaTreis());
        cardapioDTO.setDiaQuatro(cardapioModel.getDiaQuatro());
        return cardapioDTO;
    }
}
