package org.example.nutricomebh.Medidas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medidas")
public class MedidasController {

    private final MedidasService medidasService;

    public MedidasController(MedidasService medidasService) {
        this.medidasService = medidasService;
    }

    //Cria medida
    @PostMapping("/criaMedida")
    public ResponseEntity<MedidasDTO> criarMedidas(@RequestBody MedidasDTO medidasDTO) {
        MedidasDTO novaMedida = medidasService.criaMedida(medidasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMedida);
    }
    //Deletar medida
    @DeleteMapping("/deletarMedida/{id}")
    public ResponseEntity<String> deletarMedidasPorId(@PathVariable Long id) {
        if (medidasService.buscaMedidaPorId(id) != null) {
            medidasService.deletarMedidasPorId(id);
            return ResponseEntity.ok("Medida removida com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medida nao econtrada");
        }
    }
    //Procurar medida por Id
    @GetMapping("/procurarMedidaPorId/{id}")
    public ResponseEntity<?> procurarMedidasPorId(@PathVariable Long id) {
        if (medidasService.buscaMedidaPorId(id) != null) {
            medidasService.buscaMedidaPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Medida encontrada");
        } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medida nao econtrada");
        }

    }
    //Mostrar as medidas
    @GetMapping("/mostrarAsMedidas")
    public ResponseEntity<List<MedidasDTO>> mostrarAsMedidas() {
        List<MedidasDTO> medidas = medidasService.listaMedidas();
        return ResponseEntity.status(HttpStatus.OK).body(medidas);
    }
}
