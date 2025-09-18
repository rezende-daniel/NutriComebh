package org.example.nutricomebh.Categoria;


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
    public ResponseEntity<String> adicionarCategoria(@RequestBody CategoriaDTO  categoria){
        CategoriaDTO novaCategoria = categoriaService.createCategoria(categoria);
        return  ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria.toString());
    }

    //Deletar categoria

    @DeleteMapping("/deletarCategoria/{id}")
    public ResponseEntity<String> deletarCategoria(@PathVariable Long id){
        if(categoriaService.listarCategoriaId(id)!=null){
            categoriaService.deletarCategoria(id);
            return ResponseEntity.ok("Categoria deletada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria nao encontrada");
        }
    }
    //Pesquisar categoria por id
    @GetMapping("/procurarCategoriaPorId/{id}")
    public ResponseEntity<?> procurarCategoriaPorId(@PathVariable Long id){
        if(categoriaService.listarCategoriaId(id)!=null){
            categoriaService.listarCategoriaId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Categoria encontrada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria nao encontrada");
        }
    }
    //Listar categorias
    @GetMapping("/mostrarCategoria")
    private ResponseEntity<List<CategoriaDTO>> mostrarCategoria(){
        List<CategoriaDTO> categorias =categoriaService.lisarCategorias();
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

}
