package com.johns.backup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Principal extends JPanel {
    private JLabel lblCaminho;
    private JTextField txtCaminho;
    private JButton btnCaminho;

    public Principal() {
        lblCaminho = new JLabel("Diretorio");
        txtCaminho = new JTextField("",40);
        btnCaminho = new JButton("Procurar");
        JPanel pnlCaminho = new JPanel(new FlowLayout());
        pnlCaminho.add(lblCaminho);
        pnlCaminho.add(txtCaminho);
        pnlCaminho.add(btnCaminho);

        setLayout(new BorderLayout());
        add(pnlCaminho, BorderLayout.CENTER);

        FileButtonHandler bt = new FileButtonHandler(this);
        btnCaminho.addActionListener(bt);
    }

    public void setTxt(String caminho){
        txtCaminho.setText(caminho);
    }
}
