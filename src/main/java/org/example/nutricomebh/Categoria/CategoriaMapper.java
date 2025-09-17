package org.example.nutricomebh.Categoria;


import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
    public CategoriaModel mapCategoria(CategoriaDTO categoriaDTO){
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(categoriaDTO.getId());
        categoriaModel.setNome(categoriaDTO.getNome());
        categoriaModel.setReceitas(categoriaDTO.getReceitas());
        return categoriaModel;
    }
    public  CategoriaDTO mapCategoria(CategoriaModel categoriaModel){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoriaModel.getId());
        categoriaDTO.setNome(categoriaModel.getNome());
        categoriaDTO.setReceitas(categoriaModel.getReceitas());
        return categoriaDTO;
    }

}
