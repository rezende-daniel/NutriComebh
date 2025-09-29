package org.example.nutricomebh.Quantidade;


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
    public ResponseEntity<String> criaQuantidade(@RequestBody QuantidadeDTO quantidadeDTO) {
        QuantidadeDTO novaQuantidade = quantidadeService.criarQuantidade(quantidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaQuantidade.toString());
    }
    //Alterar quantidade
    @PutMapping("/alterarQuantidade")
    public ResponseEntity<String> alterarQuantidadade(@RequestBody QuantidadeDTO quantidadeDTO) {
        quantidadeService.atualizarQuantidade(quantidadeDTO, quantidadeDTO.getId());
        return ResponseEntity.status(HttpStatus.OK).body("Quantidade alterado");
    }
}
