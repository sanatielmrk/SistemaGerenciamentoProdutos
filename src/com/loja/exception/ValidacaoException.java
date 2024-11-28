package com.loja.exception;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);  // Passa a mensagem de erro para a superclasse RuntimeException
    }
}