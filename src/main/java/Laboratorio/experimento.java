package Laboratorio;

import java.util.Date;

public class experimento {
    private String nombre;
    private Date fechaInicio;
    private int dias;
    private double temperatura;
    private Comida comida;
    private String descripcion;

    public experimento(String nombre, int dias, double temperatura) throws Exception {
        if (dias < 0) {
            throw new Exception("El número de días no puede ser negativo");
        }
        this.nombre = nombre;
        this.dias = dias;
        this.temperatura = temperatura;
        this.fechaInicio = new Date(); // Asume que el experimento comienza ahora
    }

    public experimento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = new Date(); // Asume que el experimento comienza ahora
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDias() {
        return dias;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }
}