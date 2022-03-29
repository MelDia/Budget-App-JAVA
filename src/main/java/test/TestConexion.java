package test;

import datos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) throws SQLException {
        Connection conn = Conexion.getConnection();
        
        if(conn != null){
                         System.out.println ("Prueba: se conecto a base de datos!");
        }else{
                         System.out.println ("Prueba: no se conecto ");
        }

    }
}
