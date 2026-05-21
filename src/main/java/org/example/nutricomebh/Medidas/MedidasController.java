package org.example.nutricomebh.Medidas;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria uma nova medida",description = "Cria uma nova medida")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Medida criada com sucesso"),
            @ApiResponse(responseCode = "401",description = "Erro ao criar uma nova medida")
    })
    public ResponseEntity<MedidasDTO> criarMedidas(@Parameter(description = "O usuario envia a nova medida no corpo da requisição") @RequestBody MedidasDTO medidasDTO) {
        MedidasDTO novaMedida = medidasService.criaMedida(medidasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMedida);
    }
    //Deletar medida
    @DeleteMapping("/deletarMedida/{id}")
    @Operation(summary = "Deleta uma medida",description = "Deleta uma medida do banco de dados, nao esta sendo utilizado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Medida deletada com sucesso"),
            @ApiResponse(responseCode = "404",description = "Erro ao deletar a Medida")
    })
    public ResponseEntity<String> deletarMedidasPorId(@Parameter(description = "O ususario enviara o ID para deletar a medida")@PathVariable Long id) {
        if (medidasService.buscaMedidaPorId(id) != null) {
            medidasService.deletarMedidasPorId(id);
            return ResponseEntity.ok("Medida removida com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medida nao econtrada");
        }
    }
    //Procurar medida por Id
    @GetMapping("/procurarMedidaPorId/{id}")
    @Operation(summary = "Procura medida por ID",description = "Procura um medida no banco de dados atraves do id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Medida encontrada com sucesso"),
            @ApiResponse(responseCode = "404",description = "Medida nao encontrada")
    })
    public ResponseEntity<?> procurarMedidasPorId(@Parameter(description = "O usuario envia o ID no corpo da requisição") @PathVariable Long id) {
        if (medidasService.buscaMedidaPorId(id) != null) {
            medidasService.buscaMedidaPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Medida encontrada");
        } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medida nao econtrada");
        }

    }
    //Mostrar as medidas
    @GetMapping("/mostrarAsMedidas")
    @Operation(summary = "Mostra todas as medidas",description = "Mostra uma lista de todas as medidas salvas no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Sucesso ao procurar a lista de medidas no banco de dados")
    })
    public ResponseEntity<List<MedidasDTO>> mostrarAsMedidas() {
        List<MedidasDTO> medidas = medidasService.listaMedidas();
        return ResponseEntity.status(HttpStatus.OK).body(medidas);
    }
}
