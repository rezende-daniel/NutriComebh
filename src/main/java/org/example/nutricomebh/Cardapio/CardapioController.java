package org.example.nutricomebh.Cardapio;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {


    private final CardapioService cardapioService;

    public CardapioController(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    //Adicionar cardapio
    @PostMapping("/criarCardapio")
    public ResponseEntity<String> criarCardapio(@RequestBody CardapioDTO cardapioDTO){
        CardapioDTO novoCardapio = cardapioService.criarCardapio(cardapioDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(novoCardapio.toString());
    }

    //Deleta cardapio
    @DeleteMapping("/deletarCardapio/{id}")
    public ResponseEntity<String> deletarCardapio(@PathVariable Long id){
        cardapioService.deletarCardapio(id);
        return ResponseEntity.ok().body("Cardapio deletado com sucesso");
    }
    //Procurar cardapio por Id
    @GetMapping("/procurarCardapioPorId/{id}")
    public ResponseEntity<?> procurarCardapioPorId(@PathVariable Long id){
        if (cardapioService.listarCardapioPorId(id)!=null){
            return ResponseEntity.ok(cardapioService.listarCardapioPorId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cardapior nao existe");
        }
    }

}
