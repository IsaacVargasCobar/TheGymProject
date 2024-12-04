package da;

import models.ModelCliente;
import models.ModelRutina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDao {

    private Connection connection;


    public ClienteDao (Connection connection){
        this.connection = connection;

    }

    public void agregarCliente(ModelCliente cliente) throws SQLException {
        String query = "INSERT INTO `208320548_Cliente` ( `nombre`, `apellido`, `email` , `fechaNacimiento`, `estatura` , `sexo`, `altoRiesgo`, `rutina_id`)  values (?,?,?,?,?,?,?,?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1,cliente.getNombre());
            stmt.setString(2,cliente.getApellido());
            stmt.setString(3,cliente.getEmail());
            stmt.setString(4,cliente.getFechaNacimiento());
            stmt.setString(5,cliente.getEstatura());
            stmt.setString(6,cliente.getSexo());
            stmt.setString(7,cliente.getAltoRiesgo());
            stmt.setString(8, cliente.getRutina().getId());
            stmt.executeUpdate();
        }

    }

    public void modificarCliente(ModelCliente cliente) throws SQLException{
        String query = "UPDATE `208320548_Cliente` SET  `nombre`=? , `apellido`=? , `email`=? , `fechaNacimiento`=? , `estatura`=? , `sexo`=? , `altoRiesgo`=? , `rutina_id`=? WHERE `cliente_id`=?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1,cliente.getNombre());
            stmt.setString(2,cliente.getApellido());
            stmt.setString(3,cliente.getEmail());
            stmt.setString(4,cliente.getFechaNacimiento());
            stmt.setString(5,cliente.getEstatura());
            stmt.setString(6,cliente.getSexo());
            stmt.setString(7,cliente.getAltoRiesgo());
            stmt.setString(8, cliente.getRutina().getId());
            stmt.setString(9,cliente.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarCliente(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Cliente` WHERE `cliente_id` = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1,id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<ModelCliente> obtenerCliente() throws SQLException{
        ArrayList<ModelCliente> modelClientes = new ArrayList<>();
      String query = "SELECT  `cliente_id`, `nombre` , `apellido` , `email` , `fechaNacimiento` , `estatura` , `sexo` , `altoRiesgo` , `rutina_id` FROM `208320548_Cliente`";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            RutinaDao rutinaDao = new RutinaDao(connection);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ModelCliente cliente = new ModelCliente(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("fechaNacimiento"),
                        rs.getString("estatura"),
                        rs.getString("sexo"),
                        rs.getString("altoRiesgo"),
                       rutinaDao.obtenerByRutina(rs.getString("rutina_id")));

                cliente.setId(rs.getString("cliente_id"));
                modelClientes.add(cliente);
            }
            return modelClientes;
        }

    }
    public ModelCliente obtenerByCliente(String cliente_id) throws SQLException{

        String query = "SELECT  `cliente_id`, `nombre` , `apellido` , `email` , `fechaNacimiento` , `estatura` , `sexo` , `altoRiesgo` , `rutina_id` FROM `208320548_Cliente` WHERE `cliente_id` = " + cliente_id;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            RutinaDao rutinaDao = new RutinaDao(connection);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                ModelCliente cliente = new ModelCliente(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("fechaNacimiento"),
                        rs.getString("estatura"),
                        rs.getString("sexo"),
                        rs.getString("altoRiesgo"),
                        rutinaDao.obtenerByRutina(rs.getString("rutina_id")));

                cliente.setId(rs.getString("cliente_id"));

                return cliente;
            }


            return null;
        }

    }


}








