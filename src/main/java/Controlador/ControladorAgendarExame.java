/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOConsulta;
import Modelo.ModeloConsulta;
import View.ViewAgendarConsulta;
import View.ViewAgendarExame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorAgendarExame {
    
     private ViewAgendarExame viewAgendarExame;
    private ModeloConsulta modeloConsulta;
    private ModeloConsulta modeloConsultaCopia;
    private DAOConsulta consDAO;
    
    public ControladorAgendarExame() {
        this.viewAgendarExame = new ViewAgendarExame();
        viewAgendarExame.limparCB();
        popularCB();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       viewAgendarExame.exibirTela();
    }

    public void popularCB(){
       viewAgendarExame.popularExame();
       viewAgendarExame.popularPostoAtendimento();
    }

    public void adicionarAcoesBotoes(){
         viewAgendarExame.addAcaoBotaoPesquisaData(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //ControladorExameDisponivel con = new ControladorExameDisponivel();
               // con.exibir();
                  
                viewAgendarExame.setVisible(false);

                }
        });

        viewAgendarExame.adicionarAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuUsuario cont = new ControladorMenuUsuario();
                cont.exibirTela();

                viewAgendarExame.setVisible(false);
            }
        });
    }
}
