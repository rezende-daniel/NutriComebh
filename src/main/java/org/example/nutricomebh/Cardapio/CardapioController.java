package org.example.nutricomebh.Cardapio;


import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.nutricomebh.ItemReceita.ItemDTO;
import org.example.nutricomebh.Receitas.ReceitasDTO;
import org.example.nutricomebh.Receitas.ReceitasMapper;
import org.example.nutricomebh.Receitas.ReceitasModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cardapio")
public class CardapioController {


    private final CardapioService cardapioService;
    private final CardapioRepository cardapioRepository;
    private final ReceitasMapper receitasMapper;
    private final CardapioMapper cardapioMapper;

    public CardapioController(CardapioService cardapioService, CardapioRepository cardapioRepository, ReceitasMapper receitasMapper, CardapioMapper cardapioMapper) {
        this.cardapioService = cardapioService;
        this.cardapioRepository = cardapioRepository;
        this.receitasMapper = receitasMapper;
        this.cardapioMapper = cardapioMapper;
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























