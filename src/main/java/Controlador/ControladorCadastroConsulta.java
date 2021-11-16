/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloConsulta;
import View.ViewCadastroConsulta;
import View.ViewMenuUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorCadastroConsulta {
    
    //private ViewAgendaConsulta viewAgendaConsulta;
    private ViewMenuUsuario viewMenuUsuario;
    private ModeloConsulta modeloConsulta;
    
    private ViewCadastroConsulta viewCadastroConsulta;
    
    public ControladorCadastroConsulta(ViewMenuUsuario viewMenuUsuario, ViewCadastroConsulta viewCadastroConsulta, ModeloConsulta modeloConsulta) {
        this.viewCadastroConsulta = viewCadastroConsulta;
        this.modeloConsulta =modeloConsulta;
        this.viewMenuUsuario = viewMenuUsuario;
        //adicionarAcoesBotoes();
        inicializarAcaoBotaoCadastraConsulta();
    }
    
    public void exibir(){
       viewCadastroConsulta.exibirTela();
    }
       
//    public void adicionarAcoesBotoes(){
//        viewCadastroConsulta.addAcaoBotaoCadastraData(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                    pesquisaConsulta();
//                    viewCadastroConsulta.exibirMensagem("Consulta XXXX");
//            }
//        });
//    }
    
    public void inicializarAcaoBotaoCadastraConsulta() {
        viewCadastroConsulta.addAcaoBotaoCadastraData(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                viewCadastroConsulta.exibirTela();
            }
        });
    }
    
    public void pesquisaConsulta(){
        //comparar com os dados salvos do admin
    }
   

    public ViewCadastroConsulta getViewCadastroConsulta() {
        return viewCadastroConsulta;
    } 
}
