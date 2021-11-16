/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloEspecialidade;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import View.ViewAdicionaDadosConsultaAdmin;
import View.ViewLogin;
import View.ViewMenuAdministrador;
import com.sun.java.swing.action.ViewMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorMenuAdiministrador {
    private ViewLogin viewLogin;
    private ViewMenuAdministrador viewMenuAdmin;

    //Referenete Agenda Consulta
    //private ModeloConsulta ModeloConsulta;
    private ControladorAdiciondaDadosAdmin controladorAddDados;
 
    public ControladorMenuAdiministrador(ViewLogin viewLogin  ) {
        this.viewLogin= viewLogin;
        viewMenuAdmin = new ViewMenuAdministrador();
        //mostraDados();
        inicializarAcaoBotoesMenu();
        inicializaCadastros();    

        //atualizarListasAoSalvar();
    }
     
    public void exibirTela() {
        viewMenuAdmin.exibirTela();
    }
     
    public void inicializarAcaoBotoesMenu() {
        viewMenuAdmin.adicionarAcaoAddDadosConsulta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controladorAddDados.exibir();
            }
        });
    }
    
    public void inicializaCadastros(){
        inicializarAgendaConsulta();
       
    }   
    public void inicializarAgendaConsulta() {
        controladorAddDados = new ControladorAdiciondaDadosAdmin(new ViewMenuAdministrador(),new ViewAdicionaDadosConsultaAdmin(), new ModeloMedico("", null) , new ModeloEspecialidade("") , new ModeloLocalAtendimento("",""));
    }

}
