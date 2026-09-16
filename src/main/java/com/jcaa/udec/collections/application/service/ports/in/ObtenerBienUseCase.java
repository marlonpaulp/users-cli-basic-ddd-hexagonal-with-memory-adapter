package com.jcaa.udec.collections.application.service.ports.in;
import com.jcaa.udec.collections.application.service.dto.query.ObtenerBienConsulta;
import com.jcaa.udec.collections.domain.core.model.Bien;

public interface ObtenerBienUseCase {
    Bien obtenerPorId(ObtenerBienConsulta consulta);

}
