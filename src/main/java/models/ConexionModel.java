package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionModel {
    private static final String URL = "jdbc:mysql://45.88.196.5:3306/u484426513_poo324";
    private static final String USER = "u484426513_poo324";
    private static final String PASSWORD = "iH6D?ZF_7AykMRw" ;

    public static Connection getConnection(){

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);


        }catch(SQLException e){
            System.err.println("Error al conectar:" + e.getMessage());
        }


        return connection;
    }
}

