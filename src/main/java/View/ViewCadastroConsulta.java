package View;

import DAO.DAOLocalAtendimento;
import DAO.DAOMedico;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class ViewCadastroConsulta extends javax.swing.JFrame {

   private DAOMedico medicoDAO;
   private DAOLocalAtendimento localDAO;

    public ViewCadastroConsulta() {
        initComponents();

        this.setLocationRelativeTo(null);
    }

    public void adicionaAcaoBotaoCadastrar(ActionListener acao){
        btCadastrar.addActionListener(acao);
    }

    public void adicionarAcaoBotaoVoltar(ActionListener acao) {
        btVoltar.addActionListener(acao);
    }

    public void exibir() {
        this.setVisible(true);
    }

    public ModeloMedico getMedico(){
        ModeloMedico medico = cbMedico.getItemAt(cbMedico.getSelectedIndex());
        return medico;
    }

    public ModeloLocalAtendimento getlocalAtendimento(){
        ModeloLocalAtendimento local = cbLocal.getItemAt(cbLocal.getSelectedIndex());
        return local;
    }

    public String getData() {
        String data = tfData.getText();

        return data;
    }

    public String getHora() {
        String hora = tfHora.getText();

        return hora;
    }

    public void populaMedico(){
        for(ModeloMedico med:this.medicoDAO.getMedico()){
            cbMedico.addItem(med);
        }
    }

    public void populaLocal(){
        for(ModeloLocalAtendimento local:this.localDAO.getLocalAtendimento()){
            cbLocal.addItem(local);
        }
    }

    public void limpaTela(){
        this.tfData.setText("");
        this.tfHora.setText("");
    }

    public void limpaCB() {
        cbLocal.removeAllItems();
        cbMedico.removeAllItems();
    }

    public void exibirMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        lbData = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        cbMedico = new javax.swing.JComboBox<>();
        cbLocal = new javax.swing.JComboBox<>();
        tfData = new javax.swing.JFormattedTextField();
        tfHora = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adiciona Dados");

        jLabel3.setText("Posto de atendimento:");

        jLabel4.setText("Médico");

        btCadastrar.setText("Cadastrar");

        btVoltar.setText("Voltar");

        lbData.setText("Data");

        lbHora.setText("Hora");

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btVoltar)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbData)
                                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbHora)
                                    .addComponent(tfHora))))
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbData)
                    .addComponent(lbHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadastroConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<ModeloLocalAtendimento> cbLocal;
    private javax.swing.JComboBox<ModeloMedico> cbMedico;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHora;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JFormattedTextField tfHora;
    // End of variables declaration//GEN-END:variables
}
