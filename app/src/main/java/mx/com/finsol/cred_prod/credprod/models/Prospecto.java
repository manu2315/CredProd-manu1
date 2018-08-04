package mx.com.finsol.cred_prod.credprod.models;

public class Prospecto {

    public String uid;
    public String nombre;
    public String apellidoMat;
    public String apellidoPat;
    public String birthdate;
    public String rfc;
    public String genero;
    public String email;
    public Telefono telefono;
    public DatosAdicionales datosAdicionales;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public DatosAdicionales getDatosAdicionales() {
        return datosAdicionales;
    }

    public void setDatosAdicionales(DatosAdicionales datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }

    @Override
    public String toString() {
        return "Prospecto{" +
                "uid='" + uid + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoMat='" + apellidoMat + '\'' +
                ", apellidoPat='" + apellidoPat + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", rfc='" + rfc + '\'' +
                ", genero='" + genero + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", datosAdicionales=" + datosAdicionales +
                '}';
    }
}
