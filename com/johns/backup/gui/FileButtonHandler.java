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
import com.johns.backup.Gravador;
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
            Gravador gravador = new Gravador();
            List<String> lista_arq= gravador.getLista();
            if(lista_arq.size() == 0){
                chooser.setCurrentDirectory(new File("./"));
            } else {
                chooser.setCurrentDirectory(new File(lista_arq.get(lista_arq.size() -1)));
            }
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
            File destino = new File(painel.getTxtDestino());
            List<Item> items = new ArrayList<Item>(painel.getItens());
            JBackup backup = new JBackup(items, destino, painel.getProgresso());
            Thread t1 = new Thread(backup);
            t1.start();
            break;

        case "Destino":
            JFileChooser destinChooser = new JFileChooser();
            String dirAntes = painel.getTxtDestino();
            dirAntes.trim();
            if(dirAntes.equals("")){
                destinChooser.setCurrentDirectory(new File("./"));
            } else {
                destinChooser.setCurrentDirectory(new File(dirAntes));
            }
            destinChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnDest = destinChooser.showOpenDialog(painel);
            if (returnDest == JFileChooser.APPROVE_OPTION) {
                File file = destinChooser.getSelectedFile();
                painel.setTxtDestino(file.getAbsolutePath());
                //Propriedades prop = new Propriedades();
                //prop.setProp("diretorio", file.getAbsolutePath());
            }
            break;
        case "-":
            painel.removeItem();
            break;





        }

    }
}
