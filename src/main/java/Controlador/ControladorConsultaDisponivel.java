/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOConsulta;
import Modelo.ModeloConsulta;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import View.ViewAgendarConsulta;
import View.ViewConsultasDisponiveis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorConsultaDisponivel {
    
    private ViewConsultasDisponiveis viewConsultasDisponivel;
        private ViewAgendarConsulta viewAgendarConsulta;
    private ModeloConsulta modeloConsulta;
    private ModeloConsulta modeloConsultaCopia;
    
    public ControladorConsultaDisponivel() {
        this.viewConsultasDisponivel = new ViewConsultasDisponiveis();
        pesquisaData();
        addChekBox();
        adicionarAcoesBotoes();
    }
    
     public void exibir(){
       viewConsultasDisponivel.exibirTela();
    }  
     
    private void pesquisaData() {
        modeloConsulta = new ModeloConsulta(viewAgendarConsulta.getMedico(), viewAgendarConsulta.getLocalAtendimento(), "", "", "Disponivel");
        modeloConsultaCopia = new ModeloConsulta(null, null, "", "", "");

        DAOConsulta cons= new DAOConsulta();
        if ( cons.pesquisaData(modeloConsulta,modeloConsultaCopia)) {
                   DAOConsulta consDAO= new DAOConsulta();

            //for( ModeloConsulta mod:this.consDAO.getConsultaCopia){
            //aqui seria um for para listar as consultas disponiveis e o usuario escolher qual quer.
            //Porem acho que precisa fazer em outra teli com um checbox
            //}
        }
    }
     
     
     public void addChekBox(){
         viewConsultasDisponivel.cbx1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
         
         viewConsultasDisponivel.cbx1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
         
         viewConsultasDisponivel.cbx1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
         
         viewConsultasDisponivel.cbx1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
         
         viewConsultasDisponivel.cbx1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
         
         viewConsultasDisponivel.cbx1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
         
     }

    public void adicionarAcoesBotoes(){
         viewConsultasDisponivel.adicionarAcaoMaracarConsulta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //procura a consulta que foi escolhida no combobox e altera 
               //o status pra indisponivel e adiciona nas consultas agendadas
            }
        });

        viewConsultasDisponivel.adicionarAcaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorAgendarConsulta cont = new ControladorAgendarConsulta();
                cont.exibir();

                viewConsultasDisponivel.setVisible(false);
            }
        });
    }
}
