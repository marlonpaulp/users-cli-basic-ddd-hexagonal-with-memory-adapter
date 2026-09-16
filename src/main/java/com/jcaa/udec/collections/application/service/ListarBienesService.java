package com.jcaa.udec.collections.application.service;
import com.jcaa.udec.collections.application.service.ports.in.ListarBienesUseCase;
import com.jcaa.udec.collections.domain.core.model.Bien;
import com.jcaa.udec.collections.domain.port.out.ObtenerBienesPort;
import java.util.List;

public class ListarBienesService implements ListarBienesUseCase {
    private final ObtenerBienesPort obtenerBienesPort;

    public ListarBienesService(ObtenerBienesPort obtenerBienesPort) {
        this.obtenerBienesPort = obtenerBienesPort;
    }

    @Override
    public List<Bien> listar() {
        return obtenerBienesPort.obtenerTodos();
    }

}
