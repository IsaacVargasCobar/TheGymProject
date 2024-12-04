package view;


import controller.ControllerFactura;
import models.ModelCliente;
import models.ModelRutina;

import java.io.BufferedReader;
import java.io.IOException;

public class ViewFactura {
    private static void imprimirMenu(){
        System.out.println("1- Registrar Factura.\n2- Listar Factura.\n3- Modificar Factura.\n4- Eliminar Factura.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerFactura controller) throws IOException {
        String eleccion = "0";
        do {
            imprimirMenu();
            eleccion = br.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    System.out.println("Ingrese al cliente: ");
                    String clienteid = br.readLine();
                    ModelCliente cliente_id = controller.obtenerByCliente(clienteid);
                    System.out.println("Ingrese el monto: ");
                    Double monto = Double.valueOf(br.readLine());
                    System.out.println("Ingrese la descripcion: ");
                    String descripcion = br.readLine();
                    System.out.println("Ingrese el emisor: ");
                    String emisor = br.readLine();
                  controller.agregarFacturas(cliente_id, monto, descripcion, emisor);
                    break;
                case "2":
                    controller.obtenerFacturas();
                    break;
                case "3":
                    System.out.println("Ingrese el ID: ");
                    String idMod = br.readLine();
                    System.out.println("Ingrese del cliente: ");
                    String clienteidMod = br.readLine();
                    ModelCliente cliente_idMod = controller.obtenerByCliente(clienteidMod);
                    System.out.println("Ingrese el monto: ");
                    Double montoMod = Double.valueOf(br.readLine());
                    System.out.println("Ingrese la descripcion: ");
                    String descripcionMod = br.readLine();
                    System.out.println("Ingrese el emisor: ");
                    String emisorMod = br.readLine();
                    controller.modificarFacturas(cliente_idMod, montoMod, descripcionMod, emisorMod,idMod);

                    break;

                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarFacturas(idEliminar);
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
