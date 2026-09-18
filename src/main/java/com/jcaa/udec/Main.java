package com.jcaa.udec;

import com.jcaa.udec.collections.adapter.persistence.memory.ActualizarBienAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.EliminarBienAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.GuardarBienAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.GuardarUsuarioAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.ObtenerBienesAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.ObtenerUsuariosAdapter;
import com.jcaa.udec.collections.application.service.ActualizarBienService;
import com.jcaa.udec.collections.application.service.AgregarBienService;
import com.jcaa.udec.collections.application.service.AgregarUsuarioService;
import com.jcaa.udec.collections.application.service.EliminarBienService;
import com.jcaa.udec.collections.application.service.ListarBienesService;
import com.jcaa.udec.collections.application.service.ObtenerBienService;
import com.jcaa.udec.collections.application.service.ObtenerUsuariosService;
import com.jcaa.udec.collections.application.service.ports.in.ActualizarBienUseCase;
import com.jcaa.udec.collections.application.service.ports.in.AgregarBienUseCase;
import com.jcaa.udec.collections.application.service.ports.in.AgregarUsuarioUseCase;
import com.jcaa.udec.collections.application.service.ports.in.EliminarBienUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ListarBienesUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerBienUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerUsuarioUseCase;
import com.jcaa.udec.collections.domain.port.out.ActualizarBienPort;
import com.jcaa.udec.collections.domain.port.out.EliminarBienPort;
import com.jcaa.udec.collections.domain.port.out.GuardarBienPort;
import com.jcaa.udec.collections.domain.port.out.GuardarUsuarioPort;
import com.jcaa.udec.collections.domain.port.out.ObtenerBienesPort;
import com.jcaa.udec.collections.domain.port.out.ObtenerUsuariosPort;
import com.jcaa.udec.collections.entrypoint.cli.GuiCli;
import com.jcaa.udec.collections.entrypoint.controller.BienControlador;
import com.jcaa.udec.collections.entrypoint.controller.BienControladorImpl;
import com.jcaa.udec.collections.entrypoint.controller.UsuarioControlador;
import com.jcaa.udec.collections.entrypoint.controller.UsuarioControladorImpl;
import com.jcaa.udec.collections.entrypoint.cli.BienCli;

public class Main {

    public static void main(String[] args) {

        // =========================
        // CONFIGURACIÓN DE USUARIO
        // =========================

        GuardarUsuarioPort guardarUsuarioPort =
                new GuardarUsuarioAdapter();

        ObtenerUsuariosPort obtenerUsuariosPort =
                new ObtenerUsuariosAdapter();

        AgregarUsuarioUseCase agregarUsuarioUseCase =
                new AgregarUsuarioService(guardarUsuarioPort);

        ObtenerUsuarioUseCase obtenerUsuarioUseCase =
                new ObtenerUsuariosService(obtenerUsuariosPort);

        UsuarioControlador usuarioControlador =
                new UsuarioControladorImpl(
                        agregarUsuarioUseCase,
                        obtenerUsuarioUseCase);

        // =========================
        // CONFIGURACIÓN DE BIEN
        // =========================

        GuardarBienPort guardarBienPort =
                new GuardarBienAdapter();

        ObtenerBienesPort obtenerBienesPort =
                new ObtenerBienesAdapter();

        ActualizarBienPort actualizarBienPort =
                new ActualizarBienAdapter();

        EliminarBienPort eliminarBienPort =
                new EliminarBienAdapter();

        AgregarBienUseCase agregarBienUseCase =
                new AgregarBienService(guardarBienPort);

        ObtenerBienUseCase obtenerBienUseCase =
                new ObtenerBienService(obtenerBienesPort);

        ListarBienesUseCase listarBienesUseCase =
                new ListarBienesService(obtenerBienesPort);

        ActualizarBienUseCase actualizarBienUseCase =
                new ActualizarBienService(actualizarBienPort);

        EliminarBienUseCase eliminarBienUseCase =
                new EliminarBienService(eliminarBienPort);

        BienControlador bienControlador =
                new BienControladorImpl(
                        agregarBienUseCase,
                        obtenerBienUseCase,
                        listarBienesUseCase,
                        actualizarBienUseCase,
                        eliminarBienUseCase);

        // =========================
        // INICIO DE LA CLI
        // =========================

        if (args.length > 0
                && "bien".equalsIgnoreCase(args[0])) {

            BienCli bienCli =
                    new BienCli(bienControlador);

            bienCli.ejecutar();

        } else {

            GuiCli guiCli =
                    new GuiCli(usuarioControlador);

            guiCli.ejecutarAccion();
        }
    }
}