package com.johns.backup.table;

public class Item {
    private String diretorio;
    private int index;

    public Item() {

    }

    public Item(int index, String diretorio) {
        this.diretorio = diretorio;
        this.index = index;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public int getIndex() {
        return index;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
