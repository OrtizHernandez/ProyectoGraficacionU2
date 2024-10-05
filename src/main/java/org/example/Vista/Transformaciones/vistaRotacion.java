package org.example.Vista.Transformaciones;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class vistaRotacion {
    private JPanel vistaRotacion;
    private JPanel panelGeneralRotacion;
    private JPanel panelRotacionDibujo;
    private JPanel panelRotacionFuncion;
    private JLabel lblRotar;
    private JLabel lblGrados;
    private JSpinner spnGrados;

    int x = 375;
    int y = 170;

    int ancho = 100;
    int alto = 100;

    int giro = 0;

    //---------------------------------------------------------------------------------------------------
    //Este es el metodo que le adjunte para poder recuperar el panel general y que se muestre en el card
    public JPanel getPanel(){

        return panelGeneralRotacion;
    }
    //-------------------------------------------------------------------------------------------------

    public vistaRotacion(){

        Graficos g = new Graficos();

        spnGrados.setModel(new SpinnerNumberModel(0, -360, 360, 5));
        panelRotacionDibujo.setLayout(new GridLayout());
        panelRotacionDibujo.add(g);

        //---------------------------------------------------------------------------------------------


        spnGrados.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                giro = (int)spnGrados.getValue();
                g.repaint();

            }
        });

        //--------------------------------------------------------------------------------------------


    }

    public class Graficos extends JPanel{
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(x,y);
            g2d.rotate(Math.toRadians(giro));
            g2d.setColor(Color.MAGENTA);
            g2d.fillRect(0, 0, ancho, alto);

        }
    }
}
