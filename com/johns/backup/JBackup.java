package com.johns.backup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;

import com.johns.Delay.Delay;
import org.apache.commons.io.FileUtils;
import com.johns.backup.gui.table.Item;

public class JBackup implements Runnable {
    private List<Item> itens;
    private File destino;
    private JProgressBar progress;
    private String barra;

    public JBackup(List<Item> itens, File destino, JProgressBar progress) {
        this.itens = itens;
        this.destino = destino;
        this.progress = progress;
        barra = File.separator;
    }

    public void run() {
        progress.setMaximum(getTotal());

        for (Item item : itens) { File arq = new File(item.getDiretorio());
        copiar(arq, destino.getPath() + barra + arq.getName());
        }


    }

    private void copiar(File arq, String caminho ) {

        File arqs[] = arq.listFiles();
        for(File arq_temp : arqs){
            if (arq_temp.isDirectory()) {
                copiar(arq_temp, caminho +barra+ arq_temp.getName());
            } else {

                File novo = new File(caminho + barra + arq_temp.getName());
                try {
                    FileUtils.copyFile(arq_temp, novo);
                    Thread update = new Thread(new Runnable() {
                        public void run() {
                        progress.setValue(progress.getValue() + 1);
                    }
                    });
                    update.start();
                } catch (IOException e) {
                    System.out.println("FUdeu");
                    e.printStackTrace();
                }

            }
        }


    }

    public int getTotal() {
        int total = 0;
        for (Item item : itens) {
            File arq = new File(item.getDiretorio());
            total += listar(arq, arq.getAbsolutePath()).size();

        }

        return total;
    }

    private List<String> listar(File arq, String Caminho) {
        List<String> arquivos = new ArrayList<String>();
        String caminho = dest;
        File arqs[] = arq.listFiles();
        for(File arq_tem : arqs){
            if(arq_tem.isDirectory()){
                arquivos.addAll(listar(arq_tem, caminho + barra + arq_tem.getName()));
            } else {
                arquivos.add(caminho + barra + arq.getName());

            }
        }

        return arquivos;
    }
}
