package com.example.meu_primeiro_springboot.service;

import org.springframework.stereotype.Service;

import com.example.meu_primeiro_springboot.repository.ProdutoRepository;

@Service
public class ProdutoService{

    private final ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public list<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
}
