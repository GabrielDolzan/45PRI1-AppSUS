/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import View.ViewConsultasDisponiveis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorConsultaDisponivel {
    
    private ViewConsultasDisponiveis viewConsultasDisponivel;
    
    public ControladorConsultaDisponivel() {
        this.viewConsultasDisponivel = new ViewConsultasDisponiveis();
        addChekBox();
        adicionarAcoesBotoes();
    }
    
     public void exibir(){
       viewConsultasDisponivel.exibirTela();
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
