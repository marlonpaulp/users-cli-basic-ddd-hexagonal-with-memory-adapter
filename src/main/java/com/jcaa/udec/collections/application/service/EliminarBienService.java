package com.jcaa.udec.collections.application.service;
import com.jcaa.udec.collections.application.service.dto.command.EliminarBienComando;
import com.jcaa.udec.collections.application.service.ports.in.EliminarBienUseCase;
import com.jcaa.udec.collections.domain.port.out.EliminarBienPort;


public class EliminarBienService implements EliminarBienUseCase {
    private final EliminarBienPort eliminarBienPort;

    public EliminarBienService(EliminarBienPort eliminarBienPort) {
        this.eliminarBienPort = eliminarBienPort;
    }

    @Override
    public void eliminar(EliminarBienComando comando) {
        eliminarBienPort.eliminar(comando.id());
    }
}
