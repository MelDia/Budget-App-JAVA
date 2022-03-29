package datos;

import domain.Egreso;
import domain.Ingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EgresoDAO {
    private static final String SQL_SELECT = "SELECT id_egresos, descripcion, valor FROM egresos";
    private static final String SQL_INSERT = "INSERT INTO egresos(descripcion, valor) VALUES(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM egresos WHERE id_egresos = ?";
    
    public List<Egreso> listaEgreso() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Egreso egreso = null;
        List<Egreso> egresos = new ArrayList<Egreso>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_egresos = rs.getInt("id_egresos");
                String descripcion = rs.getString("descripcion");
                double valor = rs.getDouble("valor");
                egreso = new Egreso();
                egreso.setId_egresos(id_egresos);
                egreso.setDescripcion(descripcion);
                egreso.setValor(valor);
                egresos.add(egreso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return egresos;
    }
    
    public int agregarEgreso(Egreso egreso) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, egreso.getDescripcion());
            stmt.setDouble(2, egreso.getValor());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int eliminarEgreso(Egreso egreso) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);            
            stmt.setInt(1, egreso.getId_egresos());

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
