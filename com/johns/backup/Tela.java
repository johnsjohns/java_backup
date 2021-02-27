package com.johns.backup;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Tela extends JFrame {
    public static void main(String[] args){
        Tela tela = new Tela();
        tela.setSize(600, 500);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());
        tela.add(new Principal(), BorderLayout.CENTER);
        tela.setVisible(true);
    }
}
