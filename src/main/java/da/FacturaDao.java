package da;

import models.ModelFactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacturaDao {
    private Connection connection;


    public FacturaDao (Connection connection){
        this.connection = connection;

    }

    public void agregarFactura(ModelFactura factura) throws SQLException {
        String query = "INSERT INTO `208320548_Factura` ( `cliente_id`, `monto`, `descripcion` , `emisor`)  values (?,?,?,?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, factura.getCliente().getId());
            stmt.setString(2, String.valueOf(factura.getMonto()));
            stmt.setString(3,factura.getDescripcion());
            stmt.setString(4,factura.getEmisor());
            stmt.executeUpdate();
        }

    }

    public void modificarFactura(ModelFactura factura) throws SQLException{
        String query = "UPDATE `208320548_Factura` SET  `cliente_id`=? , `monto`=? , `descripcion`=? , `emisor`=?  WHERE `id`=?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, factura.getCliente().getId());
            stmt.setString(2, String.valueOf(factura.getMonto()));
            stmt.setString(3,factura.getDescripcion());
            stmt.setString(4,factura.getEmisor());
            stmt.setString(5,factura.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarFactura(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Factura` WHERE `id` = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1,id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<ModelFactura> obtenerFactura() throws SQLException{
        ArrayList<ModelFactura> modelFacturas = new ArrayList<>();
        String query = "SELECT  `id`,`cliente_id`, `monto` , `descripcion` , `emisor`  FROM `208320548_Factura`";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            ClienteDao clienteDao = new ClienteDao(connection);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ModelFactura factura = new ModelFactura(

                        clienteDao.obtenerByCliente(rs.getString("cliente_id")),
                        rs.getDouble("monto"),
                        rs.getString("descripcion"),
                        rs.getString("emisor"));

                factura.setId(rs.getString("id"));
                modelFacturas.add(factura);
            }
            return modelFacturas;
        }

    }

}

