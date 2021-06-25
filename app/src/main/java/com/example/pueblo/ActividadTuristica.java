package com.example.pueblo;

import java.io.Serializable;

public class ActividadTuristica implements Serializable {
    String informacion;
    String actividad;
    String fotosahagun;

    public ActividadTuristica(String informacion, String actividad, String fotosahagun) {
        this.informacion = informacion;
        this.actividad = actividad;
        this.fotosahagun = fotosahagun;
    }



    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFotosahagun() {
        return fotosahagun;
    }

    public void setFotosahagun(String fotosahagun) {
        this.fotosahagun = fotosahagun;
    }
}
