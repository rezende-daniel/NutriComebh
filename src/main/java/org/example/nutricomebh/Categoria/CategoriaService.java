package org.example.nutricomebh.Categoria;


import java.util.List;
import java.util.stream.Collectors;

public class CategoriaService {
    private final CategoriaMapper categoriaMapper;
    private final CategoriaRepository categoriaRepository;
    private final ReceitaMapper receitaMapper;

    public CategoriaService(CategoriaMapper categoriaMapper, CategoriaRepository categoriaRepository, ReceitaMapper receitaMapper) {
        this.categoriaMapper = categoriaMapper;
        this.categoriaRepository = categoriaRepository;
        this.receitaMapper = receitaMapper;
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
    public CategoriaDTO adicionarReceitaCategoria(List<ReceitaDTO> receita,Long id){
        CategoriaModel receitaAdicionada = categoriaMapper.mapCategoria((CategoriaDTO),receita );
        receitaAdicionada = categoriaRepository.save(receitaAdicionada);
        return categoriaMapper.mapCategoria(receitaAdicionada);
    }
}
