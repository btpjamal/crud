package com.example.demo.Mapper;


import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.Model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    // Método para converter ProdutoModel em ProdutoDTO
    public ProdutoDTO toDTO(ProdutoModel produtoModel) {
        if (produtoModel == null) {
            return null;
        }
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoModel.getId());
        produtoDTO.setNome(produtoModel.getNome());
        produtoDTO.setDescricao(produtoModel.getDescricao());
        produtoDTO.setPreco(produtoModel.getPreco());
        produtoDTO.setQuantidade(produtoModel.getQuantidade());
        return produtoDTO;
    }

    // Método para converter ProdutoDTO em ProdutoModel
    public ProdutoModel toModel(ProdutoDTO produtoDTO) {
        if (produtoDTO == null) {
            return null;
        }
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(produtoDTO.getId());
        produtoModel.setNome(produtoDTO.getNome());
        produtoModel.setDescricao(produtoDTO.getDescricao());
        produtoModel.setPreco(produtoDTO.getPreco());
        produtoModel.setQuantidade(produtoDTO.getQuantidade());
        return produtoModel;
    }

}
