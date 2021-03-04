package com.johns.backup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.johns.backup.table.ModelTabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Principal extends JPanel {
    private JLabel lblCaminho;
    private JTextField txtCaminho;
    private JButton btnCaminho, btnAdd, btnBackup;
    private JTable tabela;
    private ModelTabel modelo;
    private JScrollPane sPainel;

    public Principal() {
        lblCaminho = new JLabel("Diretorio");
        txtCaminho = new JTextField("", 40);
        btnCaminho = new JButton("Procurar");
        btnAdd = new JButton("+");
        JPanel pnlCaminho = new JPanel(new FlowLayout());
        pnlCaminho.add(lblCaminho);
        pnlCaminho.add(txtCaminho);
        pnlCaminho.add(btnCaminho);
        pnlCaminho.add(btnAdd);
        pnlCaminho.setMaximumSize(new Dimension(100, 1000));

        btnBackup = new JButton("BackUp");

        JPanel painelBackup = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBackup.add(btnBackup);

        modelo = new ModelTabel();
        tabela = new JTable(modelo);
        tabela.getColumnModel().getColumn(0).setMaxWidth(40);
        setLayout(new BorderLayout());

        add(pnlCaminho, BorderLayout.NORTH);
        sPainel = new JScrollPane(tabela);
        add(sPainel, BorderLayout.CENTER);
        add(painelBackup, BorderLayout.SOUTH);
        FileButtonHandler bt = new FileButtonHandler(this);

        btnCaminho.addActionListener(bt);
        btnAdd.addActionListener(bt);
    }

    public void setTxt(String caminho) {
        txtCaminho.setText(caminho);
    }

    public String getTxt() {
        return txtCaminho.getText();
    }

    public void addCaminho(String caminho) {
        if (!modelo.exists(caminho)) {
            modelo.insertRow(caminho);
            sPainel.setViewportView(tabela);
        }

    }
}
