package com.johns.backup.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.johns.Delay.Delay;
import com.johns.Propriedades;
import com.johns.backup.Gravador;
import com.johns.backup.gui.table.Item;
import com.johns.backup.gui.table.ModelTabel;
import com.johns.log.Log;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Principal extends JPanel {
    private JLabel lblCaminho, lblDestino;
    private JTextField txtCaminho, txtDestino;
    private JButton btnCaminho, btnBackup, btnDestino, btnRemove;
    private JTable tabela;
    private ModelTabel modelo;
    private JScrollPane sPainel;
    private JProgressBar progress;
    private int incrementa;


    public Principal() {
        lblCaminho = new JLabel("Diretorio");
        txtCaminho = new JTextField("", 40);
        btnCaminho = new JButton("Procurar");
        btnRemove = new JButton("-");
        JPanel pnlCaminho = new JPanel(new FlowLayout());
        pnlCaminho.add(lblCaminho);
        pnlCaminho.add(txtCaminho);
        pnlCaminho.add(btnCaminho);
        pnlCaminho.add(btnRemove);
        pnlCaminho.setMaximumSize(new Dimension(100, 1000));
        incrementa = 0;

        btnDestino = new JButton("Destino");
        lblDestino = new JLabel("Destino");
        txtDestino = new JTextField("", 30);
        Font font1 = new Font("SansSerif", Font.TRUETYPE_FONT, 10);
        txtDestino.setFont(font1);


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
        btnBackup.addActionListener(bt);
        btnDestino.addActionListener(bt);
        btnRemove.addActionListener(bt);
        lerArquivoLista();

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

    public String getTxtDestino() {
        return txtDestino.getText();
    }

    public List<Item> getItens() {

        return modelo.getItens();
    }

    public void removeItem (){
        if(tabela.getSelectedRow() >= 0) {
            modelo.removeItem(tabela.getSelectedRow());
        }
        gravar();
    }

    public void lerArquivoLista(){
        Gravador gravador = new Gravador();
        List<String> lista = gravador.getLista();
        for(String item : lista){
            modelo.insertRow(item);
        }

        Propriedades prop = new Propriedades();
        setTxtDestino(prop.getProp("diretorio"));
    }

    public void gravar(){
        Gravador gravador = new Gravador();
        List<Item> itemGravar = modelo.getItens();
        gravador.limpar();;
        for(Item itemTemp : itemGravar){
            try {
                gravador.gravar(itemTemp.getDiretorio());
            } catch (IOException e){
                Log.gravar("Principal: Nao foi possivel gravar caminho no arquivo " + e);
            }
        }
    }

}
