package da;

import models.ModelSede;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SedeDao {

    private Connection connection;

    public SedeDao (Connection connection){
        this.connection = connection;

    }


    public void agregarSede(ModelSede sede) throws SQLException {
        String query = "INSERT INTO `208320548_Sede` ( `provincia`, `canton`, `email` , `telefono` , `empleado_id`)  values (?,?,?,?,?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, sede.getProvincia());
            stmt.setString(2, sede.getCanton());
            stmt.setString(3,sede.getEmail());
            stmt.setString(4,sede.getTelefono());
            stmt.setInt(5, sede.getEmpleado_id());
            stmt.executeUpdate();
        }

    }

    public void modificarSede(ModelSede sede) throws SQLException{
        String query = "UPDATE `208320548_Sede` SET  `provincia`=? , `canton`=? , `email`=? , `telefono`=? , `empleado_id`=? WHERE `sede_id`=?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, sede.getProvincia());
            stmt.setString(2, sede.getCanton());
            stmt.setString(3,sede.getEmail());
            stmt.setString(4,sede.getTelefono());
            stmt.setInt(5, sede.getEmpleado_id());
            stmt.setString(6,sede.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarSede(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Sede` WHERE `sede_id` = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1,id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<ModelSede> obtenerSede() throws SQLException{
        ArrayList<ModelSede> modelSedes = new ArrayList<>();
        String query = "SELECT  `sede_id` ,`provincia`, `canton` , `email` , `telefono` , `empleado_id` FROM `208320548_Sede`";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            EmpleadoDao empleadoDao = new EmpleadoDao(connection);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ModelSede sede = new ModelSede(
                        rs.getString("provincia"),
                        rs.getString("canton"),
                        rs.getString("email"),
                        rs.getString("telefono"));

                sede.setId(rs.getString("sede_id"));
                modelSedes.add(sede);
            }
            return modelSedes;
        }

    }

    public ModelSede obtenerBySede(String sede_id) throws SQLException{

        String query = "SELECT `sede_id`, `provincia`, `canton` , `email` , `telefono` , `empleado_id` FROM `208320548_Sede` WHERE `sede_id` = " + sede_id;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            EmpleadoDao empleadoDao = new EmpleadoDao(connection);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                ModelSede sede = new ModelSede(
                        rs.getString("provincia"),
                        rs.getString("canton"),
                        rs.getString("email"),
                        rs.getString("telefono"));


                sede.setId(rs.getString("sede_id"));

                return sede;
            }


            return null;
        }

    }

}
