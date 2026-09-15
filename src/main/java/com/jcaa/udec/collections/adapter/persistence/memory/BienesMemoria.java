package com.jcaa.udec.collections.adapter.persistence.memory;
import com.jcaa.udec.collections.domain.core.model.Bien;
import java.util.ArrayList;
import java.util.List;

final class BienesMemoria {
    private static final List<Bien> BIENES = new ArrayList<>();

    private BienesMemoria() {
    }

    static List<Bien> obtenerBienes() {
        return BIENES;
    }
}
