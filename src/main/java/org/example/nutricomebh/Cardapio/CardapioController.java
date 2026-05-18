package org.example.nutricomebh.Cardapio;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria um cardapio",description = "Cria um cardapio no BD para salvar os dados, ainda não tem mostra de cardapio mas podera ser utilizado no futuro,usado para gerar os arquivos excel")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201",description = "Cardapio criado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro na criação do cardapio")
    })
    public ResponseEntity<String> criarCardapio(
            @Parameter(description = "O cardapio com a lista de receitas sera enviado")@RequestBody CardapioDTO cardapioDTO){

        CardapioDTO novoCardapio = cardapioService.criarCardapio(cardapioDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(novoCardapio.toString());
    }

    //Deleta cardapio
    @DeleteMapping("/deletarCardapio/{id}")
    @Operation(summary = "Deleta um cardapio",description = "Procura um cardapio usando o ID e deleta, ainda nao tem uso")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201",description = "Cardapio deletado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Erro ao deletar o cardapio")
    })
    public ResponseEntity<String> deletarCardapio(@Parameter(description = "Usuario manda no corpo da requisição o ID para apagar o cardapio")@PathVariable Long id){
        cardapioService.deletarCardapio(id);
        return ResponseEntity.ok().body("Cardapio deletado com sucesso");
    }

    //Procurar cardapio por Id
    @GetMapping("/procurarCardapioPorId/{id}")
    @Operation(summary = "Procura um cardapio por ID",description = "Procura um cardapio no BD usando o ID, ainda não tem uso")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201",description = "Cardapio encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Cardapio não encontrado")
    })
    public ResponseEntity<?> procurarCardapioPorId(@Parameter(description = "Usuario envia no corpo da requisição o Id para realizar a pesquisa")@PathVariable Long id){
        if (cardapioService.listarCardapioPorId(id)!=null){
            return ResponseEntity.ok(cardapioService.listarCardapioPorId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cardapior nao existe");
        }
    }


}























