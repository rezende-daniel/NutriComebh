package org.example.nutricomebh.Ingrediente;



import org.example.nutricomebh.Medidas.MedidasDTO;
import org.example.nutricomebh.Medidas.MedidasMapper;
import org.example.nutricomebh.Medidas.MedidasModel;
import org.example.nutricomebh.Medidas.MedidasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/adicionar/ui")
public class IngredienteControllerUI {

    private final MedidasMapper medidasMapper;
    private final MedidasService medidasService;
    private final IngredienteService ingredienteService;

    public IngredienteControllerUI(MedidasMapper medidasMapper, MedidasService medidasService, IngredienteService ingredienteService) {
        this.medidasMapper = medidasMapper;
        this.medidasService = medidasService;
        this.ingredienteService = ingredienteService;
    }

    //Pagina de adicionar geral
    @GetMapping("/paginaAdicionar")
    public String paginaAdicionar() {
        return "adicionar";
    }
    //Pagina de adicionar ingrediente
    @GetMapping("/paginaAdicionarIngrediente")
    public String paginaAdicionarIngrediente(Model model) {
        IngredientesDTO ingredientesDTO = new IngredientesDTO();
        model.addAttribute("ingredientes", ingredientesDTO);
        List<MedidasDTO> listaMedidas = medidasService.listaMedidas();
        model.addAttribute("listaMedidas", listaMedidas);
        return "adicionarIngredienteMedida";
    }
    //Adicona ingrediente junto com a medida
    @PostMapping("/adicionaIngrediente")
    public String adicionaIngrediente(@ModelAttribute IngredientesDTO ingredientes, RedirectAttributes redirectAttributes) {

        ingredienteService.criarIngrediente(ingredientes);
        redirectAttributes.addFlashAttribute("message", "Ingrediente adicionado com sucesso!");
        return "redirect:/";
    }
    //Lista os ingredientes
    @GetMapping("/listaIngredientes")
    public String listaIngredientes(Model model) {
        List<IngredientesDTO> ingredientes =ingredienteService.listarIngredientes();
        model.addAttribute("ingredientes", ingredientes);
        return "listaIngredientes";

    }
    //Pagina de listar ingrediente
    @GetMapping("/paginaListarIngrediente")
    public String paginaListarIngrediente(Model model) {
        List<IngredientesDTO>  listaIngredientes = ingredienteService.listarIngredientes();
        model.addAttribute("ingredientes", listaIngredientes);
        List<MedidasDTO>  listaMedidas = medidasService.listaMedidas();
        model.addAttribute("listaMedidas", listaMedidas);
        return "listarIngredientes";
    }
    //Pagina de editar ingreiente
    @GetMapping("/editarIngredientePagina/{id}")
    public String editarIngredientePagina(@PathVariable long id, Model model) {
        IngredientesDTO ingrediente = ingredienteService.buscarIngredientePorId(id);
        model.addAttribute("ingrediente", ingrediente);
        return "editarIngrediente";
    }
    //atualizar ingrediente
    @PostMapping("/editarIngrediente/{id}")
    public String alterarIngrediente(@PathVariable Long id, IngredientesDTO ingrediente) {
        ingredienteService.alterarIngrediente(ingrediente,id);
        return "redirect:/adicionar/ui/paginaListarIngrediente";
    }

}
