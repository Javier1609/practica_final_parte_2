package Aplication;

import Laboratorio.Manejo_experimento;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Panel panel;
    private Manejo_experimento manejoExperimento;

    public MainFrame() {
        // Crear una instancia de Manejo_experimento
        manejoExperimento = new Manejo_experimento();

        // Crear una instancia de Panel y pasarle la instancia de Manejo_experimento
        panel = new Panel(manejoExperimento);

        // Configurar la ventana
        setTitle("Aplicación de experimentos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

        // Agregar el panel a la ventana
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}