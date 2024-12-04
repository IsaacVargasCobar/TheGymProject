package view;


import controller.ControllerGimnasio;
import models.ModelSede;

import java.io.BufferedReader;
import java.io.IOException;

public class ViewGimnasio {
    private static void imprimirMenu(){
        System.out.println("1- Registrar Gimnasio.\n2- Listar Gimnasio.\n3- Modificar Gimnasio.\n4- Eliminar Gimnasio.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerGimnasio controller) throws IOException {
        String eleccion = "0";
        do {
            imprimirMenu();
            eleccion = br.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    System.out.println("Ingrese su telefono: ");
                    String telefono = br.readLine();
                    System.out.println("Ingrese el email: ");
                    String email = br.readLine();
                    System.out.println("Ingrese su sede: ");
                    String sede = br.readLine();
                    ModelSede sedeId = controller.obtenerBySede(sede);
                    controller.agregarGimnasios(telefono, email,sedeId);
                    break;
                case "2":
                    controller.obtenerGimnasios();
                    break;
                case "3":
                    System.out.println("Ingrese su ID: ");
                    String idMod = br.readLine();
                    System.out.println("Ingrese su telefono: ");
                    String telefonoMod = br.readLine();
                    System.out.println("Ingrese el email: ");
                    String emailMod = br.readLine();
                    System.out.println("Ingrese su sede: ");
                    String sedeMod = br.readLine();
                    ModelSede sedeIdMod = controller.obtenerBySede(sedeMod);
                    controller.modificarGimnasios(telefonoMod, emailMod,sedeIdMod,idMod);

                    break;

                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarGimnasios(idEliminar);
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
