package Controlador;

import DAO.DAOConsulta;
import Modelo.ModeloConsulta;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import View.ViewAgendarConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAgendarConsulta {

    private ViewAgendarConsulta viewAgendarConsulta;
    private ModeloConsulta modeloConsulta;
    private ModeloConsulta modeloConsultaCopia;
    private DAOConsulta consDAO;

    public ControladorAgendarConsulta() {
        this.viewAgendarConsulta = new ViewAgendarConsulta();
        viewAgendarConsulta.limparCB();
        popularCB();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       viewAgendarConsulta.exibirTela();
    }

    public void popularCB(){
       viewAgendarConsulta.popularMedicos();
       viewAgendarConsulta.popularPostoAtendimento();
    }

    public void adicionarAcoesBotoes(){
         viewAgendarConsulta.addAcaoBotaoPesquisaData(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ControladorConsultaDisponivel con = new ControladorConsultaDisponivel();
                con.exibir();
                  
                viewAgendarConsulta.setVisible(false);

                }
        });

        viewAgendarConsulta.adicionarAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuUsuario cont = new ControladorMenuUsuario();
                cont.exibirTela();

                viewAgendarConsulta.setVisible(false);
            }
        });
    }
    
    

    
}
