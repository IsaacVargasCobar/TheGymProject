package view;


import controller.ControllerInstructor;
import models.ModelCliente;
import models.ModelRutina;

import java.io.BufferedReader;
import java.io.IOException;

public class ViewInstructor {
    private static void imprimirMenu(){
        System.out.println("1- Registrar Instructor.\n2- Listar Instructor.\n3- Modificar Instructor.\n4- Eliminar Instructor.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerInstructor controller) throws IOException {
        String eleccion = "0";
        do {
            imprimirMenu();
            eleccion = br.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    System.out.println("Ingrese su nombre: ");
                    String nombre = br.readLine();
                    System.out.println("Ingrese el estado: ");
                    String estado = br.readLine();
                    System.out.println("Ingrese su apellido: ");
                    String apellido = br.readLine();
                    System.out.println("Ingrese su Fecha de Nacimiento: ");
                    String fechaNacimiento = br.readLine();
                    System.out.println("Ingrese su salario: ");
                    String salario = br.readLine();
                    System.out.println("Ingrese su puesto: ");
                    String puesto = br.readLine();
                    System.out.println("Ingrese su certificacion: ");
                    String certificado = br.readLine();
                    System.out.println("Ingrese su cliente asignado: ");
                    String cliente_id = br.readLine();
                    ModelCliente cliente = controller.obtenerByCliente(cliente_id);
                    System.out.println("Ingrese su rutina : ");
                    String rutina_id = br.readLine();
                    ModelRutina rutina = controller.obtenerByRutina(rutina_id);

                    controller.agregarInstructores(nombre, estado, apellido, fechaNacimiento, salario, puesto, certificado,cliente, rutina);
                    break;
                case "2":
                    controller.obtenerInstructores();
                    break;
                case "3":
                    System.out.println("Ingrese su ID: ");
                    String idMod = br.readLine();
                    System.out.println("Ingrese su nombre: ");
                    String nombreMod = br.readLine();
                    System.out.println("Ingrese el estado: ");
                    String estadoMod = br.readLine();
                    System.out.println("Ingrese su apellido: ");
                    String apellidoMod = br.readLine();
                    System.out.println("Ingrese su Fecha de Nacimiento: ");
                    String fechaNacimientoMod = br.readLine();
                    System.out.println("Ingrese su salario: ");
                    String salarioMod = br.readLine();
                    System.out.println("Ingrese su puesto: ");
                    String puestoMod = br.readLine();
                    System.out.println("Ingrese su certificacion: ");
                    String certificadoMod = br.readLine();
                    System.out.println("Ingrese su cliente asignado: ");
                    String cliente_idMod = br.readLine();
                    ModelCliente clienteMod = controller.obtenerByCliente(cliente_idMod);
                    System.out.println("Ingrese su rutina : ");
                    String rutina_idMod = br.readLine();
                    ModelRutina rutinaMod = controller.obtenerByRutina(rutina_idMod);

                    controller.modificarInstructores(nombreMod, estadoMod, apellidoMod, fechaNacimientoMod, salarioMod, puestoMod, certificadoMod,clienteMod, rutinaMod,idMod);
                    break;

                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarInstructor(idEliminar);
                    break;
                case "S":
                    System.out.println("Gracias por su preferencia. ");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida  ");
                    break;
            }
        } while (!eleccion.equalsIgnoreCase("S"));

    }
}
