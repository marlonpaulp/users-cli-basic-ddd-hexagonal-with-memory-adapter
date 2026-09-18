package com.jcaa.udec.collections.entrypoint.controller.mapper;
import com.jcaa.udec.collections.domain.core.model.Bien;
import com.jcaa.udec.collections.entrypoint.controller.dto.response.BienResponse;
import com.jcaa.udec.collections.entrypoint.controller.dto.response.ObtenerBienResponse;
import java.util.List;

public final class BienResponseMapper {
     private BienResponseMapper() {
    }

    public static ObtenerBienResponse mapearAResponse(Bien bien) {
        return new ObtenerBienResponse(
                List.of(mapearAResponseBien(bien)));
    }

    public static ObtenerBienResponse mapearAResponse(List<Bien> bienes) {
        return new ObtenerBienResponse(
                bienes.stream()
                        .map(BienResponseMapper::mapearAResponseBien)
                        .toList());
    }

    private static BienResponse mapearAResponseBien(Bien bien) {
        return new BienResponse(
                bien.getId(),
                bien.getCodigo(),
                bien.getNombre(),
                bien.getDescripcion(),
                bien.getTipo(),
                bien.getUnidadMedida(),
                bien.getValorUnitario(),
                bien.getEstado());
    }
}
