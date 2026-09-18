package com.jcaa.udec.collections.entrypoint.controller;

import com.jcaa.udec.collections.application.service.dto.command.ActualizarBienComando;
import com.jcaa.udec.collections.application.service.dto.command.CrearBienComando;
import com.jcaa.udec.collections.application.service.dto.command.EliminarBienComando;
import com.jcaa.udec.collections.application.service.dto.query.ObtenerBienConsulta;
import com.jcaa.udec.collections.application.service.ports.in.ActualizarBienUseCase;
import com.jcaa.udec.collections.application.service.ports.in.AgregarBienUseCase;
import com.jcaa.udec.collections.application.service.ports.in.EliminarBienUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ListarBienesUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerBienUseCase;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.ActualizarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.EliminarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.RegistrarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.response.ObtenerBienResponse;
import com.jcaa.udec.collections.entrypoint.controller.mapper.BienResponseMapper;

public class BienControladorImpl implements BienControlador {

    private final AgregarBienUseCase agregarBienUseCase;
    private final ObtenerBienUseCase obtenerBienUseCase;
    private final ListarBienesUseCase listarBienesUseCase;
    private final ActualizarBienUseCase actualizarBienUseCase;
    private final EliminarBienUseCase eliminarBienUseCase;

    public BienControladorImpl(
            AgregarBienUseCase agregarBienUseCase,
            ObtenerBienUseCase obtenerBienUseCase,
            ListarBienesUseCase listarBienesUseCase,
            ActualizarBienUseCase actualizarBienUseCase,
            EliminarBienUseCase eliminarBienUseCase) {

        this.agregarBienUseCase = agregarBienUseCase;
        this.obtenerBienUseCase = obtenerBienUseCase;
        this.listarBienesUseCase = listarBienesUseCase;
        this.actualizarBienUseCase = actualizarBienUseCase;
        this.eliminarBienUseCase = eliminarBienUseCase;
    }

    @Override
    public void registrar(RegistrarBienPeticion peticion) {
        CrearBienComando comando = new CrearBienComando(
                peticion.id(),
                peticion.codigo(),
                peticion.nombre(),
                peticion.descripcion(),
                peticion.tipo(),
                peticion.unidadMedida(),
                peticion.valorUnitario(),
                peticion.estado());

        agregarBienUseCase.guardar(comando);
    }

    @Override
    public ObtenerBienResponse obtenerPorId(String id) {
        ObtenerBienConsulta consulta = new ObtenerBienConsulta(id);

        return BienResponseMapper.mapearAResponse(
                obtenerBienUseCase.obtenerPorId(consulta));
    }

    @Override
    public ObtenerBienResponse obtenerTodos() {
        return BienResponseMapper.mapearAResponse(
                listarBienesUseCase.listar());
    }

    @Override
    public void actualizar(ActualizarBienPeticion peticion) {
        ActualizarBienComando comando = new ActualizarBienComando(
                peticion.id(),
                peticion.codigo(),
                peticion.nombre(),
                peticion.descripcion(),
                peticion.tipo(),
                peticion.unidadMedida(),
                peticion.valorUnitario(),
                peticion.estado());

        actualizarBienUseCase.actualizar(comando);
    }

    @Override
    public void eliminar(EliminarBienPeticion peticion) {
        EliminarBienComando comando = new EliminarBienComando(peticion.id());

        eliminarBienUseCase.eliminar(comando);
    }
}
