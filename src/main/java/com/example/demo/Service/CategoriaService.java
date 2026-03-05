package com.example.demo.Service;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.Mapper.CategoriasMapper;
import com.example.demo.Model.CategoriasModel;
import com.example.demo.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    public final CategoriasMapper categoriasMapper;
    public final CategoriaRepository categoriaRepository;


    public CategoriaService(CategoriasMapper categoriasMapper, CategoriaRepository categoriaRepository) {
        this.categoriasMapper = categoriasMapper;
        this.categoriaRepository = categoriaRepository;
    }

    // crud - create, read, update, delete

    // create
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        CategoriasModel categoriaModel = categoriasMapper.toModel(categoriaDTO);
        CategoriasModel savedCategoria = categoriaRepository.save(categoriaModel);
        return categoriasMapper.toDTO(savedCategoria);
    }

    // read by id
    public CategoriaDTO getCategoriaById(Long id) {
        CategoriasModel categoriaModel = categoriaRepository.findById(id).orElse(null);
        return categoriasMapper.toDTO(categoriaModel);
    }

    // read all
    public List<CategoriaDTO> getAllCategorias() {
        List<CategoriasModel> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoriasMapper::toDTO)
                .collect(Collectors.toList());
    }

    // update
    public CategoriaDTO updateCategoria(Long id, CategoriaDTO categoriaDTO) {
        CategoriasModel existingCategoria = categoriaRepository.findById(id).orElse(null);
        if (existingCategoria != null) {
            existingCategoria.setNome(categoriaDTO.getNome());
            CategoriasModel updatedCategoria = categoriaRepository.save(existingCategoria);
            return categoriasMapper.toDTO(updatedCategoria);
        }
        return null;
    }

    // delete
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
