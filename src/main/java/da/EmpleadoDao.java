package da;



import models.ModelEmpleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDao {

    private Connection connection;
    public  EmpleadoDao(Connection connection){
        this.connection = connection;
        }


        public ModelEmpleado obtenerByEmpleado(String empleado_id) throws SQLException {

        String query = "SELECT `empleado_id`  ,`nombre` , `estado` , `apellido` , `fechaNacimiento` , `salario` , `puesto` FROM `208320548_Empleado` WHERE `empleado_id` = " + empleado_id;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            RutinaDao rutinaDao = new RutinaDao(connection);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                ModelEmpleado empleado = new ModelEmpleado(
                        rs.getString("nombre"),
                        rs.getString("estado"),
                        rs.getString("apellido"),
                        rs.getString("fechaNacimiento"),
                        rs.getString("salario"),
                        rs.getString("puesto")
                        ) {
                };

                empleado.setId(rs.getString("empleado_id"));

                return empleado;
            }


            return null;
        }

    }
}
