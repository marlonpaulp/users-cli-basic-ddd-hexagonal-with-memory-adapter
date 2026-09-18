package com.jcaa.udec.collections.entrypoint.cli;

import com.jcaa.udec.collections.domain.core.exception.BienNoExisteException;
import com.jcaa.udec.collections.domain.core.exception.BienYaExisteException;
import com.jcaa.udec.collections.entrypoint.controller.BienControlador;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.ActualizarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.EliminarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.request.RegistrarBienPeticion;
import com.jcaa.udec.collections.entrypoint.controller.dto.response.ObtenerBienResponse;

import java.util.Scanner;

public class BienCli {

    private static final int AGREGAR = 1;
    private static final int BUSCAR = 2;
    private static final int LISTAR = 3;
    private static final int ACTUALIZAR = 4;
    private static final int ELIMINAR = 5;
    private static final int SALIR = 6;

    private final BienControlador bienControlador;
    private final Scanner entrada;

    public BienCli(BienControlador bienControlador) {
        this(bienControlador, new Scanner(System.in));
    }

    BienCli(
            BienControlador bienControlador,
            Scanner entrada) {
        this.bienControlador = bienControlador;
        this.entrada = entrada;
    }

    public void ejecutar() {

        boolean continuar = true;

        while (continuar) {

            mostrarMenu();

            String opcion =
                    entrada.nextLine().trim();

            try {

                switch (Integer.parseInt(opcion)) {

                    case AGREGAR ->
                            registrar();

                    case BUSCAR ->
                            buscar();

                    case LISTAR ->
                            listar();

                    case ACTUALIZAR ->
                            actualizar();

                    case ELIMINAR ->
                            eliminar();

                    case SALIR ->
                            continuar = false;

                    default ->
                            System.out.println(
                                    "Opcion invalida.");

                }

            } catch (NumberFormatException exception) {

                System.out.println(
                        "Opcion invalida.");

            } catch (BienNoExisteException
                     | BienYaExisteException exception) {

                System.out.println(
                        "ERROR: " + exception.getMessage());
            }
        }

        System.out.println(
                "Fin de la demostracion de Bien.");
    }

    private void mostrarMenu() {

        System.out.println();
        System.out.println(
                "======================================");

        System.out.println(
                "       CRUDL - GESTION DE BIENES");

        System.out.println(
                "======================================");

        System.out.println(
                "1 - Crear Bien");

        System.out.println(
                "2 - Buscar Bien por ID");

        System.out.println(
                "3 - Listar Bienes");

        System.out.println(
                "4 - Actualizar Bien");

        System.out.println(
                "5 - Eliminar Bien");

        System.out.println(
                "6 - Salir");

        System.out.print(
                "Seleccione una opcion: ");
    }

    private void registrar() {

        System.out.println();
        System.out.println(
                "--- CREAR BIEN ---");

        RegistrarBienPeticion peticion =
                new RegistrarBienPeticion(
                        capturar("ID: "),
                        capturar("CODIGO: "),
                        capturar("NOMBRE: "),
                        capturar("DESCRIPCION: "),
                        capturar("TIPO: "),
                        capturar("UNIDAD DE MEDIDA: "),
                        capturarValor(),
                        capturar("ESTADO: "));

        bienControlador.registrar(peticion);

        System.out.println(
                "Bien registrado correctamente.");
    }

    private void buscar() {

        System.out.println();
        System.out.println(
                "--- BUSCAR BIEN ---");

        String id = capturar("ID: ");

        System.out.println(
                bienControlador.obtenerPorId(id));
    }

    private void listar() {

        System.out.println();
        System.out.println(
                "--- LISTADO DE BIENES ---");

        ObtenerBienResponse response =
                bienControlador.obtenerTodos();

        if (response.estaVacia()) {

            System.out.println(
                    "No hay bienes registrados.");

            return;
        }

        System.out.println(response);
    }

    private void actualizar() {

        System.out.println();
        System.out.println(
                "--- ACTUALIZAR BIEN ---");

        ActualizarBienPeticion peticion =
                new ActualizarBienPeticion(
                        capturar("ID: "),
                        capturar("NUEVO CODIGO: "),
                        capturar("NUEVO NOMBRE: "),
                        capturar("NUEVA DESCRIPCION: "),
                        capturar("NUEVO TIPO: "),
                        capturar("NUEVA UNIDAD DE MEDIDA: "),
                        capturarValor(),
                        capturar("NUEVO ESTADO: "));

        bienControlador.actualizar(peticion);

        System.out.println(
                "Bien actualizado correctamente.");
    }

    private void eliminar() {

        System.out.println();
        System.out.println(
                "--- ELIMINAR BIEN ---");

        String id = capturar("ID: ");

        bienControlador.eliminar(
                new EliminarBienPeticion(id));

        System.out.println(
                "Bien eliminado correctamente.");
    }

    private String capturar(String mensaje) {

        System.out.print(mensaje);

        return entrada.nextLine().trim();
    }

    private double capturarValor() {

        while (true) {

            String valor =
                    capturar("VALOR UNITARIO: ");

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
                    "Valor invalido. "
                            + "Ingrese un numero mayor o igual a cero.");
        }
    }
}
