package Laboratorio;

import java.util.*;

public class Manejo_experimento {
    private Map<String, List<experimento>> experimentosPorBiologo;
    private List<poblacion_bacteria> poblaciones;
    private experimento experimentoActual;

    public enum Ordenamiento {
        ALFABETICO,
        CRONOLOGICO,
        // Agrega aquí otros tipos de ordenamiento si los necesitas
    }

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

    public void deleteExperimento(String username, String experimentName) {
        List<experimento> experimentos = experimentosPorBiologo.get(username);
        if (experimentos != null) {
            experimentos.removeIf(experimento -> experimento.getNombre().equals(experimentName));
        }
    }

    public experimento getExperimento(String username, String experimentName) {
        List<experimento> experimentos = experimentosPorBiologo.get(username);
        if (experimentos != null) {
            for (experimento experiment : experimentos) {
                if (experiment.getNombre().equals(experimentName)) {
                    return experiment;
                }
            }
        }
        return null;
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

    public void ordenarExperimentos(String username, Ordenamiento ordenamiento) {
        List<experimento> experimentos = experimentosPorBiologo.get(username);
        if (experimentos != null) {
            switch (ordenamiento) {
                case ALFABETICO:
                    Collections.sort(experimentos, Comparator.comparing(experimento::getNombre));
                    break;
                case CRONOLOGICO:
                    Collections.sort(experimentos, Comparator.comparing(experimento::getFechaInicio));
                    break;
                // Agrega aquí otros casos para otros tipos de ordenamiento si los necesitas
            }
        }
    }

    public experimento getExperimentoActual() {
        return this.experimentoActual;
    }
}