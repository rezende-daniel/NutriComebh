package org.example.nutricomebh.Categoria;


import org.example.nutricomebh.Receitas.ReceitasDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaService {
    private final CategoriaMapper categoriaMapper;
    private final CategoriaRepository categoriaRepository;
    private final ReceitasDTO receitasDTO;

    public CategoriaService(CategoriaMapper categoriaMapper, CategoriaRepository categoriaRepository, ReceitasDTO receitasDTO) {
        this.categoriaMapper = categoriaMapper;
        this.categoriaRepository = categoriaRepository;
        this.receitasDTO = receitasDTO;
    }

    //Listar todas as categorias
    public List<CategoriaDTO> lisarCategorias() {
        List<CategoriaModel> categorias = categoriaRepository.findAll();
        return categorias.stream().
                map(categoriaMapper::mapCategoria)
                .collect(Collectors.toList());
    }
    //Cria nova categoria
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        CategoriaModel categoria = categoriaMapper.mapCategoria(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.mapCategoria(categoria);
    }
    //Deleta categoria
    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
    //Adicionar receita na categoria
    public CategoriaDTO adicionarReceitaCategoria(List<ReceitasDTO> receita, int id){
        CategoriaModel receitaAddCategoria = categoriaMapper.mapCategoria((CategoriaDTO) receita);
        receitaAddCategoria.setId(id);
        receitaAddCategoria = categoriaRepository.save(receitaAddCategoria);

        return categoriaMapper.mapCategoria(receitaAddCategoria);
    }
}git
