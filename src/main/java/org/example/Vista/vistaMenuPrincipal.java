package org.example.Vista;

import org.example.Vista.Transformaciones.vistaReflexion;
import org.example.Vista.Transformaciones.vistaRotacion;
import org.example.Vista.Transformaciones.vistaSesgo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaMenuPrincipal extends JFrame{



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

    //-------------------------------------------------------------------------------------------
    //Creo un objeto cardlayout para asignarselo como layout a su panel correspondiente

    CardLayout card = new CardLayout();
    JPanel panelCentro = new JPanel(card);

    //instancio los demas Frames para su posterior uso
    vistaTraslacion traslacion = new vistaTraslacion();
    vistaEscalamiento escalamiento = new vistaEscalamiento();
    vistaRotacion rotacion = new vistaRotacion();
    vistaSesgo sesgo = new vistaSesgo();
    vistaReflexion reflexion = new vistaReflexion();
    //-------------------------------------------------------------

    public vistaMenuPrincipal(){


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


            //Aqui al panel card le añado el panel que se desea usar haciendo uso del metodo creado por mi
            //.getPanel() (para ver mas sobre el metodo revisar cada una de las demas vistas)
            panelCentro.add(traslacion.getPanel(),"traslacion");
            //ademas de añadirle el panel a mostrar al final tambien se crea una referencia a modo de string


            card.show(panelCentro,"traslacion");
                //uso el metodo .show(); para que se mueste el panel deseado y se adjunta la referencia antes creada
                //la sintaxis es Cardlayout.show(panelCard,"referencia")

            SwingUtilities.updateComponentTreeUI(panelCentro);
            panelCentro.repaint();

            lblTransformacion.setText("Traslación");
            }
        });

        //---------------------------------------------------------------------------------------------

        btnEscalamiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Aqui al panel card le añado el panel que se desea usar haciendo uso del metodo creado por mi
                //.getPanel() (para ver mas sobre el metodo revisar cada una de las demas vistas)
                panelCentro.add(escalamiento.getPanel(),"escalamiento");
                //ademas de añadirle el panel a mostrar al final tambien se crea una referencia a modo de string

                card.show(panelCentro,"escalamiento");
                //uso el metodo .show(); para que se mueste el panel deseado y se adjunta la referencia antes creada
                //la sintaxis es Cardlayout.show(panelCard,"referencia")

                SwingUtilities.updateComponentTreeUI(panelCentro);
                panelCentro.repaint();

                lblTransformacion.setText("Escalamiento");
            }


        });

        //------------------------------------------------------------------------------------------------

        btnRotacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Aqui al panel card le añado el panel que se desea usar haciendo uso del metodo creado por mi
                //.getPanel() (para ver mas sobre el metodo revisar cada una de las demas vistas)
                panelCentro.add(rotacion.getPanel(),"rotacion");
                //ademas de añadirle el panel a mostrar al final tambien se crea una referencia a modo de string

                card.show(panelCentro,"rotacion");
                //uso el metodo .show(); para que se mueste el panel deseado y se adjunta la referencia antes creada
                //la sintaxis es Cardlayout.show(panelCard,"referencia")

                SwingUtilities.updateComponentTreeUI(panelCentro);
                panelCentro.repaint();

                lblTransformacion.setText("Rotacion");

            }
        });

        //--------------------------------------------------------------------------------------------------

        btnSesgado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Aqui al panel card le añado el panel que se desea usar haciendo uso del metodo creado por mi
                //.getPanel() (para ver mas sobre el metodo revisar cada una de las demas vistas)
                panelCentro.add(sesgo.getPanel(),"sesgo");
                //ademas de añadirle el panel a mostrar al final tambien se crea una referencia a modo de string

                card.show(panelCentro,"sesgo");
                //uso el metodo .show(); para que se mueste el panel deseado y se adjunta la referencia antes creada
                //la sintaxis es Cardlayout.show(panelCard,"referencia")

                SwingUtilities.updateComponentTreeUI(panelCentro);
                panelCentro.repaint();

                lblTransformacion.setText("Sesgado");

            }
        });

        //----------------------------------------------------------------------------------------------

        btnReflexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Aqui al panel card le añado el panel que se desea usar haciendo uso del metodo creado por mi
                //.getPanel() (para ver mas sobre el metodo revisar cada una de las demas vistas)
                panelCentro.add(reflexion.getPanel(),"reflexion");
                //ademas de añadirle el panel a mostrar al final tambien se crea una referencia a modo de string

                card.show(panelCentro,"reflexion");
                //uso el metodo .show(); para que se mueste el panel deseado y se adjunta la referencia antes creada
                //la sintaxis es Cardlayout.show(panelCard,"referencia")

                SwingUtilities.updateComponentTreeUI(panelCentro);
                panelCentro.repaint();

                lblTransformacion.setText("Reflexion");

            }
        });



        //----------------------------------------------------------------------------------------------


    }

}

