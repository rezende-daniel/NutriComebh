package org.example.nutricomebh.Ingrediente;



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
    public ResponseEntity<String> ingrediente(@RequestBody IngredientesDTO ingrediente, MedidasDTO medidasDTO){

        IngredientesDTO novoIngrediente = ingredienteService.criarIngrediente(ingrediente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoIngrediente.toString());
    }



    //Listar todos os ingredientes
    @GetMapping("/listarIngredientes")
    public ResponseEntity<List<IngredientesDTO>> listaIngredientes(){
        List<IngredientesDTO> ingredientes = ingredienteService.listarIngredientes();
        return ResponseEntity.status(HttpStatus.OK).body(ingredientes);
    }
    //Listar ingredientes por Id
    @GetMapping("/listarIngredientePorId/{id}")
    public ResponseEntity<?> listaIngredientesPorId(@PathVariable Long id){
        if (ingredienteService.buscarIngredientePorId(id) != null){
            ingredienteService.buscarIngredientePorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Ingrediente encontrado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente nao encontrado");
    }

    //Alterar ingrediente
    @PutMapping("/alterarIngrediente")
    public ResponseEntity<String> alterarIngrediente(@RequestBody IngredientesDTO ingrediente){
        if (ingredienteService.buscarIngredientePorId(ingrediente.getId()) != null){
            ingredienteService.alterarIngrediente(ingrediente, ingrediente.getId());
            return ResponseEntity.status(HttpStatus.OK).body("Ingrediente alterado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente nao encontrado");
    }
    //Remover ingrediente
    @DeleteMapping("/deletarIngrediente")
    public ResponseEntity<String> deletarIngrediente(@RequestBody IngredienteModel ingrediente){
        if (ingredienteService.buscarIngredientePorId(ingrediente.getId()) != null){
            ingredienteService.deletarIngrediente(ingrediente.getId());
            return ResponseEntity.status(HttpStatus.OK).body("Ingrediente deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente nao encontrado");
        }
    }

}
