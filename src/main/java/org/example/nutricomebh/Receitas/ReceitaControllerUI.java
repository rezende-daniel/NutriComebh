package org.example.nutricomebh.Receitas;


import org.example.nutricomebh.Categoria.CategoriaDTO;
import org.example.nutricomebh.Categoria.CategoriaService;
import org.example.nutricomebh.Ingrediente.IngredienteModel;
import org.example.nutricomebh.Ingrediente.IngredienteService;
import org.example.nutricomebh.Ingrediente.IngredientesDTO;
import org.example.nutricomebh.ItemReceita.ItemDTO;
import org.example.nutricomebh.ItemReceita.ItemService;
import org.example.nutricomebh.Medidas.MedidasDTO;
import org.example.nutricomebh.Medidas.MedidasService;
import org.example.nutricomebh.Quantidade.QuantidadeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.classfile.Opcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
@RequestMapping("/receita/ui")
public class ReceitaControllerUI {


    private final IngredienteService ingredienteService;
    private final MedidasService medidasService;
    private final ReceitasService receitasService;
    private final CategoriaService categoriaService;
    private final ItemService itemService;

    public ReceitaControllerUI(IngredienteService ingredienteService, MedidasService medidasService, ReceitasService receitasService, CategoriaService categoriaService, ItemService itemService) {
        this.ingredienteService = ingredienteService;
        this.medidasService = medidasService;
        this.receitasService = receitasService;
        this.categoriaService = categoriaService;
        this.itemService = itemService;
    }

    //Pagina de adicionar de receita
    @GetMapping("/adicionarReceita")
    public String adicionarReceitaPagina(Model model) {
        //ReceitasDTO receitasDTO = new ReceitasDTO();
        model.addAttribute("receita",new ReceitasDTO());
        model.addAttribute("listaCategoria",categoriaService.lisarCategorias());
        model.addAttribute("listaIngredientes",ingredienteService.listarIngredientes());
        model.addAttribute("ListarMedidas",medidasService.listaMedidas());

        return "adicionarReceita";
    }

    //Adicionar receita
    @PostMapping("/adicionarReceitaBd")
    public String adicionarReceita(@ModelAttribute("receita") ReceitasDTO receitasDTO,@ModelAttribute("listaIngredientes") List<IngredientesDTO> ingredientesDTO,@ModelAttribute("ListarMedidas") List<MedidasDTO> medidasDTO,@ModelAttribute List<QuantidadeDTO> quantidadeDTO,RedirectAttributes redirectAttributes) {
        System.out.println(ingredientesDTO);
        System.out.println(medidasDTO);
        System.out.println(quantidadeDTO);
        System.out.println(receitasDTO);
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
        /*List<ItemDTO> itens = itemService.listarIngredientesReceita(id);
        model.addAttribute("itens", itens );*/
        List<MedidasDTO> medidas = medidasService.listaMedidas();
        model.addAttribute("medidas", medidas );
        return "editarReceita";
    }




















}
