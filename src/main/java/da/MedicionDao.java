package da;



import models.ModelMedicion;

import java.sql.*;
import java.util.ArrayList;

public class MedicionDao {

    private Connection connection;

    public  MedicionDao(Connection connection){
        this.connection = connection;

    }

    public void agregarMedicion(ModelMedicion medicion) throws SQLException {
        String query = "INSERT INTO `208320548_Medicion` (`fecha`, `peso`, `grasa`, `musculo`, `edadMetabolica`, `grasaVisceral`, `cliente_id`) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, medicion.getFecha());
            stmt.setDouble(2, medicion.getPeso());
            stmt.setDouble(3, medicion.getGrasa());
            stmt.setDouble(4, medicion.getMusculo());
            stmt.setDouble(5, medicion.getEdadMetabolica());
            stmt.setDouble(6, medicion.getGrasaVisceral());
            stmt.setString(7, medicion.getCliente().getId());
            stmt.executeUpdate();
        }
    }


    public void modificarInstructor(ModelMedicion medicion) throws SQLException {
        String query = "UPDATE `208320548_Medicion` SET  `fecha`=? , `peso`=? , `grasa`=? , `musculo`=? , `edadMetabolica`=? , `grasaVisceral`=?  , `cliente_id`=? WHERE `id`=?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, medicion.getFecha());
            stmt.setDouble(2, medicion.getPeso());
            stmt.setDouble(3, medicion.getGrasa());
            stmt.setDouble(4, medicion.getMusculo());
            stmt.setDouble(5, medicion.getEdadMetabolica());
            stmt.setDouble(6, medicion.getGrasaVisceral());
            stmt.setString(7, String.valueOf(medicion.getCliente()));
            stmt.setString(8, medicion.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarMedicion(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Medicion` WHERE `id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }


    public ArrayList<ModelMedicion> obtenerMedicion() throws SQLException {
        ArrayList<ModelMedicion> modelMediciones = new ArrayList<>();
        String query = "SELECT `id`, `fecha`, `peso`, `grasa`, `musculo`, `edadMetabolica`, `grasaVisceral`, `cliente_id` FROM `208320548_Medicion`";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            ClienteDao clienteDao = new ClienteDao(connection);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {


                ModelMedicion medicion = new ModelMedicion(
                        rs.getString("fecha"),
                        rs.getDouble("peso"),
                        rs.getDouble("grasa"),
                        rs.getDouble("musculo"),
                        rs.getDouble("edadMetabolica"),
                        rs.getDouble("grasaVisceral"),

                        clienteDao.obtenerByCliente( rs.getString("cliente_id")));

                medicion.setId(rs.getString("id"));
                modelMediciones.add(medicion);
            }
        }
        return modelMediciones;
    }

}
