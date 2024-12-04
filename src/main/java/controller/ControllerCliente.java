package controller;

import da.ClienteDao;
import models.ConexionModel;
import models.ModelCliente;
import models.ModelRutina;
import view.ConsoleView;
import da.RutinaDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerCliente {

    private ConexionModel conexionModel;

    private ConsoleView conexionView;

    private ClienteDao clienteDao;
    private RutinaDao rutinaDao;
    public ControllerCliente(ConsoleView conexionView) {
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.clienteDao = new ClienteDao(connection);
        this.rutinaDao = new RutinaDao(connection);
    }

    public void agregarClientes(String nombre, String apellido, String email, String fechaNacimiento, String estatura, String sexo, String altoRiesgo, ModelRutina rutina) {
        ModelCliente datosCliente = new ModelCliente(nombre, apellido, email, fechaNacimiento, estatura, sexo, altoRiesgo, rutina);

        try {
            clienteDao.agregarCliente(datosCliente);
            conexionView.mostrarMensaje("Datos del cliente insertados correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar insertar un nuevo cliente" + e.getMessage());
        }
    }

    public void modificarClientes(String nombre, String apellido, String email, String fechaNacimiento, String estatura, String sexo, String altoRiesgo, ModelRutina rutina, String id) {
        ModelCliente datosCliente = new ModelCliente(nombre, apellido, email, fechaNacimiento, estatura, sexo, altoRiesgo, rutina);
        datosCliente.setId(id);

        try {
            clienteDao.modificarCliente(datosCliente);
            conexionView.mostrarMensaje("Datos del cliente modificados correctamente");

        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar modificar un nuevo cliente" + e.getMessage());
        }
    }

    public void eliminarClientes(String id) {
        try {
            clienteDao.eliminarCliente(id);
            conexionView.mostrarMensaje("Datos del cliente eliminados");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar eliminar un nuevo cliente" + e.getMessage());
        }
    }

    public void obtenerClientes() {
        try {
            ArrayList<ModelCliente> modelClientes = clienteDao.obtenerCliente();
            for (ModelCliente item : modelClientes)
                conexionView.mostrarMensaje("id: " + item.getId() +
                        " | nombre: " + item.getNombre() +
                        " | apellido: " + item.getApellido() +
                        " | email: " + item.getEmail() +
                        " | apellido: " + item.getFechaNacimiento() +
                        " | estatura: " + item.getEstatura() +
                        " | altoRiesgo: " + item.getAltoRiesgo() +
                        " | rutina: " + item.getRutina());


        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar mostrar los clientes");
        }
    }

    public ModelRutina obtenerByRutina(String rutina_id) {
        try {
            return rutinaDao.obtenerByRutina(rutina_id);
        } catch (SQLException e) {
            conexionView.mostrarError("Error al buscar la rutina: " + e.getMessage());
            return null;
        }
    }

}



