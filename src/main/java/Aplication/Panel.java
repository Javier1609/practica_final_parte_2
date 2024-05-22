package Aplication;

import Laboratorio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Panel extends JPanel {
    private Manejo_experimento manejoExperimento;
    private Image backgroundImage;

    public Panel(Manejo_experimento manejoExperimento) {
        this.manejoExperimento = manejoExperimento;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear y añadir el JLabel
        JLabel titleLabel = new JLabel("Gestor de Cultivo de bacterias", SwingConstants.CENTER);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Ajusta el tamaño de la fuente aquí
        add(titleLabel, gbc);

        String[] actions = {"Agregar nuevo experimento", "Agregar población de bacterias", "Borrar experimento", "Ver información de la población", "Abrir experimento", "Establecer fondo de pantalla", "Editar experimento"};
        JComboBox<String> actionList = new JComboBox<>(actions);

        // Crear un panel adicional para el desplegable
        JPanel actionPanel = new JPanel();
        actionPanel.add(actionList);

        // Agregar el panel adicional al panel principal
        add(actionPanel, gbc);

        actionList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String selectedAction = (String) actionList.getSelectedItem();

                JFileChooser fileChooser;
                int userSelection;

                switch (selectedAction) {
                    case "Agregar nuevo experimento":
                        String biologistName = JOptionPane.showInputDialog(null, "Ingrese el nombre del biólogo:", "Nuevo experimento", JOptionPane.QUESTION_MESSAGE);
                        if (biologistName != null && !biologistName.trim().isEmpty()) {
                            String experimentName = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo experimento:", "Nuevo experimento", JOptionPane.QUESTION_MESSAGE);
                            if (experimentName != null && !experimentName.trim().isEmpty()) {
                                experimento experiment = null;
                                try {
                                    experiment = new experimento(experimentName, "Description here");
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                manejoExperimento.addExperimento(biologistName, experiment);

                                // Crear un archivo .txt para el experimento
                                fileChooser = new JFileChooser();
                                fileChooser.setDialogTitle("Seleccione dónde guardar el experimento");
                                userSelection = fileChooser.showSaveDialog(null);

                                if (userSelection == JFileChooser.APPROVE_OPTION) {
                                    File fileToSave = fileChooser.getSelectedFile();
                                    try (PrintWriter out = new PrintWriter(fileToSave + ".txt")) {
                                        out.println("Nombre del experimento: " + experimentName);
                                        out.println("Biologo: " + biologistName);
                                        out.println("Descripción: Description here");
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        break;

                    case "Borrar experimento":
                        String biologistNameToDelete = JOptionPane.showInputDialog(null, "Ingrese el nombre del biólogo:", "Borrar experimento", JOptionPane.QUESTION_MESSAGE);
                        String experimentNameToDelete = JOptionPane.showInputDialog(null, "Ingrese el nombre del experimento a borrar:", "Borrar experimento", JOptionPane.QUESTION_MESSAGE);
                        if (biologistNameToDelete != null && !biologistNameToDelete.trim().isEmpty() && experimentNameToDelete != null && !experimentNameToDelete.trim().isEmpty()) {
                            manejoExperimento.deleteExperimento(biologistNameToDelete, experimentNameToDelete);
                            // Resto del código
                        }
                        break;
                    case "Abrir experimento":
                        fileChooser = new JFileChooser();
                        fileChooser.setDialogTitle("Seleccione el experimento para abrir");
                        userSelection = fileChooser.showOpenDialog(null);

                        if (userSelection == JFileChooser.APPROVE_OPTION) {
                            File fileToOpen = fileChooser.getSelectedFile();
                            try (Scanner in = new Scanner(fileToOpen)) {
                                String experimentName = in.nextLine();
                                biologistName = in.nextLine();
                                String description = in.nextLine();
                                experimento experiment = new experimento(experimentName, description);
                                manejoExperimento.addExperimento(biologistName, experiment);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case "Ver información de la población":
                        poblacion_bacteria_window poblacionBacteriaWindow = new poblacion_bacteria_window(manejoExperimento);
                        poblacionBacteriaWindow.setLocationRelativeTo(null);
                        poblacionBacteriaWindow.setVisible(true);
                        break;
                    case "Editar experimento":
                        String biologistNameToEdit = JOptionPane.showInputDialog(null, "Ingrese el nombre del biólogo:", "Editar experimento", JOptionPane.QUESTION_MESSAGE);
                        String experimentNameToEdit = JOptionPane.showInputDialog(null, "Ingrese el nombre del experimento a editar:", "Editar experimento", JOptionPane.QUESTION_MESSAGE);
                        if (biologistNameToEdit != null && !biologistNameToEdit.trim().isEmpty() && experimentNameToEdit != null && !experimentNameToEdit.trim().isEmpty()) {
                            experimento experimentToEdit = manejoExperimento.getExperimento(biologistNameToEdit, experimentNameToEdit);
                            // Resto del código
                        }
                        break;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }
}