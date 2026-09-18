package com.jcaa.udec.collections.entrypoint.controller;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.ActualizarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.EliminarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.RegistrarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.response.ObtenerBienResponse;

public interface BienControlador {
    void registrar(RegistrarBienPeticion peticion);

    ObtenerBienResponse obtenerPorId(String id);

    ObtenerBienResponse obtenerTodos();

    void actualizar(ActualizarBienPeticion peticion);

    void eliminar(EliminarBienPeticion peticion);
}
