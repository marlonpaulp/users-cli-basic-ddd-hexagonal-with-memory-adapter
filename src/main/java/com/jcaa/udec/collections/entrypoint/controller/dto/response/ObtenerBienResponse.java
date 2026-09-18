package com.jcaa.udec.collections.entrypoint.controller.dto.response;
import java.util.List;

public record ObtenerBienResponse (List<BienResponse> bienes) {
    public ObtenerBienResponse {
        bienes = List.copyOf(bienes);
    }

    public boolean estaVacia() {
        return bienes.isEmpty();
    }

    @Override
    public String toString() {
        return String.join(
                System.lineSeparator(),
                bienes.stream()
                        .map(BienResponse::toString)
                        .toList());
    }
}
