package da;


import models.ModelRutina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RutinaDao {
    private Connection connection;

    public RutinaDao (Connection connection) {
        this.connection = connection;
    }

    public void agregarRutina(ModelRutina rutina) throws SQLException {
        String query = "INSERT INTO `208320548_Rutina` ( `ejercicio`, `zonaMuscular`, `sets` , `repeticiones`)  values (?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, rutina.getEjercicio());
            stmt.setString(2, rutina.getZonaMuscular());
            stmt.setString(3, rutina.getSets());
            stmt.setString(4, rutina.getRepeticiones());

            stmt.executeUpdate();
        }

    }

    public void modificarRutina(ModelRutina rutina) throws SQLException {
        String query = "UPDATE `208320548_Rutina` SET  `ejercicio`=? , `zonaMuscular`=? , `sets`=? , `repeticiones`=?  WHERE `rutina_id`=?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, rutina.getEjercicio());
            stmt.setString(2, rutina.getZonaMuscular());
            stmt.setString(3, rutina.getSets());
            stmt.setString(4, rutina.getRepeticiones());
            stmt.setString(5, rutina.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarRutina(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Rutina` WHERE `rutina_id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }


    public ArrayList<ModelRutina> obtenerRutina() throws SQLException{
        ArrayList<ModelRutina> modelRutina = new ArrayList<>();
        String query = "SELECT `rutina_id`,`ejercicio`,`zonaMuscular`,`sets`, `repeticiones`  FROM `208320548_Rutina`";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ModelRutina rutina = new ModelRutina(
                        rs.getString("ejercicio"),
                        rs.getString("zonaMuscular"),
                        rs.getString("sets"),
                        rs.getString("repeticiones"));

                rutina.setId(rs.getString("rutina_id"));
                modelRutina.add(rutina);
            }
            return modelRutina ;
        }

    }
    public ModelRutina obtenerByRutina(String rutina_id) throws SQLException{

        String query = "SELECT  `rutina_id`, `ejercicio`, `zonaMuscular` , `sets` , `repeticiones` FROM `208320548_Rutina` WHERE `rutina_id` = " + rutina_id;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                ModelRutina rutina = new ModelRutina(
                        rs.getString("ejercicio"),
                        rs.getString("zonaMuscular"),
                        rs.getString("sets"),
                        rs.getString("repeticiones"));

                rutina.setId(rs.getString("rutina_id"));

                return rutina;
            }


            return null;
        }

    }

}

