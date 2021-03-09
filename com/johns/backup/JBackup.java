package com.johns.backup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;

import org.apache.commons.io.FileUtils;
import com.johns.backup.gui.table.Item;

public class JBackup implements Runnable {
    private List<Item> itens;
    private File destino;
    private JProgressBar progress;

    public JBackup(List<Item> itens, File destino, JProgressBar progress) {
        this.itens = itens;
        this.destino = destino;
        this.progress = progress;
    }

    public void run() {
        progress.setMaximum(getTotal());
        /*
         * for (Item item : itens) { File arq = new File(item.getDiretorio());
         * copiar(arq); }
         */

    }

    private void copiar(File arq) {

        String caminho = destino.getAbsolutePath();
        String barra = File.separator;
        if (arq.isDirectory()) {
            copiar(arq);
        } else {
            File novo = new File(caminho + barra + arq.getPath());
            try {
                FileUtils.copyFile(arq, novo);
                Thread update = new Thread(new Runnable() {
                    public void run() {
                        progress.setValue(progress.getValue() + 1);
                    }
                });
                update.start();
            } catch (IOException e) {
                System.out.println("FUdeu");
            }
        }

    }

    public int getTotal() {
        int total = 0;
        for (Item item : itens) {
            File arq = new File(item.getDiretorio());
            total += listar(arq).size();

        }
        return total;
    }

    private List<String> listar(File arq) {
        List<String> arquivos = new ArrayList<String>();
        System.out.println("arq.getPath()");
        // String caminho = destino.getAbsolutePath();
        // String barra = File.separator;
        if (arq.isDirectory()) {
            // arquivos.addAll(listar(arq));
        } else {
            System.out.println("iuia");
            // arquivos.add(caminho + barra + arq.getName());
        }
        return arquivos;
    }
}
