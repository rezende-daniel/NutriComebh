package org.example.nutricomebh.Medidas;


import org.springframework.stereotype.Component;

@Component
public class MedidasMapper {

 public MedidasModel mapMedidas(MedidasDTO medidasDTO) {
     MedidasModel medidasModel = new MedidasModel();
     medidasModel.setId(medidasDTO.getId());
     medidasModel.setMedida(medidasDTO.getMedida());
     return medidasModel;
 }
 public MedidasDTO mapMedidas(MedidasModel medidasModel) {
     MedidasDTO medidasDTO = new MedidasDTO();
     medidasDTO.setId(medidasModel.getId());
     medidasDTO.setMedida(medidasModel.getMedida());
     return medidasDTO;
 }



}

