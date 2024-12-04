package UI;

import controller.*;
import view.*;


import java.io.BufferedReader;
import java.io.InputStreamReader;


    public class Main {
        public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));


        public static void main(String[] args) throws Exception {

            ConsoleView console = new ConsoleView();

            ConexionController controlador = new ConexionController(console);

            controlador.abrirConexion();

            System.out.println("Bienvenido al gestor del gimnasio, por favor selecione una opción: ");

            String eleccion = "0";
            do {
                System.out.println("1- Gestionar Cliente \n 2- Gestionar Factura \n 3- Gestionar Gerente \n 4- Gestionar Gimnasio \n 5- Gestionar Instructor \n 6- Gestionar Medicion \n 7- Gestionar Rutina \n 8- Gestionar Sede \n S- Salir del gestor");
                eleccion = leer.readLine().trim(); // Agregamos trim()
                switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"

                    case "1":
                        ControllerCliente controllerCliente  = new ControllerCliente(console);
                                ViewCliente.seleccionarOpc(leer, controllerCliente);
                        break;

                    case "2":
                        ControllerFactura controllerFactura = new ControllerFactura(console);
                        ViewFactura.seleccionarOpc(leer, controllerFactura);
                        break;

                    case "3":
                        ControllerGerente controllerGerente= new ControllerGerente(console);
                        ViewGerente.seleccionarOpc(leer, controllerGerente);
                        break;

                    case "4":
                        ControllerGimnasio controllerGimnasio = new ControllerGimnasio(console);
                        ViewGimnasio.seleccionarOpc(leer, controllerGimnasio);
                        break;
                    case "5":
                        ControllerInstructor controllerInstructor = new ControllerInstructor(console);
                        ViewInstructor.seleccionarOpc(leer, controllerInstructor);
                        break;
                    case "6":
                        ControllerMedicion controllerMedicion = new ControllerMedicion(console);
                        ViewMedicion.seleccionarOpc(leer, controllerMedicion);
                        break;

                    case "7":
                       ControllerRutina controllerRutina = new ControllerRutina(console);
                       ViewRutina.seleccionarOpc(leer, controllerRutina);
                     break;

                 case "8":
                      ControllerSede  controllerSede  = new ControllerSede(console);
                       ViewSede.seleccionarOpc(leer, controllerSede);
                      break;

                    case "S":
                        System.out.println("Gracias por su preferencia. ");
                        break;
                    default:
                        System.out.println("Intente de nuevo, ingrese una opcion valida  ");
                        break;
                }
            } while (!eleccion.equalsIgnoreCase("S"));

        }
    }
