package Laboratorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class biologos {
    private Map<String, List<experimento>> experimentosPorBiologo;

    public biologos() {
        this.experimentosPorBiologo = new HashMap<>();
    }

    public void addExperimento(String username, experimento experimento) {
        if (!experimentosPorBiologo.containsKey(username)) {
            experimentosPorBiologo.put(username, new ArrayList<>());
        }
        experimentosPorBiologo.get(username).add(experimento);
    }

    public List<experimento> getExperimentos(String username) {
        return experimentosPorBiologo.get(username);
    }

    public void setPatronComida(String username, experimento experimento, Comida comida) {
        experimento.setComida(comida);
    }
}