package view;


import controller.ControllerMedicion;
import models.ModelCliente;

import java.io.BufferedReader;
import java.io.IOException;


public class ViewMedicion {
    private static void imprimirMenu(){
        System.out.println("1- Registrar Medicion.\n2- Listar Medicion.\n3- Modificar Medicion.\n4- Eliminar Medicion.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerMedicion controller) throws IOException {
        String eleccion = "0";
        do {
            imprimirMenu();
            eleccion = br.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    System.out.println("Ingrese su fecha: ");
                    String fecha = br.readLine();
                    System.out.println("Ingrese el peso: ");
                    Double peso = Double.valueOf(br.readLine());
                    System.out.println("Ingrese la grasa corporal: ");
                    Double grasa = Double.valueOf(br.readLine());
                    System.out.println("Ingrese el musculo: ");
                    Double musculo = Double.valueOf(br.readLine());
                    System.out.println("Ingrese su Edad Metabolica: ");
                    Double edadMetabolica = Double.valueOf(br.readLine());
                    System.out.println("Ingrese su grasa Viseral: ");
                    Double grasaVisceral = Double.valueOf(br.readLine());
                    System.out.println("Ingrese al cliente: ");
                    String cliente = br.readLine();
                    ModelCliente cliente_id = controller.obtenerByCliente(cliente);
                    controller.agregarMediciones(fecha, peso, grasa, musculo, edadMetabolica, grasaVisceral, cliente_id);
                    break;
                case "2":
                    controller.obtenerMediciones();
                    break;
                case "3":

                    System.out.println("Ingrese su ID: ");
                    String idMod = br.readLine();
                    System.out.println("Ingrese su fecha: ");
                    String fechaMod = br.readLine();
                    System.out.println("Ingrese el peso: ");
                    Double pesoMod = Double.valueOf(br.readLine());
                    System.out.println("Ingrese la grasa corporal: ");
                    Double grasaMod = Double.valueOf(br.readLine());
                    System.out.println("Ingrese el musculo: ");
                    Double musculoMod = Double.valueOf(br.readLine());
                    System.out.println("Ingrese su Edad Metabolica: ");
                    Double edadMetabolicaMod = Double.valueOf(br.readLine());
                    System.out.println("Ingrese su grasa Visceral: ");
                    Double grasaVisceralMod = Double.valueOf(br.readLine());
                    System.out.println("Ingrese al cliente: ");
                    String clienteMod = br.readLine();
                    ModelCliente cliente_idMod = controller.obtenerByCliente(clienteMod);
                    controller.modificaMediciones(fechaMod, pesoMod, grasaMod, musculoMod, edadMetabolicaMod, grasaVisceralMod,cliente_idMod,idMod);

                    break;

                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarMediciones(idEliminar);
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
