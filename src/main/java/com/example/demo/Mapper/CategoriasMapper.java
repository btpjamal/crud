package com.example.demo.Mapper;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.Model.CategoriasModel;
import org.springframework.stereotype.Component;

@Component
public class CategoriasMapper {

    public CategoriaDTO toDTO(CategoriasModel categoriasModel) {
        if (categoriasModel == null) {
            return null;
        }
        CategoriaDTO categoriasDTO = new CategoriaDTO();
        categoriasDTO.setId(categoriasModel.getId());
        categoriasDTO.setNome(categoriasModel.getNome());
        return categoriasDTO;
    }

    public CategoriasModel toModel(CategoriaDTO categoriasDTO) {
        if (categoriasDTO == null) {
            return null;
        }
        CategoriasModel categoriasModel = new CategoriasModel();
        categoriasModel.setId(categoriasDTO.getId());
        categoriasModel.setNome(categoriasDTO.getNome());
        return categoriasModel;
    }
}