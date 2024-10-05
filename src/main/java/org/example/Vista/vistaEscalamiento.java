package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class vistaEscalamiento {
    private JPanel vistaEscalamiento;
    private JPanel panelGeneralEscalamiento;
    private JPanel panelEscalamientoDibujo;
    private JPanel panelEscalamientoFuncion;
    private JLabel lblEscalarX;
    private JButton btnEscalarX;
    private JTextField textFieldEscalaX;
    private JLabel lblEscalarY;
    private JTextField textFieldEscalaY;
    private JButton btnEscalarY;
    private JLabel lblEscaladoUniforme;
    private JTextField textFieldEscaladoUniforme;
    private JButton btnEscalarUniforme;

    public class Cuadrado {

        int[] punto1 = new int[2];


        int[] punto2 = new int[2];
        int[] punto3 = new int[2];
        int[] punto4 = new int[2];

        int ladoX;
        int ladoY;


        public Cuadrado() {
        }

        public Cuadrado(int[] punto1, int ladoX, int ladoY) {
            this.punto1 = punto1;
            this.ladoX = ladoX;
            this.ladoY = ladoY;

            this.punto2 = new int[] { punto1[0] + ladoX, punto1[1] };
            this.punto3 = new int[] { punto1[0] + ladoX, punto1[1] + ladoY };
            this.punto4 = new int[] { punto1[0], punto1[1] + ladoY };
        }


        public int[] getPunto1() {
            return punto1;
        }

        public void setPunto1(int[] punto1) {
            this.punto1 = punto1;
        }

        public int[] getPunto2() {
            return punto2;
        }

        public void setPunto2(int[] punto2) {
            this.punto2 = punto2;
        }

        public int[] getPunto3() {
            return punto3;
        }

        public void setPunto3(int[] punto3) {
            this.punto3 = punto3;
        }

        public int[] getPunto4() {
            return punto4;
        }

        public void setPunto4(int[] punto4) {
            this.punto4 = punto4;
        }

        public int getLadoX() {
            return ladoX;
        }

        public void setLadoX(int lado) {
            this.ladoX = lado;
        }

        public int getLadoY() {
            return ladoY;
        }

        public void setLadoY(int ladoY) {
            this.ladoY = ladoY;
        }
    }

    int[] puntoFijoInicio = {50,50};
    int LadoX = 50;
    int LadoY = 50;

    Cuadrado cuadrado = new Cuadrado(puntoFijoInicio,LadoX,LadoY);

    double escaladoX = 0.0;
    double escaladoY = 0.0;


    //---------------------------------------------------------------------------------------------------
    //Este es el metodo que le adjunte para poder recuperar el panel general y que se muestre en el card
    public JPanel getPanel() {
        return panelGeneralEscalamiento;
    }


    public vistaEscalamiento(){

        Graficos g = new Graficos();
        panelEscalamientoDibujo.setLayout(new GridLayout());
        panelEscalamientoDibujo.add(g);

        //---------------------------------------------------------------------------------------------

        btnEscalarX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                double escalaX = Double.parseDouble(textFieldEscalaX.getText());

                Double distanciaX = 0.0;

                distanciaX = escalaX*LadoX;

                cuadrado.punto2[0] = (int)(LadoX+distanciaX);
                cuadrado.punto3[0] = (int)(LadoX+distanciaX);


                g.repaint();


            }
        });

        //---------------------------------------------------------------------------------------------

        btnEscalarY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                double escalaY = Double.parseDouble(textFieldEscalaY.getText());

                Double distanciaY = 0.0;

                distanciaY = escalaY*LadoY;

                cuadrado.punto3[1] = (int)(LadoY+distanciaY);
                cuadrado.punto4[1] = (int)(LadoY+distanciaY);


                g.repaint();


            }
        });

        //---------------------------------------------------------------------------------------------

        btnEscalarUniforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                double escalaUniforme = Double.parseDouble(textFieldEscaladoUniforme.getText());
                double distanciaUniforme = 0.0;

                textFieldEscalaX.setText(Double.toString(escalaUniforme));
                textFieldEscalaY.setText(Double.toString(escalaUniforme));

                Double distanciaY = escalaUniforme*LadoY;
                cuadrado.punto3[1] = (int)(LadoY+distanciaY);
                cuadrado.punto4[1] = (int)(LadoY+distanciaY);


                Double distanciaX = escalaUniforme*LadoX;
                cuadrado.punto2[0] = (int)(LadoX+distanciaX);
                cuadrado.punto3[0] = (int)(LadoX+distanciaX);

                g.repaint();

            }
        });


    }



    public class Graficos extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            //g2d.scale(ancho,alto);

            g2d.setColor(Color.BLACK);
            g2d.drawLine(cuadrado.punto1[0],cuadrado.punto1[1],cuadrado.punto2[0],cuadrado.punto2[1]);
            g2d.drawLine(cuadrado.punto1[0],cuadrado.punto1[1],cuadrado.punto4[0],cuadrado.punto4[1]);
            g2d.drawLine(cuadrado.punto2[0],cuadrado.punto2[1],cuadrado.punto3[0],cuadrado.punto3[1]);
            g2d.drawLine(cuadrado.punto3[0],cuadrado.punto3[1],cuadrado.punto4[0],cuadrado.punto4[1]);
        }
    }
}
