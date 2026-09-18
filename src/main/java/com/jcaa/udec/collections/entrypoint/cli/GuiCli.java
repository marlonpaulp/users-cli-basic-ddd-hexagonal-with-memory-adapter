package com.jcaa.udec.collections.entrypoint.cli;

import com.jcaa.udec.collections.domain.core.exception.BienNoExisteException;
import com.jcaa.udec.collections.domain.core.exception.BienYaExisteException;
import com.jcaa.udec.collections.domain.core.exception.UsuarioInvalidoException;
import com.jcaa.udec.collections.domain.core.exception.UsuarioNoExisteException;
import com.jcaa.udec.collections.domain.core.exception.UsuarioYaExisteException;
import com.jcaa.udec.collections.domain.core.valueobject.Email;
import com.jcaa.udec.collections.domain.core.valueobject.NombreUsuario;
import com.jcaa.udec.collections.domain.core.valueobject.Password;
import com.jcaa.udec.collections.domain.core.valueobject.UsuarioId;
import com.jcaa.udec.collections.entrypoint.controller.BienControlador;
import com.jcaa.udec.collections.entrypoint.controller.UsuarioControlador;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.ActualizarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.EliminarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.RegistrarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.RegistrarUsuarioPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.response.ObtenerBienResponse;
import com.jcaa.udec.collections.entrypoint.controller.dto.response.ObtenerUsuarioResponse;

import java.util.Scanner;

public class GuiCli {

    private static final int OPCION_AGREGAR = 1;
    private static final int OPCION_BUSCAR = 2;
    private static final int OPCION_MOSTRAR_TODOS = 3;
    private static final int OPCION_SALIR = 4;
    private static final int OPCION_BIENES = 5;

    private static final int OPCION_BIEN_AGREGAR = 1;
    private static final int OPCION_BIEN_BUSCAR = 2;
    private static final int OPCION_BIEN_LISTAR = 3;
    private static final int OPCION_BIEN_ACTUALIZAR = 4;
    private static final int OPCION_BIEN_ELIMINAR = 5;
    private static final int OPCION_BIEN_VOLVER = 6;

    private static final String TEXTO_TITULO =
            "** EJEMPLO DE USO DE LISTAS Y HEXAGONAL **";

    private static final String TITULO_REGISTRO =
            "** INGRESE LOS DATOS DEL NUEVO USUARIO **";

    private static final String TITULO_BIENES =
            "** GESTION DE BIENES **";

    private static final String SEPARADOR =
            "- - - - - - - - - ";

    private static final String OPCIONES = "Opciones:";

    private static final String TEXTO_OPCION_AGREGAR =
            "1 - Agregar";

    private static final String TEXTO_OPCION_BUSCAR =
            "2 - Buscar por Id";

    private static final String TEXTO_OPCION_MOSTRAR_TODOS =
            "3 - Ver todos";

    private static final String TEXTO_OPCION_SALIR =
            "4 - Salir";

    private static final String TEXTO_OPCION_BIENES =
            "5 - Gestionar Bienes";

    private static final String TEXTO_SOLICITUD_OPCION =
            "Ingrese el numero de la opcion: ";

    private static final String SOLICITUD_ID = "ID: ";
    private static final String SOLICITUD_PASSWORD = "PASSWORD: ";
    private static final String SOLICITUD_NOMBRE = "NOMBRE: ";
    private static final String SOLICITUD_EMAIL = "EMAIL: ";

    private static final String SOLICITUD_CODIGO = "CODIGO: ";
    private static final String SOLICITUD_DESCRIPCION = "DESCRIPCION: ";
    private static final String SOLICITUD_TIPO = "TIPO: ";
    private static final String SOLICITUD_UNIDAD_MEDIDA = "UNIDAD DE MEDIDA: ";
    private static final String SOLICITUD_VALOR_UNITARIO =
            "VALOR UNITARIO: ";
    private static final String SOLICITUD_ESTADO = "ESTADO: ";

    private static final String MENSAJE_OPCION_INVALIDA =
            "Opcion [%s] invalida";

    private static final String MENSAJE_ID_INVALIDO =
            "ID INVALIDO: debe ser un numero entero";

    private static final String MENSAJE_PASSWORD_INVALIDO =
            "PASSWORD INVALIDO: minimo 10 caracteres, con mayuscula, minuscula, numero y simbolo";

    private static final String MENSAJE_NOMBRE_INVALIDO =
            "NOMBRE INVALIDO: minimo 3 caracteres";

    private static final String MENSAJE_EMAIL_INVALIDO =
            "EMAIL INVALIDO: ingrese un correo valido";

    private static final String MENSAJE_VALOR_INVALIDO =
            "VALOR INVALIDO: ingrese un numero mayor o igual a cero";

    private static final String MENSAJE_ERROR = "ERROR: ";

    private static final String MENSAJE_REGISTRO_EXITOSO =
            "Usuario registrado correctamente.";

    private static final String MENSAJE_BIEN_REGISTRADO =
            "Bien registrado correctamente.";

    private static final String MENSAJE_BIEN_ACTUALIZADO =
            "Bien actualizado correctamente.";

    private static final String MENSAJE_BIEN_ELIMINADO =
            "Bien eliminado correctamente.";

    private static final String MENSAJE_LISTA_VACIA =
            "No hay usuarios registrados.";

    private static final String MENSAJE_BIENES_VACIOS =
            "No hay bienes registrados.";

    private static final String MENSAJE_DESPEDIDA =
            "Esperamos tu regreso. Bye, Bye";

    private static final String MARCA_ORDEN_BYTES = "\uFEFF";
    private static final String TEXTO_VACIO = "";

    private final UsuarioControlador usuarioControlador;
    private final BienControlador bienControlador;
    private final Scanner entrada;

    public GuiCli(UsuarioControlador usuarioControlador) {
        this(usuarioControlador, null, new Scanner(System.in));
    }

    public GuiCli(
            UsuarioControlador usuarioControlador,
            BienControlador bienControlador) {
        this(usuarioControlador, bienControlador, new Scanner(System.in));
    }

    GuiCli(
            UsuarioControlador usuarioControlador,
            Scanner entrada) {
        this(usuarioControlador, null, entrada);
    }

    GuiCli(
            UsuarioControlador usuarioControlador,
            BienControlador bienControlador,
            Scanner entrada) {
        this.usuarioControlador = usuarioControlador;
        this.bienControlador = bienControlador;
        this.entrada = entrada;
    }

    public int obtenerOpcionMenu() {
        do {
            mostrarMenu();

            String valorIngresado =
                    limpiarEntrada(entrada.nextLine());

            try {
                int opcion = Integer.parseInt(valorIngresado);

                if (opcion >= OPCION_AGREGAR
                        && opcion <= OPCION_SALIR) {
                    return opcion;
                }

            } catch (NumberFormatException exception) {
                // El flujo informa el valor invalido.
            }

            System.out.printf(
                    MENSAJE_OPCION_INVALIDA + "%n",
                    valorIngresado);

        } while (true);
    }

    public void ejecutarAccion() {

        boolean continuar = true;

        while (continuar) {

            int opcion = obtenerOpcionMenu();

            try {

                switch (opcion) {

                    case OPCION_AGREGAR ->
                            registrarUsuario();

                    case OPCION_BUSCAR ->
                            mostrarUsuarioPorId();

                    case OPCION_MOSTRAR_TODOS ->
                            mostrarTodosLosUsuarios();

                    case OPCION_SALIR ->
                            continuar = false;

                    default -> {
                        // No se ejecuta porque obtenerOpcionMenu valida.
                    }
                }

            } catch (UsuarioInvalidoException
                     | UsuarioNoExisteException
                     | UsuarioYaExisteException exception) {

                System.out.println(
                        MENSAJE_ERROR + exception.getMessage());
            }
        }

        System.out.println(MENSAJE_DESPEDIDA);
    }

    private void mostrarMenu() {

        System.out.println();
        System.out.println(TEXTO_TITULO);
        System.out.println(SEPARADOR);
        System.out.println(OPCIONES);
        System.out.println(SEPARADOR);
        System.out.println(TEXTO_OPCION_AGREGAR);
        System.out.println(TEXTO_OPCION_BUSCAR);
        System.out.println(TEXTO_OPCION_MOSTRAR_TODOS);
        System.out.println(TEXTO_OPCION_SALIR);
        System.out.print(TEXTO_SOLICITUD_OPCION);
    }

    private void ejecutarMenuBienes() {

        if (bienControlador == null) {
            System.out.println(
                    "La gestion de bienes no esta configurada.");
            return;
        }

        boolean continuar = true;

        while (continuar) {

            mostrarMenuBienes();

            String valorIngresado =
                    limpiarEntrada(entrada.nextLine());

            try {

                int opcion =
                        Integer.parseInt(valorIngresado);

                switch (opcion) {

                    case OPCION_BIEN_AGREGAR ->
                            registrarBien();

                    case OPCION_BIEN_BUSCAR ->
                            mostrarBienPorId();

                    case OPCION_BIEN_LISTAR ->
                            mostrarTodosLosBienes();

                    case OPCION_BIEN_ACTUALIZAR ->
                            actualizarBien();

                    case OPCION_BIEN_ELIMINAR ->
                            eliminarBien();

                    case OPCION_BIEN_VOLVER ->
                            continuar = false;

                    default ->
                            System.out.printf(
                                    MENSAJE_OPCION_INVALIDA + "%n",
                                    valorIngresado);
                }

            } catch (NumberFormatException exception) {

                System.out.printf(
                        MENSAJE_OPCION_INVALIDA + "%n",
                        valorIngresado);

            } catch (BienNoExisteException
                     | BienYaExisteException exception) {

                System.out.println(
                        MENSAJE_ERROR + exception.getMessage());
            }
        }
    }

    private void mostrarMenuBienes() {

        System.out.println();
        System.out.println(TITULO_BIENES);
        System.out.println(SEPARADOR);
        System.out.println("1 - Agregar Bien");
        System.out.println("2 - Buscar Bien por Id");
        System.out.println("3 - Ver todos los Bienes");
        System.out.println("4 - Actualizar Bien");
        System.out.println("5 - Eliminar Bien");
        System.out.println("6 - Volver al menu principal");
        System.out.print(TEXTO_SOLICITUD_OPCION);
    }

    private void registrarUsuario() {

        usuarioControlador.registrar(
                capturarDatosUsuario());

        System.out.println(
                MENSAJE_REGISTRO_EXITOSO);
    }

    private void mostrarUsuarioPorId() {

        System.out.println(
                usuarioControlador.obtenerPorId(
                        capturarId()));
    }

    private void mostrarTodosLosUsuarios() {

        ObtenerUsuarioResponse response =
                usuarioControlador.obtenerTodos();

        if (response.estaVacia()) {

            System.out.println(
                    MENSAJE_LISTA_VACIA);

            return;
        }

        System.out.println(response);
    }

    private RegistrarUsuarioPeticion capturarDatosUsuario() {

        System.out.println();
        System.out.println(TITULO_REGISTRO);

        return new RegistrarUsuarioPeticion(
                capturarId(),
                capturarPassword(),
                capturarNombre(),
                capturarEmail());
    }

    private void registrarBien() {

        System.out.println();
        System.out.println("** INGRESE LOS DATOS DEL NUEVO BIEN **");

        RegistrarBienPeticion peticion =
                new RegistrarBienPeticion(
                        capturarTexto(SOLICITUD_ID),
                        capturarTexto(SOLICITUD_CODIGO),
                        capturarTexto(SOLICITUD_NOMBRE),
                        capturarTexto(SOLICITUD_DESCRIPCION),
                        capturarTexto(SOLICITUD_TIPO),
                        capturarTexto(SOLICITUD_UNIDAD_MEDIDA),
                        capturarValorUnitario(),
                        capturarTexto(SOLICITUD_ESTADO));

        bienControlador.registrar(peticion);

        System.out.println(
                MENSAJE_BIEN_REGISTRADO);
    }

    private void mostrarBienPorId() {

        String id = capturarTexto(SOLICITUD_ID);

        System.out.println(
                bienControlador.obtenerPorId(id));
    }

    private void mostrarTodosLosBienes() {

        ObtenerBienResponse response =
                bienControlador.obtenerTodos();

        if (response.estaVacia()) {

            System.out.println(
                    MENSAJE_BIENES_VACIOS);

            return;
        }

        System.out.println(response);
    }

    private void actualizarBien() {

        System.out.println();
        System.out.println("** ACTUALIZAR BIEN **");

        ActualizarBienPeticion peticion =
                new ActualizarBienPeticion(
                        capturarTexto(SOLICITUD_ID),
                        capturarTexto(SOLICITUD_CODIGO),
                        capturarTexto(SOLICITUD_NOMBRE),
                        capturarTexto(SOLICITUD_DESCRIPCION),
                        capturarTexto(SOLICITUD_TIPO),
                        capturarTexto(SOLICITUD_UNIDAD_MEDIDA),
                        capturarValorUnitario(),
                        capturarTexto(SOLICITUD_ESTADO));

        bienControlador.actualizar(peticion);

        System.out.println(
                MENSAJE_BIEN_ACTUALIZADO);
    }

    private void eliminarBien() {

        System.out.println();
        System.out.println("** ELIMINAR BIEN **");

        String id =
                capturarTexto(SOLICITUD_ID);

        bienControlador.eliminar(
                new EliminarBienPeticion(id));

        System.out.println(
                MENSAJE_BIEN_ELIMINADO);
    }

    private String capturarId() {

        do {

            System.out.print(SOLICITUD_ID);

            String id =
                    limpiarEntrada(entrada.nextLine());

            if (esValido(() -> new UsuarioId(id))) {
                return id;
            }

            System.out.println(
                    MENSAJE_ID_INVALIDO);

        } while (true);
    }

    private String capturarPassword() {

        do {

            System.out.print(SOLICITUD_PASSWORD);

            String password =
                    entrada.nextLine();

            if (esValido(() -> new Password(password))) {
                return password;
            }

            System.out.println(
                    MENSAJE_PASSWORD_INVALIDO);

        } while (true);
    }

    private String capturarNombre() {

        do {

            System.out.print(SOLICITUD_NOMBRE);

            String nombre =
                    limpiarEntrada(entrada.nextLine());

            if (esValido(() -> new NombreUsuario(nombre))) {
                return nombre;
            }

            System.out.println(
                    MENSAJE_NOMBRE_INVALIDO);

        } while (true);
    }

    private String capturarEmail() {

        do {

            System.out.print(SOLICITUD_EMAIL);

            String email =
                    limpiarEntrada(entrada.nextLine());

            if (esValido(() -> new Email(email))) {
                return email;
            }

            System.out.println(
                    MENSAJE_EMAIL_INVALIDO);

        } while (true);
    }

    private String capturarTexto(String mensaje) {

        System.out.print(mensaje);

        return limpiarEntrada(
                entrada.nextLine());
    }

    private double capturarValorUnitario() {

        do {

            System.out.print(
                    SOLICITUD_VALOR_UNITARIO);

            String valor =
                    limpiarEntrada(
                            entrada.nextLine());

            try {

                double numero =
                        Double.parseDouble(valor);

                if (numero >= 0) {
                    return numero;
                }

            } catch (NumberFormatException exception) {
                // Se informa debajo.
            }

            System.out.println(
                    MENSAJE_VALOR_INVALIDO);

        } while (true);
    }

    private static String limpiarEntrada(
            String valor) {

        return valor.replace(
                MARCA_ORDEN_BYTES,
                TEXTO_VACIO).trim();
    }

    private static boolean esValido(
            Runnable validacion) {

        try {

            validacion.run();

            return true;

        } catch (UsuarioInvalidoException exception) {

            return false;
        }
    }
}