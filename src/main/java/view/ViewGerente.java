package view;

import controller.ControllerGerente;
import models.ModelCliente;

import java.io.BufferedReader;
import java.io.IOException;

public class ViewGerente {
    private static void imprimirMenu(){
        System.out.println("1- Registrar Gerente.\n2- Listar Gerente.\n3- Modificar Gerentee.\n4- Eliminar Gerente.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerGerente controller) throws IOException {
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
                    controller.agregarGerentes(nombre, estado, apellido, fechaNacimiento, salario, puesto);
                    break;
                case "2":
                    controller.obtenerGerentes();
                    break;
                case "3":
                    System.out.println("Ingrese el ID: ");
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
                    controller.modificarGerentes(nombreMod, estadoMod, apellidoMod, fechaNacimientoMod, salarioMod, puestoMod,idMod);

                    break;

                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarGerentes(idEliminar);
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
