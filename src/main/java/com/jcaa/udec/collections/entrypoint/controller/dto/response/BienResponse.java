package com.jcaa.udec.collections.entrypoint.controller.dto.response;


public record BienResponse(
        String id,
        String codigo,
        String nombre,
        String descripcion,
        String tipo,
        String unidadMedida,
        double valorUnitario,
        String estado
) {
    private static final String FORMATO_DATOS = """
            ID: %s
            CODIGO: %s
            NOMBRE: %s
            DESCRIPCION: %s
            TIPO: %s
            UNIDAD DE MEDIDA: %s
            VALOR UNITARIO: %.2f
            ESTADO: %s
            """;

    @Override
    public String toString() {
        return FORMATO_DATOS.formatted(
                id,
                codigo,
                nombre,
                descripcion,
                tipo,
                unidadMedida,
                valorUnitario,
                estado);
    }
}
