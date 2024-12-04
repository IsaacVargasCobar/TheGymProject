package view;

import controller.ControllerMedicion;
import controller.ControllerSede;
import models.ModelCliente;
import models.ModelEmpleado;

import java.io.BufferedReader;
import java.io.IOException;

public class ViewSede {
    private static void imprimirMenu(){
        System.out.println("1- Registrar Sede.\n2- Listar Sede.\n3- Modificar Sede.\n4- Eliminar Sede.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerSede controller) throws IOException {
        String eleccion = "0";
        do {
            imprimirMenu();
            eleccion = br.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    System.out.println("Ingrese su provincia: ");
                    String provincia = br.readLine();
                    System.out.println("Ingrese el canton: ");
                    String canton = br.readLine();
                    System.out.println("Ingrese el email: ");
                    String email = br.readLine();
                    System.out.println("Ingrese el telefono: ");
                    String telefono = br.readLine();

                    controller.agregarSede(provincia, canton, email, telefono);
                    break;
                case "2":
                    controller.obtenerSedes();
                    break;
                case "3":
                    System.out.println("Ingrese su ID: ");
                    String idMod = br.readLine();
                    System.out.println("Ingrese su provincia: ");
                    String provinciaMod = br.readLine();
                    System.out.println("Ingrese el canton: ");
                    String cantonMod = br.readLine();
                    System.out.println("Ingrese el email: ");
                    String emailMod = br.readLine();
                    System.out.println("Ingrese el telefono: ");
                    String telefonoMod = br.readLine();

                    controller.modificarSedes(provinciaMod, cantonMod, emailMod, telefonoMod,idMod);

                    break;

                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarSedes(idEliminar);
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
