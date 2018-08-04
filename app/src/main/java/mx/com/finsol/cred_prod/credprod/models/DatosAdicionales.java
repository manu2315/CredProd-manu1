package mx.com.finsol.cred_prod.credprod.models;

import java.util.List;

public class DatosAdicionales {

    public List<String> diasDeLocalizacion;
    public String horaInicio;
    public String horaFin;
    public boolean creditoGrupal;
    public boolean campaña;
    public String estatus;

    public List<String> getDiasDeLocalizacion() {
        return diasDeLocalizacion;
    }

    public void setDiasDeLocalizacion(List<String> diasDeLocalizacion) {
        this.diasDeLocalizacion = diasDeLocalizacion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public boolean isCreditoGrupal() {
        return creditoGrupal;
    }

    public void setCreditoGrupal(boolean creditoGrupal) {
        this.creditoGrupal = creditoGrupal;
    }

    public boolean isCampaña() {
        return campaña;
    }

    public void setCampaña(boolean campaña) {
        this.campaña = campaña;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "DatosAdicionales{" +
                "diasDeLocalizacion=" + diasDeLocalizacion +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", creditoGrupal=" + creditoGrupal +
                ", campaña=" + campaña +
                ", estatus='" + estatus + '\'' +
                '}';
    }
}
