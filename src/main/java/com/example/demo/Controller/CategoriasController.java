package com.example.demo.Controller;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.Service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    private final CategoriaService categoriaService;
    private final CategoriaDTO categoriaDTO;

    public CategoriasController(CategoriaService categoriaService, CategoriaDTO categoriaDTO) {
        this.categoriaService = categoriaService;
        this.categoriaDTO = categoriaDTO;
    }

    // create
    @PostMapping("/create")
    public CategoriaDTO createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.createCategoria(categoriaDTO);
        return categoriaDTO;
    }

    // read by id
    @GetMapping("/read/{id}")
    public CategoriaDTO getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    // read all
    @GetMapping("/read/all")
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    // update
    @PutMapping("/update/{id}")
    public CategoriaDTO updateCategoria(@PathVariable Long id,@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.updateCategoria(id, categoriaDTO);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }
}
