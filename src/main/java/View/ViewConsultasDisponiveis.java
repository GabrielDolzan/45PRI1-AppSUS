/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ViewConsultasDisponiveis extends javax.swing.JFrame {

    /**
     * Creates new form ViewConsultasDisponiveis
     */
    public ViewConsultasDisponiveis() {
        initComponents();    
        this.setLocationRelativeTo(null);

        
    }

    public void adicionarAcaoMaracarConsulta(ActionListener acao) {
        btMarcaConsulta.addActionListener(acao);
    }
    
    public void adicionarAcaoVoltar(ActionListener acao) {
        btVoltar.addActionListener(acao);
    }

    public void textChekBox(String text){
        cbx1.setText(text);
        cbx2.setText(text);
        cbx3.setText(text);
        cbx4.setText(text);
        cbx5.setText(text);
        cbx6.setText(text);

        

                
    }
    public void cbx1(ActionListener acao) {
        cbx1.addActionListener(acao);
        cbx1.setSelected(false);
    }
    
    public void cbx2(ActionListener acao) {
        cbx2.addActionListener(acao);
        cbx2.setSelected(false);
    }
    public void cbx3(ActionListener acao) {
        cbx3.addActionListener(acao);
        cbx3.setSelected(false);
    }
    public void cbx4(ActionListener acao) {
        cbx4.addActionListener(acao);
    }
    public void cbx5(ActionListener acao) {
        cbx5.addActionListener(acao);
    }
    public void cbx6(ActionListener acao) {
        cbx6.addActionListener(acao);
    }
    public void exibirTela() {
        this.setVisible(true);
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbx1 = new javax.swing.JCheckBox();
        cbx2 = new javax.swing.JCheckBox();
        cbx3 = new javax.swing.JCheckBox();
        cbx5 = new javax.swing.JCheckBox();
        cbx4 = new javax.swing.JCheckBox();
        cbx6 = new javax.swing.JCheckBox();
        btMarcaConsulta = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Selecione dia e hora desejado");

        cbx1.setText("jCheckBox1");
        cbx1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx1ActionPerformed(evt);
            }
        });

        cbx2.setText("jCheckBox1");
        cbx2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx2ActionPerformed(evt);
            }
        });

        cbx3.setText("jCheckBox1");
        cbx3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx3ActionPerformed(evt);
            }
        });

        cbx5.setText("jCheckBox1");

        cbx4.setText("jCheckBox1");

        cbx6.setText("jCheckBox1");

        btMarcaConsulta.setText("Marcar Consulta");

        btVoltar.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx3)
                            .addComponent(cbx1)
                            .addComponent(cbx5)
                            .addComponent(cbx2)
                            .addComponent(cbx4)
                            .addComponent(cbx6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btMarcaConsulta)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbx1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbx2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbx3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbx4)
                .addGap(4, 4, 4)
                .addComponent(cbx5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbx6)
                .addGap(47, 47, 47)
                .addComponent(btMarcaConsulta)
                .addGap(48, 48, 48)
                .addComponent(btVoltar)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx1ActionPerformed
        cbx2.setText("oi");
        cbx2.setSelected(true);
    }//GEN-LAST:event_cbx1ActionPerformed

    private void cbx2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx2ActionPerformed
        cbx3.setText("oie");
        cbx3.setSelected(true);
    }//GEN-LAST:event_cbx2ActionPerformed

    private void cbx3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx3ActionPerformed
        cbx1.setText("tchau");
        cbx1.setSelected(false);
    }//GEN-LAST:event_cbx3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewConsultasDisponiveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewConsultasDisponiveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewConsultasDisponiveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewConsultasDisponiveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewConsultasDisponiveis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMarcaConsulta;
    private javax.swing.JButton btVoltar;
    private javax.swing.JCheckBox cbx1;
    private javax.swing.JCheckBox cbx2;
    private javax.swing.JCheckBox cbx3;
    private javax.swing.JCheckBox cbx4;
    private javax.swing.JCheckBox cbx5;
    private javax.swing.JCheckBox cbx6;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}