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
    //Gerar lista para excel
    /*
    @GetMapping("/gerarListaExcel")
    public ResponseEntity<byte[]> gerarListaExcel(@RequestBody CardapioDTO cardapioDTO ) throws IOException {
        // 1) Busca cardápio
        //CardapioDTO cardapioDTO = cardapioService.listarCardapioPorId(id);
        System.out.println(cardapioDTO.getId());
        // 2) Consolida ingredientes
        ConsolidadorIngredientes cons = new ConsolidadorIngredientes();
        List<ReceitasModel> todasReceitas = new ArrayList<>();
        todasReceitas.addAll(cardapioDTO.getDiaUm());
        todasReceitas.addAll(cardapioDTO.getDiaDois());
        todasReceitas.addAll(cardapioDTO.getDiaTreis());
        todasReceitas.addAll(cardapioDTO.getDiaQuatro());
        List<ItemDTO> listaFinal = cons.consolidar(todasReceitas);

        // 3) Cria workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Lista de Compras");

        // 4) Cabeçalho
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Ingrediente");
        header.createCell(1).setCellValue("Quantidade");
        header.createCell(2).setCellValue("Unidade");

        // 5) Linhas de dados
        int rowNum = 1;
        for (ItemDTO item : listaFinal) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(item.getIngrediente().getNome());
            row.createCell(1).setCellValue((RichTextString) item.getQuantidade());
            row.createCell(2).setCellValue(item.getMedida().getMedida());
        }

        // 6) Ajusta colunas
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // 7) Converte para byte[]
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        byte[] bytes = out.toByteArray();

        // 8) Monta headers para download
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
        );
        headers.setContentDispositionFormData("attachment", "lista_compras.xlsx");

        // 9) Retorna como ResponseEntity
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }*/

}























