package da;



import models.ModelGimnasio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GimnasioDao {

    private Connection connection;


    public GimnasioDao (Connection connection){
        this.connection = connection;

    }

    public void agregarGimnasio(ModelGimnasio gimnasio) throws SQLException {
        String query = "INSERT INTO `208320548_Gimnasio` ( `telefono`, `email`, `sede_id`)  values (?,?,?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, gimnasio.getTelefono());
            stmt.setString(2, gimnasio.getEmail());
            stmt.setString(3, gimnasio.getSede().getId());
            stmt.executeUpdate();
        }

    }

    public void modificarGimnasio(ModelGimnasio gimnasio) throws SQLException{
        String query = "UPDATE `208320548_Gimnasio` SET  `telefono`=? , `email`=? , `sede_id`=?  WHERE `id`=?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, gimnasio.getTelefono());
            stmt.setString(2, gimnasio.getEmail());
            stmt.setString(3, gimnasio.getSede().getId());
            stmt.setString(4,gimnasio.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarGimnasio(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Gimnasio` WHERE `id` = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1,id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<ModelGimnasio> obtenerGimnasio() throws SQLException{
        ArrayList<ModelGimnasio> modelGimnasio = new ArrayList<>();
        String query = "SELECT `id` , `telefono`, `email` , `sede_id`  FROM `208320548_Gimnasio`";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            SedeDao sedeDao = new SedeDao(connection);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ModelGimnasio gimnasio = new ModelGimnasio(

                        rs.getString("telefono"),
                        rs.getString("email"),
                        sedeDao.obtenerBySede(rs.getString("sede_id")));

                gimnasio.setId(rs.getString("id"));
                modelGimnasio.add(gimnasio);
            }
            return modelGimnasio;
        }

    }
}
