public class Cartas {

    @Override
    public String toString() {
        return "nombre=" + nombre + " " +
                "tipo=" + tipo + "\n";
    }

    String nombre;
    String tipo;








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
