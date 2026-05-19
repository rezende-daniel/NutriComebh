package org.example.nutricomebh.Categoria;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    //Adicionar categoria
    @PostMapping("/adicionarCategoria")
    @Operation(summary = "Cria uma categoria",description = "Cria uma nova categoria,estou utilizando o console do H2 para fazer a novas categorias, o sistema foi pensado para ter apenas duas ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Categoria criada com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao crira a categoria")
    })
    public ResponseEntity<String> adicionarCategoria(@Parameter(description = "Usuario envia a nova categoria pelo corpo da requiseção") @RequestBody CategoriaDTO  categoria){
        CategoriaDTO novaCategoria = categoriaService.createCategoria(categoria);
        return  ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria.toString());
    }

    //Deletar categoria
    @DeleteMapping("/deletarCategoria/{id}")
    @Operation(summary = "Deleta categoria",description = "Deleta a categoria usando o ID como parametro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Categoria deletada com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao deletar a categoria")
    })
    public ResponseEntity<String> deletarCategoria(@Parameter(description = "O ususario envia no corpo da requisição o Id para deletar a categoria")@PathVariable Long id){
        if(categoriaService.listarCategoriaId(id)!=null){
            categoriaService.deletarCategoria(id);
            return ResponseEntity.ok("Categoria deletada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria nao encontrada");
        }
    }
    //Pesquisar categoria por id
    @GetMapping("/procurarCategoriaPorId/{id}")
    @Operation(summary = "Pesquia a categoria",description = "Pesquisa a categoria usando o Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Sucesso ao pesquisa a categoria"),
            @ApiResponse(responseCode = "400",description = "Erro ao pesquisar")
    })
    public ResponseEntity<?> procurarCategoriaPorId(@Parameter(description = "Usuario envia o ID para a pesquisa no corpo da requisição")@PathVariable Long id){
        if(categoriaService.listarCategoriaId(id)!=null){
            categoriaService.listarCategoriaId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Categoria encontrada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria nao encontrada");
        }
    }
    //Listar categorias
    @GetMapping("/mostrarCategoria")
    @Operation(summary = "Lista categoria",description = "Lista as categorias para atrelar a receita")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Lista as categorias"),
            @ApiResponse(responseCode = "400",description = "Erro ao listar as categorias")
    })
    private ResponseEntity<List<CategoriaDTO>> mostrarCategoria(){
        List<CategoriaDTO> categorias =categoriaService.lisarCategorias();
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

}
