/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloConsulta;
import View.ViewAgendaConsulta;
import View.ViewCadastroConsulta;
import View.ViewMenuUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorAgendaConsulta {
    
    private ViewAgendaConsulta viewAgendaConsulta;
    private ViewMenuUsuario viewMenuUsuario;
    private ModeloConsulta modeloConsulta;
    
    private ViewCadastroConsulta viewCadastroConsulta;
    
    public ControladorAgendaConsulta(ViewMenuUsuario viewMenuUsuario, ViewAgendaConsulta viewAgendaConsulta, ModeloConsulta modeloConsulta) {
        this.viewAgendaConsulta = viewAgendaConsulta;
        this.modeloConsulta =modeloConsulta;
        this.viewMenuUsuario = viewMenuUsuario;
       // popularCB();
        adicionarAcoesBotoes();
    }
    
    public void exibir(){
       viewAgendaConsulta.exibirTela();
       
//       viewAgendaConsulta.limparCB();
//       viewAgendaConsulta.popularEspecialidade();
//       viewAgendaConsulta.popularMedico();
//       viewAgendaConsulta.popularPostoAtendimento();
    }
    
    public void popularCB(){
       viewAgendaConsulta.popularEspecialidade();
       viewAgendaConsulta.popularMedico();
       viewAgendaConsulta.popularPostoAtendimento();
    } 
    
    public void adicionarAcoesBotoes(){
        viewAgendaConsulta.addAcaoBotaoPesquisaData(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    pesquisaConsulta();
                    viewCadastroConsulta.exibirTela(); 
            }
        });
    }
    
    public void pesquisaConsulta(){
        //comparar com os dados salvos do admi
    }
   

    public ViewAgendaConsulta getViewAgendaConsulta() {
        return viewAgendaConsulta;
    }   
}
