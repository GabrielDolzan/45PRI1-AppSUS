package Controlador;

import DAO.DAOConsulta;
import Modelo.Modelo.Tabelas.TabelaConsulta;
import View.ViewTodosAgendamentosUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTodosAgendamentosUsuario {

    private ViewTodosAgendamentosUsuario viewAgendamentos;
    private TabelaConsulta consultaTabela;
    

    public ControladorTodosAgendamentosUsuario() {
        this.viewAgendamentos = new ViewTodosAgendamentosUsuario();
        consultaTabela = new TabelaConsulta();
        adicionarAcoesBotoes();
    }

//    public void mostraDadosTabela(){
//        consultaTabela = new TabelaConsulta(DAOConsulta.getConsulta());
//        controladorListarFiliais = new ControladorListarFiliais(new ListaFiliaisView(), tabelaFilial);
//    }  
    
   
    
    public void exibir(){
       viewAgendamentos.exibirTela();
    }

    private void adicionarAcoesBotoes(){
        viewAgendamentos.addAcaoBotaoCancelaConsulta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ExcluirConsulta();
            }
        });

        viewAgendamentos.addAcaoBotaoCancelaExame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                excluirExame();
            }
        });

        viewAgendamentos.addAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAgendamentos.setVisible(false);

                ControladorMenuUsuario controlador = new ControladorMenuUsuario();
                controlador.exibirTela();
            }
        });
    }
}
