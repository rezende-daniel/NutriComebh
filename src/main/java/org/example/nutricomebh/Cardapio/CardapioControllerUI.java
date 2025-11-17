package org.example.nutricomebh.Cardapio;


import org.example.nutricomebh.Categoria.CategoriaService;
import org.example.nutricomebh.Receitas.ReceitasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cardapio/ui")
public class CardapioControllerUI {

    private final CategoriaService categoriaService;
    private final ReceitasService receitasService;

    public CardapioControllerUI(CategoriaService categoriaService, ReceitasService receitasService) {
        this.categoriaService = categoriaService;
        this.receitasService = receitasService;
    }

    //Pagina de cardapio
    @GetMapping("/paginaCardapio")
    public String paginaCardapio(Model model) {
        model.addAttribute("lanche",receitasService.listarReceitaPorCategoria(1l));
        model.addAttribute("refeicao",receitasService.listarReceitaPorCategoria(2l));
        model.addAttribute("cardapio",new CardapioDTO());
        return "cardapio";
    }
}
