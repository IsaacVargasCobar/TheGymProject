package controller;

import da.EmpleadoDao;
import da.SedeDao;
import models.ConexionModel;

import models.ModelEmpleado;
import models.ModelSede;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerSede {

    private ConexionModel conexionModel;

    private ConsoleView conexionView;

    private SedeDao sedeDao;
    private EmpleadoDao empleadoDao;

    public ControllerSede(ConsoleView conexionView){
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.sedeDao = new SedeDao(connection);
        this.empleadoDao = new EmpleadoDao(connection);
    }

    public void agregarSede(String provincia, String canton, String email, String telefono){
        ModelSede datosSede = new ModelSede(provincia,canton,email,telefono);
        try{
            sedeDao.agregarSede(datosSede);
            conexionView.mostrarMensaje("Datos de la sede insertados correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar insertar una sede" + e.getMessage());
        }
    }

    public void modificarSedes(String provincia, String canton, String email, String telefono,String id){
        ModelSede datosSede = new ModelSede(provincia,canton,email,telefono);
        datosSede.setId(id);
        try{
            sedeDao.modificarSede(datosSede);
            conexionView.mostrarMensaje("Datos de la sede modificados correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar modificar la sede" + e.getMessage());
        }
    }

    public void eliminarSedes(String id){

        try{
            sedeDao.eliminarSede(id);
            conexionView.mostrarMensaje("Datos de la sede han sido eliminados");
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al eliminar la sede seleccionada" + e.getMessage());
        }

    }

    public void obtenerSedes(){

        try{
            ArrayList<ModelSede> modelSede = sedeDao.obtenerSede();

            for (ModelSede item : modelSede)
                conexionView.mostrarMensaje
                        ("id: " + item.getId() +
                                " | provincia: " + item.getProvincia() +
                                " | canton: " + item.getCanton() +
                                " | email: " + item.getEmail() +
                                " | telefono: " + item.getTelefono()+
                                " | empleado: " + item.getEmpleado());
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al mostrar las sedes seleccionadas" + e.getMessage());
        }
    }

    public ModelEmpleado obtenerByEmpleado(String empleado_id) {
        try {
            return empleadoDao.obtenerByEmpleado(empleado_id);
        } catch (SQLException e) {
            conexionView.mostrarError("Error al buscar el empleado: " + e.getMessage());
            return null;
        }
    }
}
