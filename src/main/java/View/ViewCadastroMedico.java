package View;

import Modelo.ModeloEspecialidade;
import java.awt.event.ActionListener;

public class ViewCadastroMedico extends javax.swing.JFrame {

    public ViewCadastroMedico() {
        initComponents();
    }

    public void adicionaAcaoCadastrar(ActionListener acao) {
        btCadastrar.addActionListener(acao);
    }

    public void adicionaAcaoVoltar(ActionListener acao) {
        btVoltar.addActionListener(acao);
    }

    public String getNome() {
        return tfNome.getText();
    }

    public String getTelefone() {
        return tfTelefone.getText();
    }

    public String getRg() {
        return tfRg.getText();
    }

    public ModeloEspecialidade getEspecialidade() {
        return (ModeloEspecialidade) cbEspecialidade.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        lbTelefone = new javax.swing.JLabel();
        lbRg = new javax.swing.JLabel();
        lbEspecialidade = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        tfRg = new javax.swing.JTextField();
        cbEspecialidade = new javax.swing.JComboBox<>();
        btCadastrar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbNome.setText("Nome");

        lbTelefone.setText("Telefone");

        lbRg.setText("RG");

        lbEspecialidade.setText("Especialidade");

        btCadastrar.setText("Cadastrar");

        btVoltar.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbRg)
                                    .addComponent(lbEspecialidade)
                                    .addComponent(lbTelefone)
                                    .addComponent(lbNome)
                                    .addComponent(tfNome)
                                    .addComponent(tfTelefone)
                                    .addComponent(tfRg)
                                    .addComponent(cbEspecialidade, 0, 201, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(btCadastrar)))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btVoltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbRg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbEspecialidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewCadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadastroMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<ModeloEspecialidade> cbEspecialidade;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbEspecialidade;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbRg;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfRg;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}