package Controlador;

import DAO.DAOAdministrador;
import DAO.DAOUsuario;
import Modelo.ModeloAdministrador;
import Modelo.ModeloUsuario;
import View.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ControladorLogin {

    private ViewLogin viewLogin;
    private ControladorCadastro controladorCadastro;

    public ControladorLogin() {
        viewLogin = new ViewLogin();
        adicionarAcoesBotoes();
        inicializarAgendaConsulta();
    }

    public void exibir(){
        viewLogin.exibirTela();
    }

    public void adicionarAcoesBotoes(){
        viewLogin.addAcaoBotaoCriarConta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorCadastro.exibir();

                viewLogin.setVisible(false);
            }
        });

        viewLogin.addAcaoBotaoLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificaUsuario();
            }
        });

    }

    public void verificaUsuario() {
        String cpf = viewLogin.getCpf();
        String senha = viewLogin.getSenha();

        if (!cpf.isEmpty() && !senha.isEmpty()) {
            DAOUsuario DaoUsu = new DAOUsuario();
            DAOAdministrador DaoAdmin = new DAOAdministrador();

            ModeloUsuario usuario = DaoUsu.getUsuario(cpf);
            ModeloAdministrador admin = DaoAdmin.getAdministrador(cpf);

            if (usuario != null) {
                if (usuario.getSenha().equalsIgnoreCase(senha)) {
                    viewLogin.abrirMenuUsuario();
                    viewLogin.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Senha inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else if (admin != null) {
                if (admin.getSenha().equalsIgnoreCase(senha)) {
                    viewLogin.abrirMenuAdmin();
                    viewLogin.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Senha inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else if (senha.equalsIgnoreCase("admin")) {
                viewLogin.abrirMenuAdmin();
                viewLogin.setVisible(false);
            }
        }
    }

    public void inicializarAgendaConsulta() {
        controladorCadastro = new ControladorCadastro();
    }

}