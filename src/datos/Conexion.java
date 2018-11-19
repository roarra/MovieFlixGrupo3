package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	Connection connection = null;
	String driverClassName = "com.mysql.jdbc.Driver";
	String driverUrl = "jdbc:mysql://10.90.36.10:3306/proyecto-fila3";
	String user= "root";
	String password ="Luca1111";
	
    public Conexion() {
        try {
       
            connection = DriverManager.getConnection(driverUrl, user, password);
        } catch (SQLException e) {
            System.out.println("Excepcion SQL: " + e.getMessage());
            System.out.println("Estado SQL: " + e.getSQLState());
            System.out.println("Codigo del Error: " + e.getErrorCode());
            System.out.println("ERROR. No se puede conectar con la Bases de Datos: " + e);
            System.exit(-1);
        }
    }
    
    
    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException se) {
            System.out.println("Exception closing Connection: " + se);
        }
    }

}
