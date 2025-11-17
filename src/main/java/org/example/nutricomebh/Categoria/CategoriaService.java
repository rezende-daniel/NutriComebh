package org.example.nutricomebh.Categoria;


import org.example.nutricomebh.Receitas.ReceitasDTO;
import org.example.nutricomebh.Receitas.ReceitasMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    private final CategoriaMapper categoriaMapper;
    private final CategoriaRepository categoriaRepository;
    private final ReceitasMapper receitasDTO;

    public CategoriaService(CategoriaMapper categoriaMapper, CategoriaRepository categoriaRepository, ReceitasMapper receitasDTO) {
        this.categoriaMapper = categoriaMapper;
        this.categoriaRepository = categoriaRepository;
        this.receitasDTO = receitasDTO;
    }

    //Listar por id
    public CategoriaDTO listarCategoriaId(Long id){
        Optional<CategoriaModel> categoriaModel = categoriaRepository.findById(id);
        return categoriaModel.map(categoriaMapper::mapCategoria).orElse(null);
    }

    //Listar todas as categorias
    public List<CategoriaDTO> lisarCategorias() {
        List<CategoriaModel> categorias = categoriaRepository.findAll();
        return categorias.stream().
                map(categoriaMapper::mapCategoria)
                .collect(Collectors.toList());
    }
    //Listar receita por categoria

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
    public CategoriaDTO adicionarReceitaCategoria(List<ReceitasDTO> receita, Long id){
        CategoriaModel receitaAddCategoria = categoriaMapper.mapCategoria((CategoriaDTO) receita);
        receitaAddCategoria.setId(id);
        receitaAddCategoria = categoriaRepository.save(receitaAddCategoria);

        return categoriaMapper.mapCategoria(receitaAddCategoria);
    }
}
