package controller;

import da.RutinaDao;
import models.ConexionModel;
import models.ModelRutina;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerRutina {
    private ConexionModel conexionModel;

    private ConsoleView conexionView;
    private RutinaDao rutinaDao;

    public  ControllerRutina(ConsoleView conexionView) {
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.rutinaDao =  new RutinaDao(connection);
        }

    public void agregarRutinas(String ejercicio, String zonaMuscular, String sets, String repeticiones){
        ModelRutina datosRutina = new ModelRutina(ejercicio, zonaMuscular,sets, repeticiones);

        try{
            rutinaDao.agregarRutina(datosRutina);
            conexionView.mostrarMensaje("Datos de la rutina insertados correctamente");
        }catch (SQLException e){
            conexionView.mostrarError("Fallo al insertar una rutina" + e.getMessage());
        }

    }

    public void modificarRutinas(String ejercicio, String zonaMuscular, String sets, String repeticiones,String id){
        ModelRutina datosRutina = new ModelRutina(ejercicio, zonaMuscular,sets, repeticiones);
        datosRutina.setId(id);

        try{
            rutinaDao.modificarRutina(datosRutina);
            conexionView.mostrarMensaje("Datos de la rutina modificados correctamente");
        }catch (SQLException e){
            conexionView.mostrarError("Fallo al modificar una rutina" + e.getMessage());
        }
    }

    public void eliminarRutinas(String id){
        try {
            rutinaDao.eliminarRutina(id);
            conexionView.mostrarMensaje("Datos de la rutina eliminados");
        } catch (SQLException e) {
            conexionView.mostrarError("Hubo un fallo al intentar eliminar una nueva rutina" + e.getMessage());
        }
    }


    public void obtenerRutinas (){

        try{
            ArrayList<ModelRutina> modelRutinas = rutinaDao.obtenerRutina();

            for (ModelRutina item : modelRutinas)
                conexionView.mostrarMensaje
                        ("rutina_id: " + item.getId() +
                                " | ejercicio: " + item.getEjercicio() +
                                " | zonaMuscular: " + item.getZonaMuscular() +
                                " | sets: " + item.getSets() +
                                " | repeticiones: " + item.getRepeticiones());
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al mostrar las rutinas" + e.getMessage());
        }
    }
}
