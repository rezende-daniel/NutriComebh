package org.example.nutricomebh.Ingrediente;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IngredienteController {
    @GetMapping("/adicionaringrediente")
    public String ingrediente(){
        return "Esta sera a pagina para adicionar ingrediente";
    }
}
