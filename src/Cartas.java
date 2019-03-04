public class Cartas {

    @Override
    public String toString() {
        return "nombre=" + nombre + " " +
                "tipo=" + tipo + "  "+
                "cantidad=" + cantidad + "\n";
    }

    String nombre;
    String tipo;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    int cantidad = 1;








    public Cartas(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;



    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
