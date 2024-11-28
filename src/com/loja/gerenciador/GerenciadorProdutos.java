package com.loja.gerenciador;

import com.loja.modelo.Produto;
import com.loja.exception.ValidacaoException;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {

    private List<Produto> produtos;
    private int proximoId;

    public GerenciadorProdutos() {
        this.produtos = new ArrayList<>();
        this.proximoId = 1;
    }

    // Método para criar e adicionar um novo produto
    public void criar(Produto produto) {
        validarProduto(produto); // Valida os dados antes de adicionar
        produto.setId(proximoId++);
        produtos.add(produto);
    }

    // Buscar produto por ID
    public Produto buscarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    // Atualizar produto
    public boolean atualizar(Produto produto) {
        Produto existente = buscarPorId(produto.getId());
        if (existente != null) {
            existente.setNome(produto.getNome());
            existente.setPreco(produto.getPreco());
            existente.setQuantidadeEstoque(produto.getQuantidadeEstoque());
            existente.setCategoria(produto.getCategoria());
            return true;
        }
        return false;
    }

    // Deletar produto
    public boolean deletar(int id) {
        Produto produto = buscarPorId(id);
        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }

    // Buscar produtos por nome
    public List<Produto> buscarPorNome(String nome) {
        List<Produto> encontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(produto);
            }
        }
        return encontrados;
    }

    // Buscar produtos por categoria
    public List<Produto> buscarPorCategoria(String categoria) {
        List<Produto> encontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getCategoria().toLowerCase().contains(categoria.toLowerCase())) {
                encontrados.add(produto);
            }
        }
        return encontrados;
    }

    // Validar dados do produto
    private void validarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new ValidacaoException("O nome do produto não pode ser vazio.");
        }
        if (produto.getPreco() <= 0) {
            throw new ValidacaoException("O preço do produto deve ser maior que zero.");
        }
        if (produto.getQuantidadeEstoque() < 0) {
            throw new ValidacaoException("A quantidade em estoque não pode ser negativa.");
        }
        if (produto.getCategoria() == null || produto.getCategoria().trim().isEmpty()) {
            throw new ValidacaoException("A categoria do produto não pode ser vazia.");
        }
    }
}