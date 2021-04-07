package com.johns.backup.gui;

import com.johns.Propriedades;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class WindowHandler implements WindowListener {

    JFrame frame;
    Principal painel;
    public WindowHandler(JFrame frame, Principal painel){
        this.frame = frame;
        this.painel = painel;
    }


    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane .showMessageDialog(frame, "Seja bem vindo ao programda de backup do Johns", "Johns Backup", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        painel.gravar();
        Propriedades prop = new Propriedades();
        prop.setProp("diretorio", painel.getTxtDestino());
        this.frame.dispose();
        System.exit(0);




    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
