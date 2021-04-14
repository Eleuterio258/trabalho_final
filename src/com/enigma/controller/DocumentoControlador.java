package com.enigma.controller;

import com.enigma.model.Documento;
import com.enigma.dao.DocumentoDAO;
import com.enigma.view.admin.FormDocumento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DocumentoControlador implements ActionListener {

    DocumentoDAO dao = new DocumentoDAO();
    Documento p = new Documento();
    FormDocumento dashboard = new FormDocumento();
    DefaultTableModel modelo = new DefaultTableModel();

    public DocumentoControlador(FormDocumento v) {
        this.dashboard = v;
        this.dashboard.btnListar.addActionListener(this);
        this.dashboard.btnGuardar.addActionListener(this);
        this.dashboard.btnEditar.addActionListener(this);
        this.dashboard.btnExcluir.addActionListener(this);
        this.dashboard.btnAtualizar.addActionListener(this);
        this.dashboard.btnNovo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboard.btnListar) {
            cleanTable();
            listar(dashboard.tabla);
            novo();
        }
        if (e.getSource() == dashboard.btnGuardar) {
            add();
            listar(dashboard.tabla);
            novo();
        }
        if (e.getSource() == dashboard.btnEditar) {
            int fila = dashboard.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(dashboard, "Você deve selecionar uma linha .. !!");
            } else {
                int id = Integer.parseInt((String) dashboard.tabla.getValueAt(fila, 0).toString());
                String nome = (String) dashboard.tabla.getValueAt(fila, 1);
                String pro = (String) dashboard.tabla.getValueAt(fila, 2);
                String email = (String) dashboard.tabla.getValueAt(fila, 3);
                int tipo = Integer.parseInt((String) dashboard.tabla.getValueAt(fila, 4));

                dashboard.txtId.setText("" + id);
                dashboard.txtNome.setText(nome);
                dashboard.txtPropretaria.setText(pro);
                dashboard.btnGuardar.setVisible(false);
            }
        }
        if (e.getSource() == dashboard.btnAtualizar) {
            actualizar();
            listar(dashboard.tabla);
            novo();
            dashboard.btnGuardar.setVisible(true);

        }
        if (e.getSource() == dashboard.btnExcluir) {
            delete();
            listar(dashboard.tabla);
            novo();
        }
        if (e.getSource() == dashboard.btnNovo) {
            novo();
            dashboard.btnGuardar.setVisible(true);
        }

    }

    void novo() {
        dashboard.txtId.setText("");
        dashboard.txtNome.setText("");
        dashboard.txtPropretaria.setText("");
        dashboard.comboTipo.setSelectedItem(0);
        dashboard.txtNome.requestFocus();
    }

    public void delete() {
        int fila = dashboard.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(dashboard, "Você deve selecionar uma linha ... !!!");
        } else {
            int id = Integer.parseInt((String) dashboard.tabla.getValueAt(fila, 0).toString());
            dao.delete(id);
            System.out.println("O resultado é" + id);
            JOptionPane.showMessageDialog(dashboard, "Documento excluído ... !!!");
        }
        cleanTable();
    }

    public void add() {
        String nome = dashboard.txtNome.getText();
        String propretaria = dashboard.txtPropretaria.getText();
        String senha = dashboard.txtPropretaria.getText();

        p.setEstado(0);

        int r = dao.create(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(dashboard, "Documento adicionado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(dashboard, "Error");
        }
        cleanTable();
    }

    public void actualizar() {
        if (dashboard.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(dashboard, "O ID não é identificado você deve selecionar a opção Editar");
        } else {
            int id = Integer.parseInt(dashboard.txtId.getText());
            String nome = dashboard.txtNome.getText();

            String senha = dashboard.txtPropretaria.getText();

            int r = dao.update(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(dashboard, "Documento atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(dashboard, "Error");
            }
        }
        cleanTable();
    }

    public void listar(JTable tabla) {
        centercells(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Documento> lista = dao.list();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNome();
            objeto[2] = lista.get(i).getValidade();
            objeto[3] = lista.get(i).getProprietario();

            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }

    void centercells(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < dashboard.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    void cleanTable() {
        for (int i = 0; i < dashboard.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
