package org.example.nutricomebh.Receitas;


import org.example.nutricomebh.Categoria.CategoriaDTO;
import org.example.nutricomebh.Categoria.CategoriaService;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Ingrediente.IngredienteService;
import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.example.nutricomebh.ItemReceita.ItemDTO;
import org.example.nutricomebh.Medidas.MedidasDTO;
import org.example.nutricomebh.Medidas.MedidasService;
import org.example.nutricomebh.Quantidade.QuantidadeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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
        //ReceitasDTO receitasDTO = new ReceitasDTO();
        model.addAttribute("receitas",new ReceitasDTO());
        List<IngredientesDTO> listaIngredientes = ingredienteService.listarIngredientes();
        model.addAttribute("listaIngredientes", listaIngredientes);
        List<MedidasDTO> listaMedidas = medidasService.listaMedidas();
        model.addAttribute("listaMedidas", listaMedidas);
        List<CategoriaDTO> listaCategoria = categoriaService.lisarCategorias();
        model.addAttribute("listaCategoria", listaCategoria);
        List<QuantidadeDTO> quantidadeDTO = new ArrayList<>();
        model.addAttribute("quantidade", quantidadeDTO);

        return "adicionarReceita";
    }

    //Adicionar receita
    @PostMapping("/adicionarReceitaBd")
    public String adicionarReceita(@ModelAttribute("receitas") ReceitasDTO receitasDTO,@ModelAttribute List<IngredientesDTO> ingredientesDTO, RedirectAttributes redirectAttributes) {
        System.out.println(ingredientesDTO);
        receitasService.criarReceita(receitasDTO);
        redirectAttributes.addFlashAttribute("message", "Receita adicionado com sucesso!");
        return "redirect:/";
    }
    //Pagina de listar receita
    @GetMapping("/listarReceitas")
    public String listarReceitasPagina(Model model) {
        List<ReceitasDTO> listaReceita = receitasService.listaReceitas();
        model.addAttribute("listaReceitas", listaReceita);
        List<CategoriaDTO> listaCategoria = categoriaService.lisarCategorias();
        model.addAttribute("listaCategoria", listaCategoria);

        return "listarReceitas";
    }
    //Pagina de editar receita
    @GetMapping("/paginaEditarReceita/{id}")
    public String paginaEditarReceita(@PathVariable long id, Model model) {
        ReceitasDTO receita =receitasService.listarReceitasPorId(id);
        model.addAttribute("receita", receita);
        List<CategoriaDTO> listaCategoria = categoriaService.lisarCategorias();
        model.addAttribute("listaCategoria", listaCategoria);
        List<ItemDTO> ingredientes = ingredienteService.listarIngredientesReceita(id);
        model.addAttribute("ingredientes", ingredientes);
        return "editarReceita";
    }




















}
