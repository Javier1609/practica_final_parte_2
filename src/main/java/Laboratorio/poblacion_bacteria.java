package Laboratorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class poblacion_bacteria implements Comparable<poblacion_bacteria> {
    private String nombre;
    private LocalDate fechaInicio;
    private List<Bacteria> bacterias;

    public poblacion_bacteria(String nombre, LocalDate fechaInicio) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.bacterias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public void addBacteria(Bacteria bacteria) {
        this.bacterias.add(bacteria);
    }

    @Override
    public int compareTo(poblacion_bacteria o) {
        return this.fechaInicio.compareTo(o.fechaInicio);
    }
}