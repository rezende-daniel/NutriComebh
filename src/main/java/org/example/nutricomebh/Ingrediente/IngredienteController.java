package org.example.nutricomebh.Ingrediente;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class IngredienteController {
    @GetMapping("/adicionaringredientE")
    public String ingrediente(){
        return "Esta sera a pagina para adicionar ingrediente";
    }
    //Adiciona um ingrediente
    @PostMapping("/adicionarIngrediente")
    public String ingrediente(@RequestBody IngredienteModel ingrediente){
        return "Ingrediente adicionado com sucesso";
    }
    //Listar todos os ingredientes
    @GetMapping("/listarIngredientes")
    public String listaIngredientes(){
        return "Ingredientes listados com sucesso";
    }
    //Listar ingredientes por Id
    @GetMapping("/listarIngredientePorId")
    public String listaIngredientesPorId(){
        return "Ingredientes listados com sucesso";
    }

    //Alterar ingrediente
    @PutMapping("/alterarIngrediente")
    public String alterarIngrediente(@RequestBody IngredienteModel ingrediente){
        return "Ingrediente alterado com sucesso";
    }
    //Remover ingrediente
    @DeleteMapping("/deletarIngrediente")
    public String deletarIngrediente(@RequestBody IngredienteModel ingrediente){
        return "Ingrediente deletado com sucesso";
    }

}
