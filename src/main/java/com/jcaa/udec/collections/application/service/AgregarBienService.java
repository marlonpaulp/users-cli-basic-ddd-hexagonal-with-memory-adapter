package com.jcaa.udec.collections.application.service;
import com.jcaa.udec.collections.application.service.dto.command.CrearBienComando;
import com.jcaa.udec.collections.application.service.mapper.BienMapper;
import com.jcaa.udec.collections.application.service.ports.in.AgregarBienUseCase;
import com.jcaa.udec.collections.domain.core.model.Bien;
import com.jcaa.udec.collections.domain.port.out.GuardarBienPort;

public class AgregarBienService implements AgregarBienUseCase {
    private final GuardarBienPort guardarBienPort;

    public AgregarBienService(GuardarBienPort guardarBienPort) {
        this.guardarBienPort = guardarBienPort;
    }

    @Override
    public void guardar(CrearBienComando comando) {
        Bien bien = BienMapper.mapearABien(comando);
        guardarBienPort.guardar(bien);
    }
}
