package org.example.nutricomebh.Receitas;


import org.example.nutricomebh.Categoria.CategoriaDTO;
import org.example.nutricomebh.Categoria.CategoriaService;
import org.example.nutricomebh.Ingrediente.IngredienteService;
import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.example.nutricomebh.Medidas.MedidasDTO;
import org.example.nutricomebh.Medidas.MedidasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/receita/ui")
public class ReceitaControllerUI {


    private final IngredienteService ingredienteService;
    private final MedidasService medidasService;
    private final ReceitasService receitasService;
    private final CategoriaService categoriaService;

    public ReceitaControllerUI(IngredienteService ingredienteService, MedidasService medidasService, ReceitasService receitasService, CategoriaService categoriaService) {
        this.ingredienteService = ingredienteService;
        this.medidasService = medidasService;
        this.receitasService = receitasService;
        this.categoriaService = categoriaService;
    }

    //Pagina de adicionar de receita
    @GetMapping("/adicionarReceita")
    public String adicionarReceitaPagina(Model model) {
        ReceitasDTO receitasDTO = new ReceitasDTO();
        model.addAttribute("receitas", receitasDTO);
        List<IngredientesDTO> listaIngredientes = ingredienteService.listarIngredientes();
        model.addAttribute("listaIngredientes", listaIngredientes);
        List<MedidasDTO> listaMedidas = medidasService.listaMedidas();
        model.addAttribute("listaMedidas", listaMedidas);
        List<CategoriaDTO> listaCategoria = categoriaService.lisarCategorias();
        model.addAttribute("listaCategoria", listaCategoria);
        return "adicionarReceita";
    }

    //Adicionar receita
    @PostMapping("/adicionarReceitaBd")
    public String adicionarReceita(@ModelAttribute ReceitasDTO receitasDTO, RedirectAttributes redirectAttributes) {
        receitasService.criarReceita(receitasDTO);
        redirectAttributes.addFlashAttribute("message", "Receita adicionado com sucesso!");
        return "redirect:/";
    }





















}
