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
        cardapioModel.setId(cardapioDTO.getId());
        List<ReceitasModel> receitas1Model = cardapioDTO.getDiaUm().stream()
                .map(receitaDto ->{
            ReceitasModel receitaModel =new ReceitasModel();
            receitaModel.setId(receitaDto.getId());
            receitaModel.setNome(receitaDto.getNome());
            receitaModel.setCategoria(receitaDto.getCategoria());
            return  receitaModel;
                }).toList();
        cardapioModel.setDiaUm(cardapioDTO.getDiaUm());
        cardapioModel.setDiaDois(cardapioDTO.getDiaDois());
        List<ReceitasModel> receitas2Model = cardapioDTO.getDiaDois().stream()
                .map(receitaDto ->{
                    ReceitasModel receitaModel =new ReceitasModel();
                    receitaModel.setId(receitaDto.getId());
                    receitaModel.setNome(receitaDto.getNome());
                    receitaModel.setCategoria(receitaDto.getCategoria());
                    return  receitaModel;
                }).toList();
        cardapioModel.setDiaTreis(cardapioDTO.getDiaTreis());
        List<ReceitasModel> receitas3Model = cardapioDTO.getDiaTreis().stream()
                .map(receitaDto ->{
                    ReceitasModel receitaModel =new ReceitasModel();
                    receitaModel.setId(receitaDto.getId());
                    receitaModel.setNome(receitaDto.getNome());
                    receitaModel.setCategoria(receitaDto.getCategoria());
                    return  receitaModel;
                }).toList();
        cardapioModel.setDiaQuatro(cardapioDTO.getDiaQuatro());
        List<ReceitasModel> receitas4Model = cardapioDTO.getDiaQuatro().stream()
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
        cardapioDTO.setId(cardapioModel.getId());
        List<ReceitasDTO> receitasDTO = cardapioModel.getDiaUm().stream()
                .map(receitasModel -> {
                    ReceitasDTO receitaDTO =new ReceitasDTO();
                    receitaDTO.setId(receitasModel.getId());
                    receitaDTO.setNome(receitasModel.getNome());
                    receitaDTO.setCategoria(receitasModel.getCategoria());
                    return  receitaDTO;
                }).toList();
        cardapioDTO.setDiaUm(cardapioModel.getDiaUm());
        cardapioDTO.setDiaDois(cardapioModel.getDiaDois());
        cardapioDTO.setDiaTreis(cardapioModel.getDiaTreis());
        cardapioDTO.setDiaQuatro(cardapioModel.getDiaQuatro());
        return cardapioDTO;
    }
}
