package com.example.laboratorio03_04.Actividades.Clases;

public class Presentacion {
    String metodosPresentacion;
    String textoPresentacion;

    public Presentacion() {
    }

    public Presentacion(String metodosPresentacion, String textoPresentacion) {
        this.metodosPresentacion = metodosPresentacion;
        this.textoPresentacion = textoPresentacion;
    }

    public String getMetodosPresentacion() {
        return metodosPresentacion;
    }

    public void setMetodosPresentacion(String metodosPresentacion) {
        this.metodosPresentacion = metodosPresentacion;
    }

    public String getTextoPresentacion() {
        return textoPresentacion;
    }

    public void setTextoPresentacion(String textoPresentacion) {
        this.textoPresentacion = textoPresentacion;
    }
}
