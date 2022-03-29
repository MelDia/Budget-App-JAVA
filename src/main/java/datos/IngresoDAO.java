package datos;

import domain.Ingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngresoDAO {
    private static final String SQL_SELECT = "SELECT id_ingresos, descripcion, valor FROM ingresos";
    private static final String SQL_INSERT = "INSERT INTO ingresos(descripcion, valor) VALUES(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM ingresos WHERE id_ingresos = ?";
    
    public List<Ingreso> listaIngreso() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ingreso ingreso = null;
        List<Ingreso> ingresos = new ArrayList<Ingreso>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_ingresos = rs.getInt("id_ingresos");
                String descripcion = rs.getString("descripcion");
                double valor = rs.getDouble("valor");
                ingreso = new Ingreso();
                ingreso.setId_ingresos(id_ingresos);
                ingreso.setDescripcion(descripcion);
                ingreso.setValor(valor);
                ingresos.add(ingreso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ingresos;
    }
    
    public int agregarIngreso(Ingreso ingreso) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ingreso.getDescripcion());
            stmt.setDouble(2, ingreso.getValor());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int eliminarIngreso(Ingreso ingreso) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);            
            stmt.setInt(1, ingreso.getId_ingresos());

            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
}
