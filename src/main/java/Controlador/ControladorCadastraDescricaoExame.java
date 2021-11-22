/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAODescricaoExame;
import DAO.DAOEspecialidade;
import Modelo.ModeloDescricaoExame;
import Modelo.ModeloEspecialidade;
import Modelo.ModeloExame;
import View.ViewCadastraDescriçaoExame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorCadastraDescricaoExame {
    
    private ViewCadastraDescriçaoExame view;

    public ControladorCadastraDescricaoExame() {
        view = new ViewCadastraDescriçaoExame();
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

        ModeloDescricaoExame ex = new ModeloDescricaoExame(descricao);

        if(!descricao.equals("")){
            DAODescricaoExame dao = new DAODescricaoExame();
            if(dao.gravar(ex)){
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
