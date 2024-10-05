package org.example.Vista;

import org.example.Vista.Transformaciones.vistaReflexion;
import org.example.Vista.Transformaciones.vistaRotacion;
import org.example.Vista.Transformaciones.vistaSesgo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaGraficacion extends JFrame{

    CardLayout card = new CardLayout();

    private JPanel panel1;
    private JPanel panelGeneral;
    private JPanel panelNorte;
    private JLabel lblTitulo;
    private JButton btnTraslacion;
    private JButton btnRotacion;
    private JButton btnEscalamiento;
    private JButton btnSesgado;
    private JPanel panelSur;
    private JLabel lblMostrando;
    private JLabel lblTransformacion;
    private JButton btnReflexion;

    JPanel panelCentro = new JPanel(card);

    vistaTraslacion traslacion = new vistaTraslacion();
    vistaEscalamiento escalamiento = new vistaEscalamiento();
    vistaRotacion rotacion = new vistaRotacion();
    vistaSesgo sesgo = new vistaSesgo();
    vistaReflexion reflexion = new vistaReflexion();

    public vistaGraficacion(){


        super("Proyecto Graficacion U2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        //setLocationRelativeTo(null);
        setContentPane(panelGeneral);


        panelCentro.setSize(800,400);
        panelGeneral.add(panelCentro, BorderLayout.CENTER);


        //------------------------------------------------------------------------------------------
        btnTraslacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            panelCentro.add(traslacion.getPanel(),"traslacion");
            card.show(panelCentro,"traslacion");
            SwingUtilities.updateComponentTreeUI(panelCentro);
            panelCentro.repaint();

            lblTransformacion.setText("Traslación");
            }
        });

        //---------------------------------------------------------------------------------------------

        btnEscalamiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelCentro.add(escalamiento.getPanel(),"escalamiento");
                card.show(panelCentro,"escalamiento");
                SwingUtilities.updateComponentTreeUI(panelCentro);
                panelCentro.repaint();

                lblTransformacion.setText("Escalamiento");
            }


        });

        //------------------------------------------------------------------------------------------------

        btnRotacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                panelCentro.add(rotacion.getPanel(),"rotacion");
                card.show(panelCentro,"rotacion");
                SwingUtilities.updateComponentTreeUI(panelCentro);
                panelCentro.repaint();

                lblTransformacion.setText("Rotacion");

            }
        });

        //--------------------------------------------------------------------------------------------------

        btnSesgado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                panelCentro.add(sesgo.getPanel(),"sesgo");
                card.show(panelCentro,"sesgo");
                SwingUtilities.updateComponentTreeUI(panelCentro);
                panelCentro.repaint();

                lblTransformacion.setText("Sesgado");

            }
        });

        //----------------------------------------------------------------------------------------------

        btnReflexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                panelCentro.add(reflexion.getPanel(),"reflexion");
                card.show(panelCentro,"reflexion");
                SwingUtilities.updateComponentTreeUI(panelCentro);
                panelCentro.repaint();

                lblTransformacion.setText("Reflexion");

            }
        });



        //----------------------------------------------------------------------------------------------


    }

}

