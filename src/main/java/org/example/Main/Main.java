package org.example.Main;

import org.example.Vista.vistaMenuPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

       SwingUtilities.invokeLater(new Runnable() {

           public void run() {

               JFrame ventana = new vistaMenuPrincipal();
               ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               ventana.setVisible(true);
               ventana.setLocation(310,80);
               ventana.setResizable(false);
               ventana.setSize(800,600);

           }

       });

    }
}