package controller;

import da.GerenteDao;
import models.ConexionModel;
import models.ModelFactura;
import models.ModelGerente;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerGerente {

    private ConexionModel conexionModel;

    private ConsoleView conexionView;
    private GerenteDao gerenteDao;

    public ControllerGerente(ConsoleView conexionView){
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.gerenteDao = new GerenteDao(connection);

    }

    public void agregarGerentes(String nombre, String estado, String apellido, String fechaNacimiento, String salario, String puesto){
        ModelGerente datoGerente = new ModelGerente(nombre, estado, apellido, fechaNacimiento, salario, puesto);

        try{
            gerenteDao.agregarGerente(datoGerente);
            conexionView.mostrarMensaje("Datos del gerente insertados correctamente");
        }catch (SQLException e){
            conexionView.mostrarError("Fallo al ingresar datos del gerente" + e.getMessage());
        }
    }

    public void modificarGerentes(String nombre, String estado, String apellido, String fechaNacimiento, String salario, String puesto,String id) {
        ModelGerente datoGerente = new ModelGerente(nombre, estado, apellido, fechaNacimiento, salario, puesto);
        datoGerente.setId(id);
        try{
            gerenteDao.modificarGerente(datoGerente);
            conexionView.mostrarMensaje("Datos del gerente modificados correctamente");
        }catch (SQLException e){
            conexionView.mostrarError("Fallo al modificar datos del gerente" + e.getMessage());
        }
    }

    public void eliminarGerentes(String id){

        try{
            gerenteDao.eliminarGerente(id);
            conexionView.mostrarMensaje("Datos del gerente eliminados");
        }catch (SQLException e){
            conexionView.mostrarError("Fallo al eliminar datos del gerente");
        }
    }

    public void obtenerGerentes (){

        try{
            ArrayList<ModelGerente> modelGerentes = gerenteDao.obtenerGerente();

            for (ModelGerente item : modelGerentes)
                conexionView.mostrarMensaje
                        ("id: " + item.getId() +
                                " | nombre: " + item.getNombre() +
                                " | estado: " + item.getEstado() +
                                " | apellido: " + item.getApellido() +
                                " | fechaNacimiento: " + item.getFechaNacimiento() +
                                " | salario: " + item.getSalario() +
                                " | puesto: " + item.getPuesto());
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al mostrar el gerente" + e.getMessage());
        }
    }
}
