package com.loja.exception;

public class ProdutoException extends RuntimeException {
    public ProdutoException(String mensagem) {
        super(mensagem);  // Passa a mensagem de erro para a superclasse RuntimeException
    }
}