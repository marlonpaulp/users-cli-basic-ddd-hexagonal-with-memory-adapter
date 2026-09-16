package com.jcaa.udec.collections.application.service.dto.command;

public record ActualizarBienComando (
    String id,
    String codigo,
    String nombre,
    String descripcion,
    String tipo,
    String unidadMedida,
    double valorUnitario,
    String estado
) {

}
