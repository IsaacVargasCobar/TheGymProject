package controller;

import da.ClienteDao;
import da.MedicionDao;
import models.ConexionModel;
import models.ModelCliente;
import models.ModelMedicion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControllerMedicion {

    private ConexionModel conexionModel;

    private ConsoleView conexionView;

    private MedicionDao medicionDao;

    private ClienteDao clienteDao;

    public ControllerMedicion(ConsoleView conexionView){
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.medicionDao = new MedicionDao(connection);
        this.clienteDao = new ClienteDao(connection);
    }
    public void agregarMediciones(String fecha, double peso, double grasa, double musculo, double edadMetabolica, double grasaVisceral,  ModelCliente cliente){
        ModelMedicion datosMedicion = new ModelMedicion(fecha, peso,  grasa,  musculo, edadMetabolica,  grasaVisceral,  cliente);
        try{
            medicionDao.agregarMedicion(datosMedicion);
            conexionView.mostrarMensaje("Datos de la medicion corporal insertados correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar insertar una medicion corporal" + e.getMessage());
        }
    }

    public void modificaMediciones(String fecha, double peso, double grasa, double musculo, double edadMetabolica, double grasaVisceral, ModelCliente cliente, String id){
        ModelMedicion datosMedicion = new ModelMedicion(fecha, peso,  grasa,  musculo,  edadMetabolica,  grasaVisceral, cliente);
        datosMedicion.setId(id);
        try{
            medicionDao.modificarInstructor(datosMedicion);
            conexionView.mostrarMensaje("Datos de la medicion corporal modificados correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar modificar una medicion corporal" + e.getMessage());
        }
    }

    public void eliminarMediciones(String id){

        try{
            medicionDao.eliminarMedicion(id);
            conexionView.mostrarMensaje("Datos de la medicion corporal han sido eliminados");
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al eliminar la medicion corporal" + e.getMessage());
        }

    }

    public void obtenerMediciones(){

        try{
            ArrayList<ModelMedicion> modelMediciones = medicionDao.obtenerMedicion();

            for (ModelMedicion item : modelMediciones)
                conexionView.mostrarMensaje
                        ("id: " + item.getId() +
                                " | fecha: " + item.getFecha() +
                                " | peso: " + item.getPeso() +
                                " | grasa: " + item.getGrasa() +
                                " | musculo: " + item.getMusculo()+
                                " | edadMetabolica: " + item.getEdadMetabolica() +
                                " | grasaViseral: " + item.getGrasaVisceral()+
                                " | cliente: " + item.getCliente());
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al mostrar las mediciones" + e.getMessage());
        }
    }

    public ModelCliente obtenerByCliente(String cliente_id) {
        try {
            return clienteDao.obtenerByCliente(cliente_id);
        } catch (SQLException e) {
            conexionView.mostrarError("Error al buscar la rutina: " + e.getMessage());
            return null;
        }
    }
}

