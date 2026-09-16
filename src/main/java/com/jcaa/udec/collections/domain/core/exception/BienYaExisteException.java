package com.jcaa.udec.collections.domain.core.exception;

public class BienYaExisteException extends RuntimeException {
    private static final String MENSAJE_ERROR = "El bien ya existe.";

    public BienYaExisteException() {
        super(MENSAJE_ERROR);
    }
}
