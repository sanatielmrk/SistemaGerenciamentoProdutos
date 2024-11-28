package com.loja.modelo;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private String categoria;

    // Construtor completo (sem id, o id será gerado automaticamente)
    public Produto(String nome, double preco, int quantidadeEstoque, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método toString para exibir o produto de forma formatada
    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Preço: R$ %.2f | Estoque: %d | Categoria: %s",
                id, nome, preco, quantidadeEstoque, categoria);
    }

    // Método equals e hashCode baseado no ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}