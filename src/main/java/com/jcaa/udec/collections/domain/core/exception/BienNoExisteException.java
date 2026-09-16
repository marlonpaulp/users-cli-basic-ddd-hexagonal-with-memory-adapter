package com.jcaa.udec.collections.domain.core.exception;

public class BienNoExisteException extends RuntimeException {
    private static final String MENSAJE_ERROR = "El bien no existe.";

    public BienNoExisteException() {
        super(MENSAJE_ERROR);
    }
}
