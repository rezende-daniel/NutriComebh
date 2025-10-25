package org.example.nutricomebh.Receitas;


import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitasController {


    private final ReceitasService receitasService;

    public ReceitasController(ReceitasService receitasService) {
        this.receitasService = receitasService;
    }

    //Adiciona receita
    @PostMapping("/criaReceita")
    public ResponseEntity<String> criaReceita(@RequestBody ReceitasDTO receitas,@RequestBody List< IngredientesDTO> ingredientes){

        ReceitasDTO novaReceita = receitasService.criarReceita(receitas);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReceita.toString());
    }

    //Deleta receita
    @DeleteMapping("/deletaReceita/{id}")
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
    private ResponseEntity<?> procurarReceitaPorId(@RequestParam Long id){
        if (receitasService.listarReceitasPorId(id) != null){
            receitasService.listarReceitasPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(receitasService.listarReceitasPorId(id));
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita inexistente");
        }
    }
    //Edita receita
    @PutMapping("/editaReceita/{id}")
    public ResponseEntity<String> editaReceita(@RequestBody ReceitasDTO receitaAtualizada,@PathVariable Long id){
        if (receitasService.listarReceitasPorId(id) != null){
            receitasService.editarReceita(receitaAtualizada, id);
            return ResponseEntity.status(HttpStatus.OK).body("Receita editada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita inexistente");
        }
    }
    //Listar receitas
    @GetMapping("/mostrarAsReceitas")
    private ResponseEntity<List<ReceitasDTO>> mostrarAsReceitas(){
        List<ReceitasDTO> receitas = receitasService.listaReceitas();
        return ResponseEntity.status(HttpStatus.OK).body(receitas);
    }

}
