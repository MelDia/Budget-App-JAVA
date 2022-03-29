package domain;

public class Ingreso {
    
    private int id_ingresos;
    private String descripcion;
    private double valor;

    public Ingreso() {
    }

    public Ingreso(int id_ingresos) {
        this.id_ingresos = id_ingresos;
    }

    public Ingreso( String descripcion, double valor) {
        
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public int getId_ingresos() {
        return id_ingresos;
    }

    public void setId_ingresos(int id_ingresos) {
        this.id_ingresos = id_ingresos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Ingreso{" 
                + "id_ingresos: " + id_ingresos 
                + ", descripcion: " + descripcion 
                + ", valor: " + valor + '}';
    }
    
    
    
}
