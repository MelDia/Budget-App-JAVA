package test;

import datos.IngresoDAO;
import domain.Ingreso;
import java.sql.SQLException;

public class AgregarIngreso {

    public static void main(String[] args) throws SQLException {
        IngresoDAO ingDao = new IngresoDAO();
        Ingreso ing = new Ingreso();

        ing.setDescripcion("Salary");
        ing.setValor(200);
        
        ingDao.agregarIngreso(ing);
    }

}
