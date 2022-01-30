package Controlador;

import DAO.DAOUsuario;
import Modelo.ModeloUsuario;
import View.ViewCadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorCadastro {

    private ViewCadastro viewCadastro;
    private ModeloUsuario modeloUsuario;

    public ControladorCadastro() {
        this.viewCadastro = new ViewCadastro();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       viewCadastro.exibirTela();
    }

    private void adicionarAcoesBotoes(){
        viewCadastro.addAcaoBotaoCriarConta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastraUsuario();
            }
        });

        viewCadastro.addAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCadastro.setVisible(false);

                ControladorLogin controlador = new ControladorLogin();
                controlador.exibir();
            }
        });
    }

    public void cadastraUsuario() {
        modeloUsuario = new ModeloUsuario(viewCadastro.getEstado(), viewCadastro.getCidade(), viewCadastro.getNomeCompleto(), viewCadastro.getCPF(), viewCadastro.getCelular(), viewCadastro.getDataNascimento(), viewCadastro.getSexo(), viewCadastro.getEmail(), viewCadastro.getSenha());

        if (validarUsuario()) {
            DAOUsuario dao = new DAOUsuario();
            //if (dao.gravar(modeloUsuario)) {
            if (dao.insere(modeloUsuario)) {
                viewCadastro.exibirMensagem("Usuario criado com sucesso. ");
                viewCadastro.limpaTela();
            }
        }
        else {
            viewCadastro.exibirMensagem("Algum campo esta em branco ou preenchido incorretamente! ");
        }
    }

    public boolean validarUsuario() {
        if (this.viewCadastro.getEstado().equals(""))
            return false;
        if (this.viewCadastro.getCidade().equals(""))
            return false;
        if (this.viewCadastro.getNomeCompleto().equals(""))
            return false;
        if (this.viewCadastro.getCPF().equals(""))
            return false;
        if (this.viewCadastro.getCelular().equals(""))
            return false;
        if (this.viewCadastro.getDataNascimento().equals(""))
            return false;
        if (this.viewCadastro.getSexo().equals(""))
            return false;
        if (this.viewCadastro.getEmail().equals(""))
            return false;
        if (this.viewCadastro.getSenha().equals(""))
            return false;
        return true;
    }

}
