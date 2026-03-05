package com.example.demo.Repository;

import com.example.demo.Model.CategoriasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriasModel, Long> {
}
