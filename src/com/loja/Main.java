package com.loja;

import com.loja.gerenciador.GerenciadorProdutos;
import com.loja.ui.MenuProdutos;

public class Main {

    public static void main(String[] args) {
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        MenuProdutos menu = new MenuProdutos(gerenciador);
        menu.exibirMenu();  // Exibe o menu para o usuário
    }
}