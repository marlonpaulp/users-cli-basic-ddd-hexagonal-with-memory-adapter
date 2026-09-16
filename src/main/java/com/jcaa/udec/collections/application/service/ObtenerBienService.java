package com.jcaa.udec.collections.application.service;
import com.jcaa.udec.collections.application.service.dto.query.ObtenerBienConsulta;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerBienUseCase;
import com.jcaa.udec.collections.domain.core.model.Bien;
import com.jcaa.udec.collections.domain.port.out.ObtenerBienesPort;

public class ObtenerBienService implements ObtenerBienUseCase {
    private final ObtenerBienesPort obtenerBienesPort;

    public ObtenerBienService(ObtenerBienesPort obtenerBienesPort) {
        this.obtenerBienesPort = obtenerBienesPort;
    }

    @Override
    public Bien obtenerPorId(ObtenerBienConsulta consulta) {
        return obtenerBienesPort.buscarPorId(consulta.id());
    }
}
