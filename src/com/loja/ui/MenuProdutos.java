package com.loja.ui;

import com.loja.gerenciador.GerenciadorProdutos;
import com.loja.modelo.Produto;

import java.util.List;
import java.util.Scanner;

public class MenuProdutos {

    private Scanner scanner;
    private GerenciadorProdutos gerenciador;

    public MenuProdutos(GerenciadorProdutos gerenciador) {
        this.scanner = new Scanner(System.in);
        this.gerenciador = gerenciador;
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Buscar Produto por ID");
            System.out.println("3. Listar Todos os Produtos");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Deletar Produto");
            System.out.println("6. Buscar por Nome");
            System.out.println("7. Buscar por Categoria");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = lerEntradaInteira("Escolha uma opção:");  // Corrigido

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    buscarProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    deletarProduto();
                    break;
                case 6:
                    buscarPorNome();
                    break;
                case 7:
                    buscarPorCategoria();
                    break;
                case 8:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarProduto() {
        System.out.println("=== Cadastro de Produto ===");
        String nome = lerEntradaString("Digite o nome: ");
        double preco = lerEntradaDouble("Digite o preço: ");
        int quantidade = lerEntradaInteira("Digite a quantidade: ");
        String categoria = lerEntradaString("Digite a categoria: ");

        Produto produto = new Produto(nome, preco, quantidade, categoria);
        gerenciador.criar(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private void buscarProduto() {
        System.out.println("=== Busca de Produto ===");
        int id = lerEntradaInteira("Digite o ID: ");  // Corrigido
        Produto produto = gerenciador.buscarPorId(id);
        if (produto != null) {
            System.out.println("Produto encontrado:");
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void listarProdutos() {
        System.out.println("=== Listagem de Produtos ===");
        List<Produto> produtos = gerenciador.listarTodos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    private void atualizarProduto() {
        System.out.println("=== Atualização de Produto ===");
        int id = lerEntradaInteira("Digite o ID do produto a ser atualizado: ");  // Corrigido
        Produto produto = gerenciador.buscarPorId(id);
        if (produto != null) {
            String nome = lerEntradaString("Digite o novo nome: ");
            double preco = lerEntradaDouble("Digite o novo preço: ");
            int quantidade = lerEntradaInteira("Digite a nova quantidade: ");  // Corrigido
            String categoria = lerEntradaString("Digite a nova categoria: ");

            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidadeEstoque(quantidade);
            produto.setCategoria(categoria);

            if (gerenciador.atualizar(produto)) {
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Erro ao atualizar o produto.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void deletarProduto() {
        System.out.println("=== Deletar Produto ===");
        int id = lerEntradaInteira("Digite o ID do produto a ser deletado: ");  // Corrigido
        if (gerenciador.deletar(id)) {
            System.out.println("Produto deletado com sucesso!");
        } else {
            System.out.println("Erro ao deletar o produto.");
        }
    }

    private void buscarPorNome() {
        System.out.println("=== Buscar por Nome ===");
        String nome = lerEntradaString("Digite o nome do produto: ");
        List<Produto> produtos = gerenciador.buscarPorNome(nome);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    private void buscarPorCategoria() {
        System.out.println("=== Buscar por Categoria ===");
        String categoria = lerEntradaString("Digite a categoria: ");
        List<Produto> produtos = gerenciador.buscarPorCategoria(categoria);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    private String lerEntradaString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private double lerEntradaDouble(String mensagem) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = Double.parseDouble(scanner.nextLine());
                if (valor > 0) {
                    valido = true;
                } else {
                    System.out.println("Valor inválido. Deve ser maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
        return valor;
    }

    private int lerEntradaInteira(String mensagem) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
        return valor;
    }
}