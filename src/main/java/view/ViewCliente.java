package view;



import controller.ControllerCliente;

import models.ModelRutina;

import java.io.BufferedReader;
import java.io.IOException;


public class ViewCliente {

    private static void imprimirMenu(){
        System.out.println("1- Registrar Cliente.\n2- Listar Cliente.\n3- Modificar Cliente.\n4- Eliminar Cliente.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerCliente controller) throws IOException {
        String eleccion = "0";
        do {
            imprimirMenu();
            eleccion = br.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    System.out.println("Ingrese el nombre: ");
                    String nombre = br.readLine();
                    System.out.println("Ingrese la apellido: ");
                    String apellido = br.readLine();
                    System.out.println("Ingrese el email: ");
                    String email = br.readLine();
                    System.out.println("Ingrese la Fecha de Nacimiento: ");
                    String fechaNacimiento = br.readLine();
                    System.out.println("Ingrese la estatura: ");
                    String estatura = br.readLine();
                    System.out.println("Ingrese el sexo: ");
                    String sexo = br.readLine();
                    System.out.println("¿Es de alto riego?: ");
                    String altoRiesgo = br.readLine();
                    System.out.println("Ingrese su rutina: ");
                    String rutina_id = br.readLine();
                    ModelRutina rutina = controller.obtenerByRutina(rutina_id);
                    controller.agregarClientes(nombre, apellido, email, fechaNacimiento, estatura, sexo, altoRiesgo, rutina);
                    break;
                case "2":
                    controller.obtenerClientes();
                    break;
                case "3":
                    System.out.println("Ingrese el ID: ");
                    String idMod = br.readLine();
                    System.out.println("Ingrese el nombre: ");
                    String nombreMod = br.readLine();
                    System.out.println("Ingrese la apellido: ");
                    String apellidoMod = br.readLine();
                    System.out.println("Ingrese el email: ");
                    String emailMod = br.readLine();
                    System.out.println("Ingrese la fecha de nacimiento: ");
                    String fechaNacimientoMod = br.readLine();
                    System.out.println("Ingrese la estatura: ");
                    String estaturaMod = br.readLine();
                    System.out.println("Ingrese el sexo: ");
                    String sexoMod = br.readLine();
                    System.out.println("¿Es de alto riego?: ");
                    String altoRiesgoMod = br.readLine();
                    System.out.println("Ingrese su rutina: ");
                    String rutina_idMod = br.readLine();
                    ModelRutina rutinaMod = controller.obtenerByRutina(rutina_idMod);
                    controller.modificarClientes(nombreMod, apellidoMod, emailMod, fechaNacimientoMod, estaturaMod, sexoMod, altoRiesgoMod, rutinaMod,idMod);
                    break;

                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarClientes(idEliminar);
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

