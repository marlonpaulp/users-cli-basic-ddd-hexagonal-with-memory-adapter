package com.jcaa.udec.collections.application.service.mapper;
import com.jcaa.udec.collections.application.service.dto.command.CrearBienComando;
import com.jcaa.udec.collections.domain.core.model.Bien;

public class BienMapper {
    private BienMapper() {
    }

    public static Bien mapearABien(CrearBienComando comando) {
        return new Bien(
                comando.id(),
                comando.codigo(),
                comando.nombre(),
                comando.descripcion(),
                comando.tipo(),
                comando.unidadMedida(),
                comando.valorUnitario(),
                comando.estado()
        );
    }
}
