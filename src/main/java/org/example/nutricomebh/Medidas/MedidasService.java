package org.example.nutricomebh.Medidas;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedidasService {

    private final MedidasMapper medidasMapper;
    private final MedidasRepository medidasRepository;

    public MedidasService(MedidasMapper medidasMapper, MedidasRepository medidasRepository) {
        this.medidasMapper = medidasMapper;
        this.medidasRepository = medidasRepository;
    }

    //Adiciona medida
    public MedidasDTO criaMedida(MedidasDTO medidasDTO) {
        MedidasModel medida= medidasMapper.mapMedidas(medidasDTO);
        medida = medidasRepository.save(medida);
        return medidasMapper.mapMedidas(medida);
    }
    //Lista todas as medidas
    public List<MedidasDTO> listaMedidas() {
        List<MedidasModel> listaMedidas = medidasRepository.findAll();
        return listaMedidas.stream().
                map(medidasMapper::mapMedidas).collect(Collectors.toList());

    }
    //Listar medidas por id
    public MedidasDTO buscaMedidaPorId(Long id) {
        Optional<MedidasModel> medidasModel = medidasRepository.findById(id);
        return medidasModel.map(medidasMapper::mapMedidas).orElse(null);
    }
    //Deletar medida
    public void deletarMedidasPorId(Long id) {
        medidasRepository.deleteById(id);
    }

}
