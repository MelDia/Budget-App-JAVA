package web;

import datos.IngresoDAO;
import domain.Ingreso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/IngresoControl")
public class IngresoControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "deleteIng": {
                    try {
                        this.deleteIng(request, response);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                break;

                default: {
                    try {
                        this.defaultAction(request, response);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
            }
        } else {
            try {
                this.defaultAction(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "agregarIng": {
                    try {
                        this.agregarIng(request, response);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                break;

                default: {
                    try {
                        this.defaultAction(request, response);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
            }
        } else {
            try {
                this.defaultAction(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    private void defaultAction(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        List<Ingreso> ingresos = new IngresoDAO().listaIngreso();
        System.out.println("Ingresos:" + ingresos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("ingresos", ingresos);
        sesion.setAttribute("INCOME", ingresos.size());
        sesion.setAttribute("totalBalance", this.calcularTotalIng(ingresos));
        response.sendRedirect("index.jsp");
    }

    private double calcularTotalIng(List<Ingreso> ingresos) {
        double totalBalance = 0;
        for (Ingreso ingreso : ingresos) {
            totalBalance += ingreso.getValor();
        }
        return totalBalance;
    }

    private void deleteIng(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id_ingresos = Integer.parseInt(request.getParameter("id_ingresos"));
        Ingreso ingreso = new Ingreso(id_ingresos);
        int modificacion = new IngresoDAO().eliminarIngreso(ingreso);
        System.out.println("modificacion = " + modificacion);
        this.defaultAction(request, response);
    }

    private void agregarIng(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String descripcion = request.getParameter("descripcion");
        double valor = 0;
        String valorString = request.getParameter("valor");
        if (valorString != null && !"".equals(valorString)) {
            valor = Double.parseDouble(valorString);
        }

        Ingreso ingreso = new Ingreso(descripcion, valor);
        int modificacion = new IngresoDAO().agregarIngreso(ingreso);
        System.out.println("modificacion = " + modificacion);
        this.defaultAction(request, response);
    }

}
