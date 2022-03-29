package domain;

public class Egreso {
    
    private int id_egresos;
    private String descripcion;
    private double valor;

    public Egreso() {
    }

    public Egreso(int id_egresos) {
        this.id_egresos = id_egresos;
    }

    public Egreso(String descripcion, double valor) {
        
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public int getId_egresos() {
        return id_egresos;
    }

    public void setId_egresos(int id_egresos) {
        this.id_egresos = id_egresos;
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
        return "Egreso{" 
                + "id_egresos: " + id_egresos 
                + ", descripcion: " + descripcion 
                + ", valor: " + valor + '}';
    }
    
    
    
}
