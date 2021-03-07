package com.johns.backup;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.johns.backup.gui.table.Item;

public class JBackup implements Runnable {
    private List<Item> itens;
    File destino;

    public JBackup(List<Item> itens, File destino) {
        this.itens = itens;
        this.destino = destino;
    }

    public void run() {
        System.out.println("uia!!");
    }

}
