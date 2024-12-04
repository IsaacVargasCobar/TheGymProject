package da;



import models.ModelInstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorDao {
    private Connection connection;

    public InstructorDao(Connection connection) {
        this.connection = connection;
    }

    public void agregarInstructor(ModelInstructor instructor) throws SQLException {
        String query = "INSERT INTO `208320548_Instructor` ( `nombre`, `estado`, `apellido` , `fechaNacimiento`, `salario` , `puesto`,  `certificado`, `cliente_id`, `rutina_id`)  values (?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, instructor.getNombre());
            stmt.setString(2, instructor.getEstado());
            stmt.setString(3, instructor.getApellido());
            stmt.setString(4, instructor.getFechaNacimiento());
            stmt.setString(5, instructor.getSalario());
            stmt.setString(6, instructor.getPuesto());
            stmt.setString(7, instructor.getCertificado());
            stmt.setString(8, instructor.getCliente().getId());
            stmt.setString(9, instructor.getRutina().getId());
            stmt.executeUpdate();
        }

    }

    public void modificarInstructor(ModelInstructor instructor) throws SQLException {
        String query = "UPDATE `208320548_Instructor` SET  `nombre`=? , `estado`=? , `apellido`=? , `fechaNacimiento`=? , `salario`=? , `puesto`=? , `certificado`=? , `cliente_id`=? , `rutina_id`=? WHERE `id`=?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, instructor.getNombre());
            stmt.setString(2, instructor.getEstado());
            stmt.setString(3, instructor.getApellido());
            stmt.setString(4, instructor.getFechaNacimiento());
            stmt.setString(5, instructor.getSalario());
            stmt.setString(6, instructor.getPuesto());
            stmt.setString(7, instructor.getCertificado());
            stmt.setString(8, instructor.getCliente().getId());
            stmt.setString(9, instructor.getRutina().getId());
            stmt.setString(10, instructor.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarInstructor(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Instructor` WHERE `id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }


public ArrayList<ModelInstructor> obtenerInstructor() throws SQLException {
    ArrayList<ModelInstructor> modelInstrutores = new ArrayList<>();
    String query = "SELECT `id`, `nombre`, `estado`, `apellido`, `fechaNacimiento`, `salario`, `puesto`, `certificado`, `cliente_id`, `rutina_id` FROM `208320548_Instructor`";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {

        ClienteDao clienteDao = new ClienteDao(connection);
        RutinaDao rutinaDao = new RutinaDao(connection);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {


            ModelInstructor instructor = new ModelInstructor(
                    rs.getString("nombre"),
                    rs.getString("estado"),
                    rs.getString("apellido"),
                    rs.getString("fechaNacimiento"),
                    rs.getString("salario"),
                    rs.getString("puesto"),
                    rs.getString("certificado"),
                    clienteDao.obtenerByCliente( rs.getString("cliente_id")),
                    rutinaDao.obtenerByRutina(rs.getString("rutina_id"))
            );

            instructor.setId(rs.getString("id"));
            modelInstrutores.add(instructor);
        }
    }
    return modelInstrutores;
}

}

