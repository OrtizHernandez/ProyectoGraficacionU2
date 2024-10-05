package org.example.Vista.Transformaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaReflexion {
    private JPanel vistaReflexion;
    private JPanel panelGeneralReflexion;
    private JPanel panelRefelxionDibujo;
    private JPanel panelReflexionFuncion;
    private JButton btnReflexionX;
    private JButton btnReflexionY;

    public class Romboide {

        int[] punto1 = new int[2];
        int[] punto2 = new int[2];
        int[] punto3 = new int[2];
        int[] punto4 = new int[2];

        public Romboide(int[] puntoInicial, int[] vector1, int[] vector2) {

            this.punto1 = puntoInicial;

            this.punto2 = new int[]{punto1[0] + vector1[0], punto1[1] + vector1[1]};
            this.punto3 = new int[]{punto1[0] + vector2[0], punto1[1] + vector2[1]};
            this.punto4 = new int[]{punto2[0] + vector2[0], punto2[1] + vector2[1]};
        }

        private int[] reflejarPunto(int[] punto, int[] lineaP1, int[] lineaP2) {
            int x1 = lineaP1[0];
            int y1 = lineaP1[1];
            int x2 = lineaP2[0];
            int y2 = lineaP2[1];
            int xp = punto[0];
            int yp = punto[1];


            double dx = x2 - x1;
            double dy = y2 - y1;
            double a = (dx * dx - dy * dy) / (dx * dx + dy * dy);
            double b = 2 * dx * dy / (dx * dx + dy * dy);

            int xR = (int) Math.round(a * (xp - x1) + b * (yp - y1) + x1);
            int yR = (int) Math.round(b * (xp - x1) - a * (yp - y1) + y1);

            return new int[] { xR, yR };
        }


        public void reflejarRespectoBase() {

            this.punto3 = reflejarPunto(punto3, punto1, punto2);
            this.punto4 = reflejarPunto(punto4, punto1, punto2);
        }

        private int[] reflejarPuntoEnLineaVertical(int[] punto, int xLinea) {
            int xReflejado = 2 * xLinea - punto[0];
            return new int[] { xReflejado, punto[1] };
        }


        public void reflejarRespectoLadoVertical() {

            int xLinea = punto1[0];
            this.punto2 = reflejarPuntoEnLineaVertical(punto2, xLinea);
            this.punto4 = reflejarPuntoEnLineaVertical(punto4, xLinea);
            this.punto3 = reflejarPuntoEnLineaVertical(punto3, xLinea);
        }

    }

    int[] puntoDeInicio = new int[] {350,200};
    int[] vectorBase = new int[] {100,0};
    int[] vectorInclinacion = new int[] {20,80};

    Romboide romboide = new Romboide(puntoDeInicio, vectorBase, vectorInclinacion);

    boolean reflejadoX = false;
    boolean reflejadoY = false;

    public JPanel getPanel(){
        return panelGeneralReflexion;
    }

    public vistaReflexion(){

        Graficos g = new Graficos();
        panelRefelxionDibujo.setLayout(new GridLayout());
        panelRefelxionDibujo.add(g);

        //----------------------------------------------------------------------------------------------

        btnReflexionX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                romboide.reflejarRespectoBase();

                g.repaint();

            }
        });

        //------------------------------------------------------------------------------------------------

            btnReflexionY.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    
                    romboide.reflejarRespectoLadoVertical();
                    g.repaint();

                }
            });
        //------------------------------------------------------------------------------------------------
    }


    public class Graficos extends JPanel{

        @Override
        public void paint(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.BLACK);
            g2d.drawLine(romboide.punto1[0],romboide.punto1[1],romboide.punto2[0],romboide.punto2[1]);
            g2d.drawLine(romboide.punto1[0],romboide.punto1[1],romboide.punto3[0],romboide.punto3[1]);
            g2d.drawLine(romboide.punto2[0],romboide.punto2[1],romboide.punto4[0],romboide.punto4[1]);
            g2d.drawLine(romboide.punto3[0],romboide.punto3[1],romboide.punto4[0],romboide.punto4[1]);

        }

    }
}
