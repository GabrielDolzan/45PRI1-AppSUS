package Controlador;

import DAO.DAOTipoExame;
import Modelo.ModeloTipoExame;
import View.ViewCadastroTipoExame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCadastroTipoExame {

    private ViewCadastroTipoExame view;

    public ControladorCadastroTipoExame() {
        view = new ViewCadastroTipoExame();
        adicionaAcoes();
    }

    private void adicionaAcoes() {
        view.adicionarAcaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insere();
            }
        });

        view.adicionarAcaoSair(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuAdministrador cont = new ControladorMenuAdministrador();
                cont.exibirTela();

                view.setVisible(false);
            }
        });
    }

    private void insere() {
        String descricao = view.getDescricao();

        ModeloTipoExame ex = new ModeloTipoExame(descricao);

        if(!descricao.equals("")){
            DAOTipoExame dao = new DAOTipoExame();
            //if (dao.gravar(ex)) {
            if (dao.insere(ex)) {
                view.exibirMensagem("Exame cadastrado com sucesso. ");
                view.limpaTela();
            }
        }
        else {
            view.exibirMensagem("O campo esta em branco ou preenchido incorretamente! ");
        }
    }

    public void exibir() {
        view.setVisible(true);
    }
}
