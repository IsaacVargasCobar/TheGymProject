package view;

import controller.ControllerMedicion;
import controller.ControllerRutina;
import models.ModelCliente;

import java.io.BufferedReader;
import java.io.IOException;

public class ViewRutina {
    private static void imprimirMenu(){
        System.out.println("1- Registrar Rutina.\n2- Listar Rutina.\n3- Modificar Rutina.\n4- Eliminar Rutina.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerRutina controller) throws IOException {
        String eleccion = "0";
        do {
            imprimirMenu();
            eleccion = br.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    System.out.println("Ingrese su ejercicio: ");
                    String ejercicio = br.readLine();
                    System.out.println("Ingrese la Zona Muscular: ");
                    String zonaMuscular = br.readLine();
                    System.out.println("Ingrese los sets: ");
                    String sets = br.readLine();
                    System.out.println("Ingrese el repeticiones: ");
                    String repeticiones = br.readLine();
                    controller.agregarRutinas(ejercicio, zonaMuscular, sets, repeticiones);
                    break;
                case "2":
                    controller.obtenerRutinas();
                    break;
                case "3":
                    System.out.println("Ingrese el ID: ");
                    String idMod = br.readLine();
                    System.out.println("Ingrese su ejercicio: ");
                    String ejercicioMod = br.readLine();
                    System.out.println("Ingrese la Zona Muscular: ");
                    String zonaMuscularMod = br.readLine();
                    System.out.println("Ingrese los sets: ");
                    String setsMod = br.readLine();
                    System.out.println("Ingrese el repeticiones: ");
                    String repeticionesMod = br.readLine();
                    controller.modificarRutinas(ejercicioMod, zonaMuscularMod, setsMod, repeticionesMod,idMod);

                    break;

                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarRutinas(idEliminar);
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
