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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardapioService {


    private final CardapioRepository cardapioRepository;
    private final CardapioMapper cardapioMapper;
    private final ReceitasMapper receitasMapper;
    private final BigDecimal conversao = BigDecimal.valueOf(1000);

    public CardapioService(CardapioRepository cardapioRepository, CardapioMapper cardapioMapper, ReceitasMapper receitasMapper) {
        this.cardapioRepository = cardapioRepository;
        this.cardapioMapper = cardapioMapper;
        this.receitasMapper = receitasMapper;
    }

    //Listar o cardapio
    public List<CardapioDTO> listarCardapio(){
        List<CardapioModel> cardapio = cardapioRepository.findAll();
        return cardapio.stream().
                map(cardapioMapper::mapCardapio).collect(Collectors.toList());

    }

    //Listar cardapio por id
    public CardapioDTO listarCardapioPorId(Long id){
        CardapioModel cardapio = cardapioRepository.findById(id).orElse(null);
        return cardapioMapper.mapCardapio(cardapio);
    }
    //Criar novo cardapio
    public CardapioDTO criarCardapio(CardapioDTO cardapioDTO){
        CardapioModel cardapioNovo = cardapioMapper.mapCardapio(cardapioDTO);
        cardapioRepository.save(cardapioNovo);
        System.out.println(cardapioNovo.getId());
        return cardapioMapper.mapCardapio(cardapioNovo);
    }
    //Deletar receita
    public void deletarCardapio(Long id){
        cardapioRepository.deleteById(id);
    }

    //Gerar excel
    public ResponseEntity<byte[]> gerarExcel(CardapioDTO cardapioDTO) throws IOException {

        // Consolida ingredientes
        ConsolidadorIngredientes cons = new ConsolidadorIngredientes();
        List<ReceitasDTO> receitasDTOS = new ArrayList<>();
        for (int i=0; i < cardapioDTO.getReceitasCardapio().size();i++){
             receitasDTOS.add(receitasMapper.mapReceitas( cardapioDTO.getReceitasCardapio().get(i)));
        }

        List<ItemDTO> listaFinal = cons.consolidar (receitasDTOS,cardapioDTO.getNumeroPessoas());

        for (ItemDTO item : listaFinal) {
            if(item.getQuantidade().intValue()>=1000){
                item.setQuantidade(item.getQuantidade().divide(conversao));
                System.out.println("Passou dentro do for");

                if(item.getMedida().getMedida().startsWith("Gr")){
                    item.getMedida().setMedida("Quilos");
                }
                if(item.getMedida().getMedida().toString()=="Ml"){
                    item.getMedida().setMedida("Litro");
                }

            }
        }
        System.out.println("Passou aqui 2");
        listaFinal.stream().map(ItemDTO::getIngrediente).forEach(System.out::println);
        // Cria workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Lista_de_Compras");

        // Cabeçalho
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Ingrediente");
        header.createCell(1).setCellValue("Quantidade");
        header.createCell(2).setCellValue("Unidade");

        // Linhas
        int rowNum = 1;
        for (ItemDTO item : listaFinal) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue( item.getIngrediente().getNome());
            row.createCell(1).setCellValue( item.getQuantidade().toString());
            row.createCell(2).setCellValue( item.getMedida().getMedida());
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Converte para byte[]
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        byte[] bytes = out.toByteArray();

        // Headers para download
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
        );
        headers.setContentDispositionFormData("attachment", "Lista_de_Compras.xlsx");
        System.out.println("Passou aqui 3");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

}
