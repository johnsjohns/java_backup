package com.johns.backup.gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowStateListener;

public class Tela extends JFrame {
    public static void main(String[] args) {
        Tela tela = new Tela();
        Principal principal = new Principal();
        tela.setSize(800, 500);
        tela.addWindowListener(new WindowHandler(tela, principal));
        tela.setLayout(new BorderLayout());
        tela.add(principal, BorderLayout.CENTER);
        tela.setVisible(true);
    }
}
