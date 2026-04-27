package org.example.nutricomebh.Cardapio;


import org.example.nutricomebh.Categoria.CategoriaService;
import org.example.nutricomebh.Receitas.ReceitasDTO;
import org.example.nutricomebh.Receitas.ReceitasService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/cardapio/ui")
public class CardapioControllerUI {

    private final CategoriaService categoriaService;
    private final ReceitasService receitasService;
    private final CardapioService cardapioService;

    public CardapioControllerUI(CategoriaService categoriaService, ReceitasService receitasService, CardapioService cardapioService) {
        this.categoriaService = categoriaService;
        this.receitasService = receitasService;
        this.cardapioService = cardapioService;
    }

    //Pagina de cardapio
    @GetMapping("/paginaCardapio")
    public String paginaCardapio(Model model) {
        model.addAttribute("lanche",receitasService.listarReceitaPorCategoria(1l));
        model.addAttribute("refeicao",receitasService.listarReceitaPorCategoria(2l));
        model.addAttribute("cardapio",new CardapioDTO());
        return "cardapio";
    }
    //Cria cardapio
    @PostMapping("/criarCardapio")
    public ResponseEntity<byte[]> criaCardapio(@ModelAttribute CardapioDTO cardapioDTO, RedirectAttributes redirectAttributes) throws IOException {
       // cardapioService.criarCardapio(cardapioDTO);
        ResponseEntity<byte[]>excel = cardapioService.gerarExcel(cardapioDTO);
        redirectAttributes.addFlashAttribute("menssagem","Cardapio gerado com sucesso");
        return excel;
    }

}
