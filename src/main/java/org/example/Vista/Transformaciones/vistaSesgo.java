package org.example.Vista.Transformaciones;

import org.example.Modelo.Cuadrado;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class vistaSesgo {
    private JPanel vistaSesgo;
    private JPanel panelGeneralSesgo;
    private JPanel panelSesgoDibujo;
    private JPanel panelSesgoFuncion;
    private JLabel lblSesgoX;
    private JSpinner spnSesgoX;
    private JLabel lblSesgoY;
    private JSpinner spnSesgoY;

    int[] puntoInicio = {350,150};
    int ladoX = 100;
    int ladoY = 100;

    public Cuadrado cuadrado = new Cuadrado(puntoInicio,ladoX,ladoY);


    public JPanel getPanel(){

        return panelGeneralSesgo;
    }

    public vistaSesgo(){

        Graficos g = new Graficos();
        panelSesgoDibujo.setLayout(new GridLayout());
        panelSesgoDibujo.add(g);

        spnSesgoX.setModel(new SpinnerNumberModel(0,-20,20,5));
        spnSesgoY.setModel(new SpinnerNumberModel(0,-20,20,5));


        //-----------------------------------------------------------------------------------

        spnSesgoX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {


                cuadrado.punto1[0] = cuadrado.punto1[0] + (int)spnSesgoX.getValue();
                cuadrado.punto2[0] = cuadrado.punto2[0] + (int)spnSesgoX.getValue();

                spnSesgoX.setValue(0);

                g.repaint();
            }


        });

        //----------------------------------------------------------------------------------------

        spnSesgoY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {



                cuadrado.punto1[1] = cuadrado.punto1[1] - (int)spnSesgoY.getValue();
                cuadrado.punto3[1] = cuadrado.punto3[1] - (int)spnSesgoY.getValue();

                spnSesgoY.setValue(0);


                g.repaint();

            }
        });



    }

    public class Graficos extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.BLACK);
            g2d.drawLine(cuadrado.punto1[0],cuadrado.punto1[1],cuadrado.punto2[0],cuadrado.punto2[1]);
            g2d.drawLine(cuadrado.punto1[0],cuadrado.punto1[1],cuadrado.punto3[0],cuadrado.punto3[1]);
            g2d.drawLine(cuadrado.punto2[0],cuadrado.punto2[1],cuadrado.punto4[0],cuadrado.punto4[1]);
            g2d.drawLine(cuadrado.punto3[0],cuadrado.punto3[1],cuadrado.punto4[0],cuadrado.punto4[1]);
        }
    }
}
