package com.johns.backup.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabel extends AbstractTableModel {
    private String columnName[] = { "id", "diretorio" };
    List<Item> modelRows = new ArrayList<Item>();

    @Override
    public int getRowCount() {
        return modelRows.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = modelRows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getIndex();
                break;
            case 1:
                return item.getDiretorio();
                break;
            default:
                return -1;
        }
    }

    public void insertRow(String nomeDiretorio) {
        Item item = modelRows.get(modelRows.size());
        int index = item.getIndex() + 1;
        modelRows.add(new Item(index, nomeDiretorio));
        fireTableCellUpdated(index, 0);
        fireTableCellUpdated(index, 1);

    }

    public void setValueAt(int index, Item item) {

    }

}
