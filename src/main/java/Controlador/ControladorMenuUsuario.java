package Controlador;

import Modelo.ModeloConsulta;
import View.ViewAgendaConsulta;
import View.ViewLogin;
import View.ViewMenuUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorMenuUsuario {

    private ViewLogin viewLogin;
    private ViewMenuUsuario viewMenuUsuario;
    
    //Referenete Agenda Consulta
    private ModeloConsulta ModeloConsulta;
    private ControladorAgendaConsulta controladorAgendaConsulta;
    private ControladorCadastroConsulta controladorCadastroConsulta;

     public ControladorMenuUsuario(ViewLogin viewLogin  ) {
        this.viewLogin= viewLogin;
        viewMenuUsuario = new ViewMenuUsuario();
        //mostraDados();
        inicializarAcaoBotoesMenu();
        inicializaCadastros();    

        //atualizarListasAoSalvar();
    }
     
    public void exibirTela() {
        viewMenuUsuario.exibirTela();
    }
     
    public void inicializarAcaoBotoesMenu() {
        viewMenuUsuario.adicionarAcaoAgendaConsulta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controladorAgendaConsulta.exibir();
            }
        });
    }
    
    public void inicializaCadastros(){
        inicializarAgendaConsulta();
       
    }   
    public void inicializarAgendaConsulta() {
        controladorAgendaConsulta = new ControladorAgendaConsulta(new ViewMenuUsuario(),new ViewAgendaConsulta(), new ModeloConsulta("", null, null, "",""));
    }

    
}
    
 
    
  
