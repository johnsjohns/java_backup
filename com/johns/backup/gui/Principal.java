package com.johns.backup.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.johns.Delay.Delay;
import com.johns.backup.gui.table.Item;
import com.johns.backup.gui.table.ModelTabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

public class Principal extends JPanel {
    private JLabel lblCaminho, lblDestino;
    private JTextField txtCaminho, txtDestino;
    private JButton btnCaminho, btnAdd, btnBackup, btnDestino, btnRemove;
    private JTable tabela;
    private ModelTabel modelo;
    private JScrollPane sPainel;
    private JProgressBar progress;
    private int incrementa;

    public Principal() {
        lblCaminho = new JLabel("Diretorio");
        txtCaminho = new JTextField("", 40);
        btnCaminho = new JButton("Procurar");
        btnAdd = new JButton("+");
        btnRemove = new JButton("-");
        JPanel pnlCaminho = new JPanel(new FlowLayout());
        pnlCaminho.add(lblCaminho);
        pnlCaminho.add(txtCaminho);
        pnlCaminho.add(btnCaminho);
        pnlCaminho.add(btnAdd);
        pnlCaminho.add(btnRemove);
        pnlCaminho.setMaximumSize(new Dimension(100, 1000));
        incrementa = 0;

        btnDestino = new JButton("Destino");
        lblDestino = new JLabel("Destino");
        txtDestino = new JTextField("", 10);

        JPanel painelDestino = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelDestino.add(lblDestino);
        painelDestino.add(txtDestino);
        painelDestino.add(btnDestino);

        btnBackup = new JButton("BackUp");
        progress = new JProgressBar();
        progress.setMaximum(100);
        progress.setValue(0);
        progress.setStringPainted(true);

        JPanel painelBackup = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBackup.add(progress);
        painelBackup.add(btnBackup);

        JPanel painelBaixo = new JPanel();
        painelBaixo.add(painelDestino);
        painelBaixo.add(painelBackup);

        modelo = new ModelTabel();
        tabela = new JTable(modelo);
        tabela.getColumnModel().getColumn(0).setMaxWidth(40);

        setLayout(new BorderLayout());
        add(pnlCaminho, BorderLayout.NORTH);
        sPainel = new JScrollPane(tabela);
        add(sPainel, BorderLayout.CENTER);
        add(painelBaixo, BorderLayout.SOUTH);

        FileButtonHandler bt = new FileButtonHandler(this);
        btnCaminho.addActionListener(bt);
        btnAdd.addActionListener(bt);
        btnBackup.addActionListener(bt);
        btnDestino.addActionListener(bt);
        btnRemove.addActionListener(bt);
    }

    public void setTxt(String caminho) {
        txtCaminho.setText(caminho);
    }

    public String getTxt() {
        return txtCaminho.getText();
    }

    public String getTxtCaminho() {
        return txtCaminho.getText();
    }

    public void addCaminho(String caminho) {
        if (!modelo.exists(caminho)) {
            modelo.insertRow(caminho);
            sPainel.setViewportView(tabela);
        }
    }

    public JProgressBar getProgresso() {
        return progress;

    }

    public void setTxtDestino(String destin) {

        txtDestino.setText(destin);
    }

    public List<Item> getItens() {

        return modelo.getItens();
    }

    public void removeItem (){
        modelo.removeItem(tabela.getSelectedRow());
    }

}
