package com.jcaa.udec.collections.application.service;
import com.jcaa.udec.collections.application.service.dto.command.ActualizarBienComando;
import com.jcaa.udec.collections.application.service.mapper.BienMapper;
import com.jcaa.udec.collections.application.service.ports.in.ActualizarBienUseCase;
import com.jcaa.udec.collections.domain.core.model.Bien;
import com.jcaa.udec.collections.domain.port.out.ActualizarBienPort;

public class ActualizarBienService implements ActualizarBienUseCase {
    private final ActualizarBienPort actualizarBienPort;

    public ActualizarBienService(ActualizarBienPort actualizarBienPort) {
        this.actualizarBienPort = actualizarBienPort;
    }

    @Override
    public void actualizar(ActualizarBienComando comando) {
        Bien bien = BienMapper.mapearABien(comando);
        actualizarBienPort.actualizar(bien);
    }
}
