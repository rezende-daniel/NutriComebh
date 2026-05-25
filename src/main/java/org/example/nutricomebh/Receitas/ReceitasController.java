package org.example.nutricomebh.Receitas;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/receitas")
public class ReceitasController {


    private final ReceitasService receitasService;
    private final ReceitasRepository receitasRepository;
    private final ReceitasMapper receitasMapper;

    public ReceitasController(ReceitasService receitasService, ReceitasRepository receitasRepository, ReceitasMapper receitasMapper) {
        this.receitasService = receitasService;
        this.receitasRepository = receitasRepository;
        this.receitasMapper = receitasMapper;
    }

    //Adiciona receita
    @PostMapping("/criaReceita")
    @Operation(summary = "Cria uma receita",description = "Cria a receita com todas as entidades,item e categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Receita criada com sucesso"),
            @ApiResponse(responseCode = "402",description = "Erro ao crira a receita")
    })
    public ResponseEntity<String> criaReceita(@Parameter(description = "O usuario enviara no corpo da requisicao toda a receita e suas entidades") @RequestBody ReceitasDTO receitas){

        ReceitasDTO novaReceita = receitasService.criarReceita(receitas);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReceita.toString());
    }

    //Deleta receita
    @DeleteMapping("/deletaReceita/{id}")
    @Operation(summary = "Deleta a receita",description = "Deleta a receita do banco de dados usando o ID,esta rota nao esta presente na aplicacao por motivos de seguranca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Receita removida com sucesso"),
            @ApiResponse(responseCode = "404",description = "Erro ao deletar a receita")
    })
    public ResponseEntity<String> deletaReceita(@PathVariable Long id){
        if (receitasService.listarReceitasPorId(id) == null){
            receitasService.deletarReceita(id);
            return ResponseEntity.ok().body("Receita deletada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita inexistente");
        }
    }
    //Procura receita por ID
    @GetMapping("/procurarReceitaPorId/{id}")
    @Operation(summary = "Procura receita por Id",description = "Usa o id passado pelo usuario para fazer a pesquisa no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Pesquisa por Id realizada com sucesso"),
            @ApiResponse(responseCode = "402",description = "Erro ao procurar receita por id")
    })
    private ResponseEntity<?> procurarReceitaPorId(@Parameter(description = "Usuario passa o id no corpo da requisicao") @PathVariable Long id){
        if (receitasService.listarReceitasPorId(id) != null){
            receitasService.listarReceitasPorId(id);

            return ResponseEntity.status(HttpStatus.OK).body(receitasService.listarReceitasPorId(id));
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita inexistente");
        }
    }
    //Edita receita
    @PutMapping("/editarReceita/{id}")
    @Operation(summary = "Edita receita",description = "Edita a receita escolhida pelo usuario, atualmente ela sobrescreve a receita antiga")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Receita editada com sucesso"),
            @ApiResponse(responseCode = "404",description = "Erro ao editar a receita")
    })
    public ResponseEntity<String> editaReceita(@Parameter(description = "Usuario manda no corpo da requisicao a receita editada") @RequestBody ReceitasDTO receitaAtualizada,
                                               @Parameter(description = "Id vem no corpo da requisicao e sera usado para identificar a receita a ser sobre escrita") @PathVariable Long id){
        if (receitasService.listarReceitasPorId(id) != null){
            receitasService.editarReceita(receitaAtualizada, id);
            return ResponseEntity.status(HttpStatus.OK).body("Receita editada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita inexistente");
        }
    }
    //Listar receitas
    @GetMapping("/mostrarAsReceitas")
    @Operation(summary = "Lista todas as receitas",description = "Lista todas as receitas cadastradas no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Listagem feita com sucesso"),
            @ApiResponse(responseCode = "404",description = "Erro ao listar as receitas")
    })
    private ResponseEntity<List<ReceitasDTO>> mostrarAsReceitas(){
        List<ReceitasDTO> receitas = receitasService.listaReceitas();
        return ResponseEntity.status(HttpStatus.OK).body(receitas);
    }
    //Listar receita por categoria
    @GetMapping("/mostrarPorCategoria")
    @Operation(summary = "Lista as receitas por Categoria",description = "Pesquisa e lista as receitas pela categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Listagem por categoria feita com sucesso"),
            @ApiResponse(responseCode = "404",description = "Listagem por categoria falhou")
    })
public ResponseEntity<List<ReceitasDTO>> mostrarPorCategoria(@Parameter(description = "Sistema utiliza a categoria para montar a lista de receitas no cardapio") @RequestBody Long categoria){
        List <ReceitasDTO> receitasCategoria = receitasService.listarReceitaPorCategoria(categoria);

        return ResponseEntity.status(HttpStatus.OK).body(receitasCategoria);
    }
}
