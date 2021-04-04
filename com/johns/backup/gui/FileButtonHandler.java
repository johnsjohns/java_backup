package com.johns.backup.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import com.johns.Delay.Delay;
import com.johns.Propriedades;
import com.johns.backup.JBackup;
import com.johns.backup.gui.table.Item;

public class FileButtonHandler implements ActionListener {
    private Principal painel;

    public FileButtonHandler(Principal painel){
        this.painel = painel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

        case "Procurar":
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = chooser.showOpenDialog(painel);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                painel.setTxt(file.getAbsolutePath());
            }
            String caminho = painel.getTxt().trim();
            if (!caminho.equals("")) {
                painel.addCaminho(caminho);
            }
            break;

        case "BackUp":
            File destino = new File(painel.getTxtCaminho());
            List<Item> items = new ArrayList<Item>(painel.getItens());
            JBackup backup = new JBackup(items, destino, painel.getProgresso());
            Thread t1 = new Thread(backup);
            t1.start();
            break;

        case "Destino":
            JFileChooser DestinChooser = new JFileChooser();
            DestinChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnDest = DestinChooser.showOpenDialog(painel);
            if (returnDest == JFileChooser.APPROVE_OPTION) {
                File file = DestinChooser.getSelectedFile();
                painel.setTxtDestino(file.getAbsolutePath());
                Propriedades prop = new Propriedades();
                prop.setProp("diretorio", file.getAbsolutePath());
            }
            break;
        case "-":
            painel.removeItem();
            break;





        }

    }
}
