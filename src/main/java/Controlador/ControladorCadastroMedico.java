package Controlador;

import DAO.DAOMedico;
import Modelo.ModeloMedico;
import View.ViewCadastroMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCadastroMedico {

    private ViewCadastroMedico view;
    private ModeloMedico medico;

    public ControladorCadastroMedico() {
        view = new ViewCadastroMedico();
        view.limparCB();
        popularCB();
        adicionaAcoes();
    }

    public void popularCB(){
       view.populaEspecialidade();
    }

    private void adicionaAcoes() {
        view.adicionaAcaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insere();
            }
        });

        view.adicionaAcaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuAdministrador cont = new ControladorMenuAdministrador();
                cont.exibirTela();

                view.setVisible(false);
            }
        });
    }

    private void insere() {
         if (validarMedico()) {
            medico = new ModeloMedico(view.getNome(), view.getEspecialidade(), view.getTelefone(), view.getRg());
            DAOMedico dao = new DAOMedico();
            if (dao.gravar(medico)) {
                view.exibirMensagem("Médico cadastrado com sucesso. ");
                view.limpaTela();
            }
        }
        else {
            view.exibirMensagem("Algum campo esta em branco ou preenchido incorretamente! ");
        }
    }

    public boolean validarMedico() {
        if (this.view.getNome().equals(""))
            return false;
        if (this.view.getRg().equals(""))
            return false;
        if (this.view.getTelefone().equals(""))
            return false;
        if (this.view.getEspecialidade() == null)
            return false;

        return true;
    }

    public void exibir() {
        view.setVisible(true);
    }

}