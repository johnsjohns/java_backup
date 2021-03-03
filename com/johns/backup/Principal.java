package com.johns.backup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Principal extends JPanel {
    private JLabel lblCaminho;
    private JTextField txtCaminho;
    private JButton btnCaminho, btnAdd;
    private JTable tabela;

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
        String colunas[] = { "caminho" };
        String dados[][] = { { "diretorio1" }, { "diretorio2" } };

        tabela = new JTable(dados, colunas);

        setLayout(new BorderLayout());
        add(pnlCaminho, BorderLayout.CENTER);
        JScrollPane sPainel = new JScrollPane(tabela);
        add(sPainel, BorderLayout.SOUTH);
        FileButtonHandler bt = new FileButtonHandler(this);
        btnCaminho.addActionListener(bt);
    }

    public void setTxt(String caminho) {
        txtCaminho.setText(caminho);
    }
}
