package com.example.demo.Controller;

import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.Service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoDTO produtoDTO;

    public ProdutoController(ProdutoService produtoService, ProdutoDTO produtoDTO) {
        this.produtoService = produtoService;
        this.produtoDTO = produtoDTO;
    }

    // create
    @PostMapping("/create")
    public ProdutoDTO createProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.createProduto(produtoDTO);
        return produtoDTO;
    }

    // read by id
    @GetMapping("/read/{id}")
    public ProdutoDTO getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    // read all
    @GetMapping("/read/all")
    public List<ProdutoDTO> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    // update
    @PutMapping("/update/{id}")
    public ProdutoDTO updateProduto(@PathVariable Long id,@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.updateProduto(id, produtoDTO);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
    }
}
