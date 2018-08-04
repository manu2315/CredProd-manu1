package mx.com.finsol.cred_prod.credprod.models;

public class Telefono {

    public String tipo;
    public String Telefono;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "tipo='" + tipo + '\'' +
                ", Telefono='" + Telefono + '\'' +
                '}';
    }
}
