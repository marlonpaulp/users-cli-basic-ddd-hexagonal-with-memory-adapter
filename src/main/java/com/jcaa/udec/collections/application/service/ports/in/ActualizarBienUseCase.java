package com.jcaa.udec.collections.application.service.ports.in;
import com.jcaa.udec.collections.application.service.dto.command.ActualizarBienComando;

public interface ActualizarBienUseCase {
    void actualizar(ActualizarBienComando comando);
}
