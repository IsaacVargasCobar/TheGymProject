package controller;


import da.ClienteDao;
import da.FacturaDao;
import models.ConexionModel;
import models.ModelCliente;
import models.ModelFactura;
import models.ModelRutina;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerFactura {

    private ConexionModel conexionModel;

    private ConsoleView conexionView;

    private FacturaDao facturaDao;
    private ClienteDao clienteDao;

    public ControllerFactura(ConsoleView conexionView) {
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.facturaDao = new FacturaDao(connection);
        this.clienteDao = new ClienteDao(connection);
    }

    public void agregarFacturas(ModelCliente cliente, double monto, String descripcion, String emisor){
        ModelFactura datosfactura = new ModelFactura(cliente, monto, descripcion, emisor);
        try{
            facturaDao.agregarFactura(datosfactura);
            conexionView.mostrarMensaje("Datos de la factura insertados correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar insertar una nueva factura" + e.getMessage());
        }
    }

    public void modificarFacturas(ModelCliente cliente, double monto, String descripcion, String emisor, String id){
        ModelFactura datosfactura = new ModelFactura(cliente, monto, descripcion, emisor);
        datosfactura.setId(id);

        try {
            facturaDao.modificarFactura(datosfactura);
            conexionView.mostrarMensaje("Datos de la factura modificados correctamente");

        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar modificar una nueva factura" + e.getMessage());
        }
    }

    public void eliminarFacturas(String id){

        try{
            facturaDao.eliminarFactura(id);
            conexionView.mostrarMensaje("Datos de la factura eliminados");
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al eliminar una factura" + e.getMessage());
        }

    }

    public void obtenerFacturas (){

        try{
            ArrayList<ModelFactura> modelFacturas = facturaDao.obtenerFactura();

            for (ModelFactura item : modelFacturas)
                conexionView.mostrarMensaje
                        ("id: " + item.getId() +
                        " | cliente: " + item.getCliente() +
                        " | monto: " + item.getMonto() +
                        " | descripcion: " + item.getDescripcion() +
                        " | emisor: " + item.getEmisor());
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al mostrar las facturas" + e.getMessage());
        }
    }

    public ModelCliente obtenerByCliente(String cliente_id) {
        try {
            return clienteDao.obtenerByCliente(cliente_id);

        } catch (SQLException e) {
            conexionView.mostrarError("Error al buscar la factura: " + e.getMessage());

        }
        return null;
    }


}
