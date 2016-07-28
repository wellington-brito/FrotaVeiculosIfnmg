/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.wellington.apresentacao;

import br.edu.ifnmg.wellington.entidade.Habilitacao;
import br.edu.ifnmg.wellington.entidade.Motorista;
import br.edu.ifnmg.wellington.exception.CampoObrigatorioException;
import br.edu.ifnmg.wellington.exception.VerificarVeiculoDuplicado;
import br.edu.ifnmg.wellington.negocio.HabilitacaoBO;
import br.edu.ifnmg.wellington.negocio.MotoristaBO;
import br.edu.ifnmg.wellington.negocio.VeiculoBO;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Were
 */
public class FormAddMotorista extends javax.swing.JFrame {

    private Home home;
    private Motorista motoristaEmEdicao;
    private MotoristaBO motoristaBO;
    int flagEditarMotorista = 0;
    List<Habilitacao> habilitacoes;
    String item = " ";

    public FormAddMotorista(Home home) throws SQLException {
        this.home = home;
        initComponents();
        this.carregaComboHabilitacao();
    }

    public FormAddMotorista(Motorista m, Home home, int flag) throws SQLException {
        this.home = home;
        this.motoristaEmEdicao = m;
        this.flagEditarMotorista = flag;
        initComponents();
        this.carregaComboHabilitacao();
        this.preencherCamposTela(motoristaEmEdicao);
    }

    public FormAddMotorista() throws SQLException {
        initComponents();
        this.carregaComboHabilitacao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalvarMotorista = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lblTipoHabilitacao = new javax.swing.JLabel();
        txtNomeMotorista = new javax.swing.JTextField();
        cbxTipoHabilitacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Motorista");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motoristas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Nome:");

        btnSalvarMotorista.setText("Salvar");
        btnSalvarMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarMotoristaActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lblTipoHabilitacao.setText("Habilitação");

        cbxTipoHabilitacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvarMotorista))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblTipoHabilitacao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxTipoHabilitacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoHabilitacao)
                    .addComponent(cbxTipoHabilitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarMotorista)
                    .addComponent(btnVoltar))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarMotoristaActionPerformed
        if (flagEditarMotorista != 1) {
            try {
                this.incluirMotorista();
                this.home.carregarTabelaDeMotorista();
            } catch (SQLException ex) {
                Logger.getLogger(FormAddVeiculo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FormAddMotorista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(FormAddMotorista.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.editarMotorista();
            } catch (SQLException ex) {
                Logger.getLogger(FormAddMotorista.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.flagEditarMotorista = 0;
        }
    }//GEN-LAST:event_btnSalvarMotoristaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.limparCamposTelaNovoMotorista();
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvarMotorista;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbxTipoHabilitacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTipoHabilitacao;
    private javax.swing.JTextField txtNomeMotorista;
    // End of variables declaration//GEN-END:variables

    private void preencherCamposTela(Motorista motoristaEmEdicao) {
        this.txtNomeMotorista.setText(motoristaEmEdicao.getNome());
        this.cbxTipoHabilitacao.setSelectedItem(motoristaEmEdicao.getTipoHabilitacao());

    }

    private void incluirMotorista() throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {
        try {
            this.motoristaBO = new MotoristaBO();
            this.getItemComboHabiliatacao(cbxTipoHabilitacao.getSelectedItem().toString());
            this.recuperarCamposTelaMotorista();
            this.motoristaBO.incluirMotorista(this.motoristaEmEdicao);
            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!", "Novo Motorista", JOptionPane.INFORMATION_MESSAGE);
            this.limparCamposTelaNovoMotorista();

        } catch (CampoObrigatorioException c) {
            String mensagen = "Por favor, Preencha todos os campos!\n" + c.getMessage();
            JOptionPane.showMessageDialog(this, mensagen, "Novo Motorista", JOptionPane.ERROR_MESSAGE);
        } catch (VerificarVeiculoDuplicado v) {
            JOptionPane.showMessageDialog(this, v.getMessage(), "Novo Motorista", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarMotorista() throws SQLException {
        try {
            this.motoristaBO = new MotoristaBO();
            int i = JOptionPane.showConfirmDialog(this, "Tem Certeza?", "Edição de Motorista", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.NO_OPTION) {
                this.dispose();
            } else {
                this.getItemComboHabiliatacao(cbxTipoHabilitacao.getSelectedItem().toString());
                this.recuperarCamposTelaMotorista();
                this.motoristaBO.atualizarMotorista(motoristaEmEdicao);
                JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Edição de Motorista", JOptionPane.INFORMATION_MESSAGE);
                this.limparCamposTelaNovoMotorista();
                this.home.carregarTabelaDeMotorista();
                this.dispose();
                // this.veiculoEmEdicao = null;
            }
        } catch (RuntimeException r) {
            JOptionPane.showMessageDialog(this, "algum campo está vazio", "Edição de Motorista", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void limparCamposTelaNovoMotorista() {
        this.txtNomeMotorista.setText("");
        this.cbxTipoHabilitacao.setSelectedIndex(0);
    }

    private void recuperarCamposTelaMotorista() {
        if (this.motoristaEmEdicao == null) {
            this.motoristaEmEdicao = new Motorista();
        }

        if (txtNomeMotorista.getText().equals("")) {
            throw new CampoObrigatorioException("Campo NOME vazio!");
        } else {
            this.motoristaEmEdicao.setNome(txtNomeMotorista.getText());
        }

        if (cbxTipoHabilitacao.getSelectedItem().equals("--")) {
            throw new CampoObrigatorioException("Selecione o tipo de habilitação");
        } else {
            int posicaoSelecionada = 0;
            for (Habilitacao h : habilitacoes) {
                if (h.getNome().equals(item)) {
                    posicaoSelecionada = h.getId();
                    motoristaEmEdicao.setTipoHabilitacao(posicaoSelecionada);
                }
            }
        }
    }

    private void carregaComboHabilitacao() throws SQLException {
        this.habilitacoes = new ArrayList<>();
        HabilitacaoBO habilitacaoBO = new HabilitacaoBO();
        this.habilitacoes = habilitacaoBO.buscarHabilitacoes();
        this.cbxTipoHabilitacao.removeAllItems();
        this.cbxTipoHabilitacao.addItem("--");
        for (Habilitacao h : this.habilitacoes) {
            this.cbxTipoHabilitacao.addItem(h.getNome());
        }
    }

    private void getItemComboHabiliatacao(String toString) {
        this.item = toString;
    }

}