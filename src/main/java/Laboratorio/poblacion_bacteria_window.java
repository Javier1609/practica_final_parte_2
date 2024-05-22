package Laboratorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class poblacion_bacteria_window extends JFrame {
    private JTextField nombreExperimentoField, biologoField, fechaInicioField, fechaFinField, temperaturaField, numBacteriasField, humedadField, cantidadComidaField;
    private JButton algoritmoComida1Button, algoritmoComida2Button, algoritmoComida3Button;
    private JButton nuevoProyectoButton, abrirProyectoButton, editarProyectoButton;
    private JTextArea anotacionesArea;
    private Manejo_experimento manejoExperimento;
    private experimento experimentoActual;
    private JLabel algoritmoComidaLabel;

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
        fechaInicioField = new JTextField(20);
        fechaFinField = new JTextField(20);
        temperaturaField = new JTextField(20);
        numBacteriasField = new JTextField(20);
        humedadField = new JTextField(20);
        cantidadComidaField = new JTextField(20);

        panel.add(new JLabel("Nombre del experimento:"));
        panel.add(nombreExperimentoField);
        panel.add(new JLabel("Nombre del biólogo:"));
        panel.add(biologoField);
        panel.add(new JLabel("Fecha de inicio del proyecto:"));
        panel.add(fechaInicioField);
        panel.add(new JLabel("Fecha de fin del proyecto:"));
        panel.add(fechaFinField);
        panel.add(new JLabel("Temperatura de las bacterias:"));
        panel.add(temperaturaField);
        panel.add(new JLabel("Número de bacterias:"));
        panel.add(numBacteriasField);
        panel.add(new JLabel("Humedad:"));
        panel.add(humedadField);
        panel.add(new JLabel("Cantidad de comida:"));
        panel.add(cantidadComidaField);

        algoritmoComida1Button = new JButton("Incremento-Decremento");
        algoritmoComida2Button = new JButton("Decremento-Incremento");
        algoritmoComida3Button = new JButton("Constante");

        panel.add(algoritmoComida1Button);
        panel.add(algoritmoComida2Button);
        panel.add(algoritmoComida3Button);

        JButton ordenarAlfabeticoButton = new JButton("Ordenar Alfabéticamente");
        JButton ordenarCronologicoButton = new JButton("Ordenar Cronológicamente");

        panel.add(ordenarAlfabeticoButton);
        panel.add(ordenarCronologicoButton);

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
                if (experimentoActual != null) {
                    Comida comida = experimentoActual.getComida();
                    if (comida != null) {
                        comida.setTipoPatron(Comida.TipoPatron.INCREMENTO_DECREMENTO);
                        algoritmoComidaLabel.setText("Algoritmo de comida: Incremento-Decremento");
                        // Aquí puedes agregar el código para desplegar el menú con las características del algoritmo de comida
                    }
                }
            }
        });

        algoritmoComida2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (experimentoActual != null) {
                    Comida comida = experimentoActual.getComida();
                    if (comida != null) {
                        comida.setTipoPatron(Comida.TipoPatron.DECREMENTO_INCREMENTO);
                        algoritmoComidaLabel.setText("Algoritmo de comida: Decremento-Incremento");
                        // Aquí puedes agregar el código para desplegar el menú con las características del algoritmo de comida
                    }
                }
            }
        });

        algoritmoComida3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (experimentoActual != null) {
                    Comida comida = experimentoActual.getComida();
                    if (comida != null) {
                        comida.setTipoPatron(Comida.TipoPatron.CONSTANTE);
                        algoritmoComidaLabel.setText("Algoritmo de comida: Constante");
                        // Aquí puedes agregar el código para desplegar el menú con las características del algoritmo de comida
                    }
                }
            }
        });

        ordenarAlfabeticoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejoExperimento.ordenarExperimentos(biologoField.getText(), Manejo_experimento.Ordenamiento.ALFABETICO);
                // Aquí puedes agregar el código para actualizar la interfaz de usuario con los experimentos ordenados
            }
        });

        ordenarCronologicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejoExperimento.ordenarExperimentos(biologoField.getText(), Manejo_experimento.Ordenamiento.CRONOLOGICO);
                // Aquí puedes agregar el código para actualizar la interfaz de usuario con los experimentos ordenados
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