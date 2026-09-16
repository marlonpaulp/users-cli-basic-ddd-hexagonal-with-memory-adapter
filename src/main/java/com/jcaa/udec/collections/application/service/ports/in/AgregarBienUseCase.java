package com.jcaa.udec.collections.application.service.ports.in;
import com.jcaa.udec.collections.application.service.dto.command.CrearBienComando;

public interface AgregarBienUseCase {
    void guardar(CrearBienComando comando);
}
