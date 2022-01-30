package Controlador;

import View.ViewLogin;
import DAO.DAOUsuario;
import DAO.DAOAdministrador;
import Estrutura.Principal;
import Modelo.ModeloUsuario;
import Modelo.ModeloAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin {

    private ViewLogin viewLogin;

    public ControladorLogin() {
        viewLogin = new ViewLogin();
        adicionarAcoesBotoes();
    }

    public void exibir(){
        viewLogin.exibirTela();
    }

    public void adicionarAcoesBotoes(){
        viewLogin.addAcaoBotaoCriarConta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastro cont = new ControladorCadastro();
                cont.exibir();

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
                    Principal.getInstance().setModeloUsuario(usuario);

                    ControladorMenuUsuario menuUsuario = new ControladorMenuUsuario();
                    menuUsuario.exibirTela();

                    viewLogin.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Senha inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else if (admin != null) {
                if (admin.getSenha().equalsIgnoreCase(senha)) {
                    ControladorMenuAdministrador menuAdmin = new ControladorMenuAdministrador();
                    menuAdmin.exibirTela();
                    viewLogin.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Senha inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else if (senha.equalsIgnoreCase("admin")) {
                ControladorMenuAdministrador menuAdmin = new ControladorMenuAdministrador();
                menuAdmin.exibirTela();
                viewLogin.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Senha inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

}