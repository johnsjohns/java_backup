package com.johns.backup.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabel extends AbstractTableModel {
    private String columnName[] = { "id", "diretorio" };
    List<Item> modelRows;

    public ModelTabel(List<Item> items) {
        modelRows = items;
    }

    public ModelTabel() {
        modelRows = new ArrayList<Item>();
    }

    @Override
    public int getRowCount() {
        return modelRows.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = modelRows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getIndex();
            // break;
            case 1:
                return item.getDiretorio();
            // break;
            default:
                return -1;
        }
    }

    public void insertRow(String nomeDiretorio) {
        if (modelRows.size() > 0) {
            Item item = modelRows.get(modelRows.size() - 1);
            int index = item.getIndex() + 1;
            modelRows.add(new Item(index, nomeDiretorio));
            fireTableCellUpdated(index, 0);
            fireTableCellUpdated(index, 1);
        } else {
            modelRows.add(new Item(1, nomeDiretorio));
            fireTableCellUpdated(0, 0);
            fireTableCellUpdated(0, 1);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnName[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        } else {
            return String.class;
        }

    }

    public void setValueAt(int index, Item item) {
        Item aux = modelRows.get(index);
        aux.setIndex(item.getIndex());
        aux.setDiretorio(item.getDiretorio());
        fireTableCellUpdated(index, 0);
        fireTableCellUpdated(index, 1);
    }

    public String getDiretorio(int index) {
        return modelRows.get(index).getDiretorio();
    }

    public boolean exists(String caminho) {
        boolean existe = false;
        for (Item coisas : modelRows) {
            if (caminho.equals(coisas.getDiretorio())) {
                existe = true;
            }
        }
        return existe;
    }

}
