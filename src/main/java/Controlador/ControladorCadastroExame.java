/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOExame;
import Modelo.ModeloExame;
import View.ViewCadastroExame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorCadastroExame {

    private ViewCadastroExame view;
    private ModeloExame modeloExame;

    public ControladorCadastroExame() {
        this.view = new ViewCadastroExame();
        popularCB();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       view.exibir();
    }

    public void popularCB(){
       view.populaExame();
       view.populaLocal();
    }

    public void adicionarAcoesBotoes(){
        view.adicionaAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastraConsulta();
            }
        });

        view.adicionarAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuAdministrador cont = new ControladorMenuAdministrador();
                cont.exibirTela();

                view.setVisible(false);
            }
        });
    }

    private void cadastraConsulta() {
        modeloExame = new ModeloExame(view.getExame(), view.getlocalAtendimento(), view.getHora(), view.getData(), "Disponivel");
        if (verificaPreenchimento()) {
            DAOExame exame = new DAOExame();
            exame.gravar(modeloExame);
            view.limpaTela();
            view.exibirMensagem("Exame criado com sucesso: \n"+ modeloExame);
        }
        else {
            view.exibirMensagem("Algum campo esta em branco ou preenchido incorretamente! ");
        }
    }

    private boolean verificaPreenchimento() {
        if (view.getExame()== null)
            return false;
        if (view.getlocalAtendimento()== null)
            return false;

        if (view.getData().isEmpty())
            return false;
        if (view.getHora().isEmpty())
            return false;

        return true;
    }
}
