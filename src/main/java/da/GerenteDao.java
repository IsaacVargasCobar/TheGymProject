package da;


import models.ModelGerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GerenteDao {

    private Connection connection;

    public GerenteDao(Connection connection) {
        this.connection = connection;
    }

    public void agregarGerente(ModelGerente gerente) throws SQLException {
        String query = "INSERT INTO `208320548_Gerente` ( `nombre`, `estado`, `apellido` , `fechaNacimiento`, `salario` , `puesto`)  values (?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, gerente.getNombre());
            stmt.setString(2, gerente.getEstado());
            stmt.setString(3, gerente.getApellido());
            stmt.setString(4, gerente.getFechaNacimiento());
            stmt.setString(5, gerente.getSalario());
            stmt.setString(6, gerente.getPuesto());
            stmt.executeUpdate();
        }

    }

    public void modificarGerente(ModelGerente gerente) throws SQLException {
        String query = "UPDATE `208320548_Gerente` SET  `nombre`=? , `estado`=? , `apellido`=? , `fechaNacimiento`=? , `salario`=? , `puesto`=?  WHERE `id`=?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, gerente.getNombre());
            stmt.setString(2, gerente.getEstado());
            stmt.setString(3, gerente.getApellido());
            stmt.setString(4, gerente.getFechaNacimiento());
            stmt.setString(5, gerente.getSalario());
            stmt.setString(6, gerente.getPuesto());
            stmt.setString(7, gerente.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarGerente(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Gerente` WHERE `id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<ModelGerente> obtenerGerente() throws SQLException {
        ArrayList<ModelGerente> modelGerentes = new ArrayList<>();
        String query = "SELECT `id`, `nombre`, `estado`, `apellido`, `fechaNacimiento`, `salario`, `puesto` FROM `208320548_Gerente`";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelGerente gerente = new ModelGerente(
                        rs.getString("nombre"),
                        rs.getString("estado"),
                        rs.getString("apellido"),
                        rs.getString("fechaNacimiento"),
                        rs.getString("salario"),
                        rs.getString("puesto"));

                gerente.setId(rs.getString("id"));
                modelGerentes.add(gerente);
            }
        }
        return modelGerentes;
    }
}


