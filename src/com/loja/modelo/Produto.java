package com.loja.modelo;

import java.util.Objects;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private String categoria;

    // Construtor completo sem id (id será atribuído automaticamente)
    public Produto(String nome, double preco, int quantidadeEstoque, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    // Getters e Setters
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

    // Método toString para exibir os dados do produto de forma formatada
    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Preço: R$ " + preco + " | Estoque: " + quantidadeEstoque + " | Categoria: " + categoria;
    }

    // equals() e hashCode() baseados no id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}