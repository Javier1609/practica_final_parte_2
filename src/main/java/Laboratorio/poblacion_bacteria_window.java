package Laboratorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class poblacion_bacteria_window extends JFrame {
    private Manejo_experimento manejoExperimento;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    private JTextField nombreField, diasField, biologoField;
    private JComboBox<String> algoritmoComidaComboBox;
    private JButton ordenarFechaInicioButton, ordenarNombreButton, ordenarNumeroBacteriasButton, ejecutarExperimentoButton;

    public poblacion_bacteria_window(Manejo_experimento manejoExperimento) {
        this.manejoExperimento = manejoExperimento;

        setTitle("Poblaciones de Bacterias");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Nombre", "Fecha de Inicio", "Número de Bacterias"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        nombreField = new JTextField(10);
        diasField = new JTextField(10);
        biologoField = new JTextField(10);
        algoritmoComidaComboBox = new JComboBox<>(new String[]{"Algoritmo 1", "Algoritmo 2", "Algoritmo 3"});
        panel.add(new JLabel("Nombre de la población:"));
        panel.add(nombreField);
        panel.add(new JLabel("Días:"));
        panel.add(diasField);
        panel.add(new JLabel("Biólogo:"));
        panel.add(biologoField);
        panel.add(new JLabel("Algoritmo de Comida:"));
        panel.add(algoritmoComidaComboBox);

        ordenarFechaInicioButton = new JButton("Ordenar por Fecha de Inicio");
        ordenarNombreButton = new JButton("Ordenar por Nombre");
        ordenarNumeroBacteriasButton = new JButton("Ordenar por Número de Bacterias");
        ejecutarExperimentoButton = new JButton("Ejecutar Experimento");

        panel.add(ordenarFechaInicioButton);
        panel.add(ordenarNombreButton);
        panel.add(ordenarNumeroBacteriasButton);
        panel.add(ejecutarExperimentoButton);

        add(panel, BorderLayout.SOUTH);

        updateTable();

        ordenarFechaInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejoExperimento.ordenarPorFechaInicio();
                updateTable();
            }
        });

        ordenarNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejoExperimento.ordenarPorNombre();
                updateTable();
            }
        });

        ordenarNumeroBacteriasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejoExperimento.ordenarPorNumeroBacterias();
                updateTable();
            }
        });

        ejecutarExperimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                int dias = Integer.parseInt(diasField.getText());
                String biologo = biologoField.getText();
                String algoritmoComida = (String) algoritmoComidaComboBox.getSelectedItem();
                experimento experimento = new experimento(nombre, dias);
                // Aquí puedes agregar el código para seleccionar el algoritmo de comida en función de la selección en el JComboBox
                manejoExperimento.addExperimento(biologo, experimento);
                manejoExperimento.ejecutarExperimento(biologo, experimento);
                updateTable();
            }
        });

        setVisible(true);
    }

    private void updateTable() {
        model.setRowCount(0); // Limpiar la tabla

        for (poblacion_bacteria_window : manejoExperimento.getExperimentos()) {
            Object[] o = new Object[3];
            o[0] = poblacion.getNombre();
            o[1] = poblacion.getFechaInicio();
            o[2] = poblacion.getBacterias().size();
            model.addRow(o);
        }
    }
}