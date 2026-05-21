package org.example.nutricomebh.Quantidade;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quantidade")
public class QuantidadeController {


    private final QuantidadeService quantidadeService;

    public QuantidadeController(QuantidadeService quantidadeService) {
        this.quantidadeService = quantidadeService;
    }

    //Cria quantidade
    @PostMapping("/criaQuantidade")
    @Operation(summary = "Cria a quantidade",description = "Cria a quantidade para ser relacionada com um item dentro de uma receita")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Quantidade criada com sucesso"),
            @ApiResponse(responseCode = "402",description = "Erro na criacao da quantidade")
    })
    public ResponseEntity<String> criaQuantidade(@Parameter(description = "O usario enviara a quantidade no corpo da requisicao para ser relacionada com o ingrediente")
                                                     @RequestBody QuantidadeDTO quantidadeDTO) {
        QuantidadeDTO novaQuantidade = quantidadeService.criarQuantidade(quantidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaQuantidade.toString());
    }
    //Alterar quantidade
    @PutMapping("/alterarQuantidade")
    @Operation(summary = "Altera a quantidade",description = "Altera a quantidade para o ingrediente")
    public ResponseEntity<String> alterarQuantidadade(@Parameter(description = "O usuario envia a nova quantidade para ser atrelada ao item da receita") @RequestBody QuantidadeDTO quantidadeDTO) {
        quantidadeService.atualizarQuantidade(quantidadeDTO, quantidadeDTO.getId());
        return ResponseEntity.status(HttpStatus.OK).body("Quantidade alterado");
    }
}
