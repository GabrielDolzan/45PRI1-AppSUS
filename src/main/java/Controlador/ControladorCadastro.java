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
            if (dao.gravar(modeloUsuario)) {
                viewCadastro.exibirMensagem("Usuario criado com sucesso. ");
                viewCadastro.limpaTela();
            }
        }
        else {
            viewCadastro.exibirMensagem("Algum campo esta em branco ou preenchido incorretamente! ");
        }
    }

    public boolean validarUsuario() {
        if (this.modeloUsuario.getEstado().equals(""))
            return false;
        if (this.modeloUsuario.getCidade().equals(""))
            return false;
        if (this.modeloUsuario.getNome().equals(""))
            return false;
        if (this.modeloUsuario.getCpf().equals(""))
            return false;
        if (this.modeloUsuario.getCelular().equals(""))
            return false;
        if (this.modeloUsuario.getNascimento().equals(""))
            return false;
        if (this.modeloUsuario.getSexo().equals(""))
            return false;
        if (this.modeloUsuario.getEmail().equals(""))
            return false;
        if (this.modeloUsuario.getSenha().equals(""))
            return false;
        return true;
    }

}
