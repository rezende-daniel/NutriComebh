package org.example.nutricomebh.Receitas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitasRepository extends JpaRepository<ReceitasModel, Long> {


    List<ReceitasModel> findAllByCategoria_Id(Long categoriaId);
}
