package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

public class vistaTraslacion extends  JFrame{
    private JPanel panel1;
    private JPanel panelGeneralTraslacion;
    private JPanel panelTraslacionDibujo;
    private JPanel panelTraslacionFuncion;
    private JLabel lblMover;
    private JTextField textFieldX;
    private JLabel lblX;
    private JTextField textFieldY;
    private JLabel lblY;
    private JButton btnTrasladar;

    public ArrayList<vectorTraslacion> vectores = new ArrayList<>();

    public class vectorTraslacion {

        int[] puntoInicial = new int[2];
        int[] puntoFinal = new int[2];

    }

    int x = 0;
    int y = 0;
    int ancho = 100;
    int alto = 100;

    //---------------------------------------------------------------------------------------------------
    //Este es el metodo que le adjunte para poder recuperar el panel general y que se muestre en el card
    public JPanel getPanel(){
        return panelGeneralTraslacion;
    }
    //-------------------------------------------------------------------------------------------------------

    protected void paintComponent(Graphics g) {
        super.paint(g);

        trazarVector(g,vectores.getLast().puntoInicial, vectores.getLast().puntoFinal);
    }

    public void trazarVector(Graphics g, int [] puntosIniciales, int[] puntosFinales){

        g.setColor(Color.black);
        g.drawLine(puntosIniciales[0], puntosIniciales[1], puntosFinales[0], puntosFinales[1]);

    }

    public vistaTraslacion(){

        Graficos g = new Graficos();
        panelTraslacionDibujo.setLayout(new GridLayout());
        panelTraslacionDibujo.add(g);

        //---------------------------------------------------------------------------------------------

        btnTrasladar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                vectorTraslacion vector = new vectorTraslacion();
                vectores.add(vector);

                vector.puntoInicial[0] = x;
                vector.puntoInicial[1] = y;

                x=Integer.parseInt(textFieldX.getText());
                y=Integer.parseInt(textFieldY.getText());

                vector.puntoFinal[0]=x;
                vector.puntoFinal[1]=y;



                panelTraslacionDibujo.repaint();
                g.repaint();
            }
        });

        //-------------------------------------------------------------------------------------------------

    }



    public class Graficos extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            for (vectorTraslacion vector : vectores) {
                trazarVector(g2d, vector.puntoInicial, vector.puntoFinal);
            }

            g2d.setColor(Color.blue);
            g2d.fillRect(x, y, ancho, alto);
        }
    }
}


