package Controlador;

import DAO.DAOEspecialidade;
import Modelo.ModeloEspecialidade;
import View.ViewCadastroEspecialidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCadastroEspecialidade {

    private ViewCadastroEspecialidade view;

    public ControladorCadastroEspecialidade() {
        view = new ViewCadastroEspecialidade();
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

        ModeloEspecialidade esp = new ModeloEspecialidade(descricao);

        if(!descricao.equalsIgnoreCase("")){
            DAOEspecialidade dao = new DAOEspecialidade();
            //if(dao.gravar(esp)){
            if(dao.insere(esp)){
                view.exibirMensagem("Especialidade cadastrada com sucesso. ");
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
