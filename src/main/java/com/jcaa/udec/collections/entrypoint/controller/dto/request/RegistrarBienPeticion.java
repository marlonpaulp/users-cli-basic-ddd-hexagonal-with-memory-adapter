package com.jcaa.udec.collections.entrypoint.controller.dto.request;

public record RegistrarBienPeticion (
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
