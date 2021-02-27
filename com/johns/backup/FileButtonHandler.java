package com.johns.backup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileButtonHandler implements ActionListener{
    private Principal painel;
    public FileButtonHandler(Principal painel){
        this.painel = painel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Procurar"){
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(painel);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                painel.setTxt(file.getAbsolutePath());
            };
        }
    }
    
    
}
