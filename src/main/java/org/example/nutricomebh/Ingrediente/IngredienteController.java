package org.example.nutricomebh.Ingrediente;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.nutricomebh.Medidas.MedidasDTO;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @GetMapping("/adicionaringredientE")
    public String ingrediente(){
        return "Esta sera a pagina para adicionar ingrediente";
    }



    //Adiciona um ingrediente
    @PostMapping("/adicionarIngrediente")
    @Operation(summary = "Cria um novo ingrediente",description = "Cria um novo ingrediente no BD posteriormente sera atrelado as receitas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Ingrediente salvo com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao criar o ingrediente")
    })
    public ResponseEntity<String> ingrediente(@Parameter(description = "O ingrediente sera enviado no corpo da requisicao para o cadastro no BD") @RequestBody IngredientesDTO ingrediente, MedidasDTO medidasDTO){

        IngredientesDTO novoIngrediente = ingredienteService.criarIngrediente(ingrediente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoIngrediente.toString());
    }



    //Listar todos os ingredientes
    @GetMapping("/listarIngredientes")
    @Operation(summary = "Lista todos os ingredientes",description = "Lista todos os ingredientes presentes no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Listagem de ingredientes feita com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro so listar os ingredientes")
    })
    public ResponseEntity<List<IngredientesDTO>> listaIngredientes(){
        List<IngredientesDTO> ingredientes = ingredienteService.listarIngredientes();
        return ResponseEntity.status(HttpStatus.OK).body(ingredientes);
    }


    //Listar ingredientes por Id
    @GetMapping("/listarIngredientePorId/{id}")
    @Operation(summary = "Lista o ingrediente por ID",description = "Usa o ID do ingrediente para procurar no BD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "O ingrediente foi encontrado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao encontrar o ingrediente por id")
    })
    public ResponseEntity<?> listaIngredientesPorId(@Parameter(description = "O usuario envia o Id do ingrediente no corpo da requisição")@PathVariable Long id){
        if (ingredienteService.buscarIngredientePorId(id) != null){
            ingredienteService.buscarIngredientePorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Ingrediente encontrado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente nao encontrado");
    }

    //Alterar ingrediente
    @PutMapping("/alterarIngrediente")
    @Operation(summary = "Altera o ingrediente",description = "Altera o ingrediente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Ingrediente alterado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao alterar o ingrediente")
    })
    public ResponseEntity<String> alterarIngrediente(@Parameter(description = "Ususario envia o ingrediente a ser alterado no copro da requisição")@RequestBody IngredientesDTO ingrediente){
        if (ingredienteService.buscarIngredientePorId(ingrediente.getId()) != null){
            ingredienteService.alterarIngrediente(ingrediente, ingrediente.getId());
            return ResponseEntity.status(HttpStatus.OK).body("Ingrediente alterado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente nao encontrado");
    }
    //Remover ingrediente
    @DeleteMapping("/deletarIngrediente")
    @Operation(summary = "Deleta o ingrediente",description = "Deleta o ingrediente do BD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Ingrediente deletado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Erro ao deletar o ingrediente")
    })
    public ResponseEntity<String> deletarIngrediente(@RequestBody IngredienteModel ingrediente){
        if (ingredienteService.buscarIngredientePorId(ingrediente.getId()) != null){
            ingredienteService.deletarIngrediente(ingrediente.getId());
            return ResponseEntity.status(HttpStatus.OK).body("Ingrediente deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente nao encontrado");
        }
    }

}
