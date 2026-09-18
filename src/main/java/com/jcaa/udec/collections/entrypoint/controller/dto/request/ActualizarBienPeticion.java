package com.jcaa.udec.collections.entrypoint.controller.dto.request;

public record ActualizarBienPeticion (
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
