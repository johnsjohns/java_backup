package com.johns.backup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileButtonHandler implements ActionListener {
    private Principal painel;

    public FileButtonHandler(Principal painel) {
        this.painel = painel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Procurar") {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = chooser.showOpenDialog(painel);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                painel.setTxt(file.getAbsolutePath());
            }
            ;
        }

        if (e.getActionCommand() == "+") {
            String caminho = painel.getTxt().trim();
            if (!caminho.equals("")) {
                painel.addCaminho(caminho);
            }
        }
    }

}
