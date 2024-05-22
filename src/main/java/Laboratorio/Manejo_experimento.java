package Laboratorio;

import java.util.*;

public class Manejo_experimento {
    private Map<String, List<experimento>> experimentosPorBiologo;
    private List<poblacion_bacteria> poblaciones;
    private experimento experimentoActual;

    public Manejo_experimento() {
        this.experimentosPorBiologo = new HashMap<>();
        this.poblaciones = new ArrayList<>();
        this.experimentoActual = null;
    }

    public void addExperimento(String username, experimento experimento) {
        if (!experimentosPorBiologo.containsKey(username)) {
            experimentosPorBiologo.put(username, new ArrayList<>());
        }
        experimentosPorBiologo.get(username).add(experimento);
        this.experimentoActual = experimento;
    }

    public List<experimento> getExperimentos(String username) {
        return experimentosPorBiologo.get(username);
    }

    public void setPatronComida(String username, experimento experimento, Comida comida) {
        experimento.setComida(comida);
    }

    public void ejecutarExperimento(String username, experimento experimento) {
        Comida comida = experimento.getComida();
        for (int dia = 0; dia < experimento.getDias(); dia++) {
            double cantidadComida = comida.dispensarComida(dia);
            // Aquí puedes agregar el código para dispensar la comida a las bacterias
        }
    }

    public void addPoblacion(poblacion_bacteria poblacion) {
        this.poblaciones.add(poblacion);
    }

    public void ordenarPorFechaInicio() {
        Collections.sort(poblaciones);
    }

    public void ordenarPorNombre() {
        Collections.sort(poblaciones, Comparator.comparing(poblacion_bacteria::getNombre));
    }

    public void ordenarPorNumeroBacterias() {
        Collections.sort(poblaciones, Comparator.comparingInt(p -> p.getBacterias().size()));
    }


    public experimento getExperimentoActual() {
        return this.experimentoActual;
    }
}