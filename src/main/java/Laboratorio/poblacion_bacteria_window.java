package Laboratorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class poblacion_bacteria_window extends JFrame {
    private JTextField nombreExperimentoField, biologoField;
    private JButton algoritmoComida1Button, algoritmoComida2Button, algoritmoComida3Button;
    private JButton nuevoProyectoButton, abrirProyectoButton, editarProyectoButton;
    private JTextArea anotacionesArea;
    private Manejo_experimento manejoExperimento;
    private experimento experimentoActual;

    public poblacion_bacteria_window(Manejo_experimento manejoExperimento) {
        this.manejoExperimento = manejoExperimento;
        this.experimentoActual = manejoExperimento.getExperimentoActual();

        setTitle("Poblaciones de Bacterias");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        nombreExperimentoField = new JTextField(20);
        biologoField = new JTextField(20);
        panel.add(new JLabel("Nombre del experimento:"));
        panel.add(nombreExperimentoField);
        panel.add(new JLabel("Nombre del biólogo:"));
        panel.add(biologoField);

        algoritmoComida1Button = new JButton("Algoritmo de Comida 1");
        algoritmoComida2Button = new JButton("Algoritmo de Comida 2");
        algoritmoComida3Button = new JButton("Algoritmo de Comida 3");

        panel.add(algoritmoComida1Button);
        panel.add(algoritmoComida2Button);
        panel.add(algoritmoComida3Button);

        nuevoProyectoButton = new JButton("Nuevo Proyecto");
        abrirProyectoButton = new JButton("Abrir Proyecto");
        editarProyectoButton = new JButton("Editar Proyecto");

        panel.add(nuevoProyectoButton);
        panel.add(abrirProyectoButton);
        panel.add(editarProyectoButton);

        anotacionesArea = new JTextArea(5, 20);
        panel.add(new JLabel("Anotaciones:"));
        panel.add(new JScrollPane(anotacionesArea));

        add(panel, BorderLayout.CENTER);

        algoritmoComida1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comida comida = experimentoActual.getComida();
                comida.setTipoPatron(Comida.TipoPatron.INCREMENTO_DECREMENTO);
            }
        });

        algoritmoComida2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comida comida = experimentoActual.getComida();
                comida.setTipoPatron(Comida.TipoPatron.DECREMENTO_INCREMENTO);
            }
        });

        algoritmoComida3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comida comida = experimentoActual.getComida();
                comida.setTipoPatron(Comida.TipoPatron.CONSTANTE);
            }
        });

        nuevoProyectoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreProyecto = nombreExperimentoField.getText();
                String nombreBiologo = biologoField.getText();
                try (PrintWriter out = new PrintWriter(new FileWriter(nombreProyecto + ".txt"))) {
                    out.println(nombreBiologo);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        abrirProyectoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try (BufferedReader in = new BufferedReader(new FileReader(selectedFile))) {
                        String nombreBiologo = in.readLine();
                        if (biologoField.getText().equals(nombreBiologo)) {
                            // Aquí puedes agregar el código para cargar el proyecto desde el archivo
                        } else {
                            JOptionPane.showMessageDialog(null, "No tienes permiso para abrir este proyecto.");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        editarProyectoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoNombreProyecto = JOptionPane.showInputDialog("Introduce el nuevo nombre del proyecto:");
                if (nuevoNombreProyecto != null) {
                    nombreExperimentoField.setText(nuevoNombreProyecto);
                }
            }
        });

        setVisible(true);
    }
}
