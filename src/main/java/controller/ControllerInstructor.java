package controller;

import da.ClienteDao;
import da.InstructorDao;
import da.RutinaDao;
import models.ConexionModel;
import models.ModelCliente;
import models.ModelInstructor;
import models.ModelRutina;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerInstructor {
    private ConexionModel conexionModel;

    private ConsoleView conexionView;
    private InstructorDao instructorDao;
    private RutinaDao rutinaDao;
    private ClienteDao clienteDao;

    public ControllerInstructor (ConsoleView conexionView){
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.instructorDao = new InstructorDao(connection);
        this.clienteDao = new ClienteDao(connection);
        this.rutinaDao = new RutinaDao(connection);

    }

    public void agregarInstructores(String nombre, String estado, String apellido, String fechaNacimiento, String salario, String puesto, String certificado, ModelCliente cliente, ModelRutina rutina){
        ModelInstructor datoInstructor = new ModelInstructor(nombre, estado, apellido, fechaNacimiento, salario, puesto, certificado, cliente, rutina);

        try{
           instructorDao.agregarInstructor(datoInstructor);
            conexionView.mostrarMensaje("Datos del instructor insertados correctamente");
        }catch (SQLException e){
            conexionView.mostrarError("Fallo al ingresar datos del instructor" + e.getMessage());
        }
    }

    public void modificarInstructores(String nombre, String estado, String apellido, String fechaNacimiento, String salario, String puesto, String certicado, ModelCliente cliente, ModelRutina rutina,String id){
        ModelInstructor datoInstructor = new ModelInstructor(nombre, estado, apellido, fechaNacimiento, salario, puesto, certicado, cliente, rutina);
        datoInstructor.setId(id);
        try{
            instructorDao.modificarInstructor(datoInstructor);
            conexionView.mostrarMensaje("Datos del instructor modificados correctamente");
        }catch (SQLException e){
            conexionView.mostrarError("Fallo al modificar datos del instructor" + e.getMessage());
        }
    }

    public void eliminarInstructor(String id){

        try{
            instructorDao.eliminarInstructor(id);
            conexionView.mostrarMensaje("Datos del instructor eliminados");
        }catch (SQLException e){
            conexionView.mostrarError("Fallo al eliminar datos del instructor");
        }
    }

    public void obtenerInstructores(){

        try{
            ArrayList<ModelInstructor> modelInstructores = instructorDao.obtenerInstructor();

            for (ModelInstructor item : modelInstructores)
                conexionView.mostrarMensaje
                        ("id: " + item.getId() +
                                " | nombre: " + item.getNombre() +
                                " | estado: " + item.getEstado() +
                                " | apellido: " + item.getApellido() +
                                " | fechaNacimiento: " + item.getFechaNacimiento() +
                                " | salario: " + item.getSalario() +
                                " | puesto: " + item.getPuesto()+
                                " | cliente: " + item.getCliente()+
                                " | rutina: " + item.getRutina());
        }catch (SQLException e){
            conexionView.mostrarError("Hubo un error al mostrar el instructor" + e.getMessage());
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

    public ModelCliente obtenerByCliente(String cliente_id) {
        try {
            return clienteDao.obtenerByCliente(cliente_id);
        } catch (SQLException e) {
            conexionView.mostrarError("Error al buscar la rutina: " + e.getMessage());
            return null;
        }
    }
}
