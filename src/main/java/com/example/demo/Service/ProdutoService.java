package com.example.demo.Service;

import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.Mapper.ProdutoMapper;
import com.example.demo.Model.ProdutoModel;
import com.example.demo.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    public final ProdutoMapper produtoMapper;
    public final ProdutoRepository produtoRepository;

    ProdutoService(ProdutoMapper produtoMapper, ProdutoRepository produtoRepository) {
        this.produtoMapper = produtoMapper;
        this.produtoRepository = produtoRepository;
    }

    // CRUD - Create, Read, Update, Delete

    // Create
    public ProdutoDTO createProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = produtoMapper.toModel(produtoDTO);
        ProdutoModel savedProduto = produtoRepository.save(produtoModel);
        return produtoMapper.toDTO(savedProduto);
    }

    // Read by ID
    public ProdutoDTO getProdutoById(Long id) {
        ProdutoModel produtoModel = produtoRepository.findById(id).orElse(null);
        return produtoMapper.toDTO(produtoModel);
    }

    // Read all
    public List<ProdutoDTO> getAllProdutos() {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produtoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Update
    public ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO) {
        ProdutoModel existingProduto = produtoRepository.findById(id).orElse(null);
        if (existingProduto != null) {
            existingProduto.setNome(produtoDTO.getNome());
            existingProduto.setDescricao(produtoDTO.getDescricao());
            existingProduto.setPreco(produtoDTO.getPreco());
            existingProduto.setQuantidade(produtoDTO.getQuantidade());
            ProdutoModel updatedProduto = produtoRepository.save(existingProduto);
            return produtoMapper.toDTO(updatedProduto);
        }
        return null;
    }

    // Delete
    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}
