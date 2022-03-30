package web;

import datos.EgresoDAO;
import domain.Egreso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EgresoControl")
public class EgresoControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "deleteEg": {
                    try {
                        this.deleteEg(request, response);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "agregarEg": {
                    try {
                        this.agregarEg(request, response);
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
        List<Egreso> egresos = new EgresoDAO().listaEgreso();
        System.out.println("Egresos: " + egresos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("egresos", egresos);
        sesion.setAttribute("EXPENSES", egresos.size());
        sesion.setAttribute("totalBalanceEg", this.calcularTotalEg(egresos));
        response.sendRedirect("index.jsp");
    }

    private double calcularTotalEg(List<Egreso> egresos) {
        double totalBalanceEg = 0;
        for (Egreso egreso : egresos) {
            totalBalanceEg += egreso.getValor();
        }
        return totalBalanceEg;
    }

    private void agregarEg(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String descripcion = request.getParameter("descripcion");
        double valor = 0;
        String valorString = request.getParameter("valor");
        if (valorString != null && !"".equals(valorString)) {
            valor = Double.parseDouble(valorString);
        }

        Egreso egreso = new Egreso(descripcion, valor);
        int modificacion = new EgresoDAO().agregarEgreso(egreso);
        System.out.println("modificacion = " + modificacion);
        this.defaultAction(request, response);
    }

    private void deleteEg(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id_egresos = Integer.parseInt(request.getParameter("id_egresos"));
        Egreso egreso = new Egreso(id_egresos);
        int modificacion = new EgresoDAO().eliminarEgreso(egreso);
        System.out.println("modificacion = " + modificacion);
        this.defaultAction(request, response);
    }

}
