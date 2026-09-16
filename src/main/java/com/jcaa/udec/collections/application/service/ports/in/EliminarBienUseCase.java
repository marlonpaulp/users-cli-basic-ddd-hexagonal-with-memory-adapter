package com.jcaa.udec.collections.application.service.ports.in;
import com.jcaa.udec.collections.application.service.dto.command.EliminarBienComando;

public interface EliminarBienUseCase {
    void eliminar(EliminarBienComando comando);
}
