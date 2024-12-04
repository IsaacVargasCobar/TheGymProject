package controller;

import da.GimnasioDao;
import da.SedeDao;
import models.ConexionModel;
import models.ModelGimnasio;

import models.ModelSede;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControllerGimnasio {
    private ConexionModel conexionModel;

    private ConsoleView conexionView;

    private GimnasioDao gimnasioDao;
    private SedeDao sedeDao;

    public  ControllerGimnasio(ConsoleView conexionView){
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.gimnasioDao =  new GimnasioDao(connection);
        this.sedeDao = new SedeDao(connection);

    }

    public void agregarGimnasios(String telefono, String email, ModelSede sede){
        ModelGimnasio datosGimnasio = new ModelGimnasio(telefono, email, sede);

        try{
            gimnasioDao.agregarGimnasio(datosGimnasio);
            conexionView.mostrarMensaje("Datos del gimnasio insertados correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar insertar un gimnasio" + e.getMessage());
        }
    }

    public void modificarGimnasios(String telefono, String email, ModelSede sede,String id){
        ModelGimnasio datosGimnasio = new ModelGimnasio(telefono, email, sede);
        datosGimnasio.setId(id);
        try{
            gimnasioDao.modificarGimnasio(datosGimnasio);
            conexionView.mostrarMensaje("Datos del gimnasio modificados correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar modificar un gimnasio" + e.getMessage());
        }
    }

    public void eliminarGimnasios(String id){

        try{
            gimnasioDao.eliminarGimnasio(id);
            conexionView.mostrarMensaje("Datos del gimnasio eliminados correctamente");
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un fallo al intentar eliminar un gimnasio" + e.getMessage());
        }

    }

    public void obtenerGimnasios(){

        try{
            ArrayList<ModelGimnasio> modelGimnasios = gimnasioDao.obtenerGimnasio();

            for (ModelGimnasio item : modelGimnasios)
                conexionView.mostrarMensaje
                        ("id: " + item.getId() +
                                " | fecha: " + item.getTelefono() +
                                " | peso: " + item.getEmail() +
                                " | grasa: " + item.getSede());

        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al mostrar los gimnasios" + e.getMessage());
        }
    }

    public ModelSede obtenerBySede(String sede_id) {
        try {
            return sedeDao.obtenerBySede(sede_id);
        } catch (SQLException e) {
            conexionView.mostrarError("Error al buscar los gimnasios: " + e.getMessage());
            return null;
        }
    }
}
