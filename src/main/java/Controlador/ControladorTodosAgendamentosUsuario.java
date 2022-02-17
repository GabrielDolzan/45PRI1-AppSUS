package Controlador;

import DAO.DAOConsulta;
import DAO.DAOExame;
import Modelo.Tabelas.TabelaConsulta;
import Modelo.Tabelas.TabelaExame;
import Modelo.ModeloConsulta;
import Modelo.ModeloExame;
import View.ViewTodosAgendamentosUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTodosAgendamentosUsuario {

    private ViewTodosAgendamentosUsuario viewAgendamentos;
    private TabelaConsulta consultaTabela;
    private DAOConsulta daoConsulta;
    private TabelaExame exameTabela;
    private DAOExame daoExame;

    public ControladorTodosAgendamentosUsuario() {
        this.viewAgendamentos = new ViewTodosAgendamentosUsuario();
        consultaTabela = new TabelaConsulta(daoConsulta.getConsultaTabela());
        exameTabela = new TabelaExame(daoExame.getExameTabela());
        setTableModelConsultas();
        setTableModelExames();
        adicionarAcoesBotoes();
    }

    private void setTableModelConsultas(){
        viewAgendamentos.setTableModelConsultas(this.consultaTabela);
    }
    private void setTableModelExames(){
        viewAgendamentos.setTableModelExames(this.exameTabela);
    }

    public void exibir(){
       viewAgendamentos.exibirTela();
    }

    private void adicionarAcoesBotoes(){

        viewAgendamentos.addAcaoBotaoCancelaExame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarExame();
            }
        });

        viewAgendamentos.addAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAgendamentos.setVisible(false);

                ControladorMenuUsuario controlador = new ControladorMenuUsuario();
                controlador.exibirTela();

                viewAgendamentos.setTableModelConsultas(consultaTabela);
            }
        });

        viewAgendamentos.addAcaoBotaoCancelaConsulta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarConsulta();
            }
        });
    }

    public void cancelarConsulta(){
        if (viewAgendamentos.getLinhaConsultaSelecionada() == -1){
            viewAgendamentos.exibirMensagem("Nenhuma consulta selecionada!");
        } else {
            ModeloConsulta consulta = consultaTabela.getConsultas().get(viewAgendamentos.getLinhaConsultaSelecionada());

            if (DAOConsulta.cancelarConsulta(consulta)){
                viewAgendamentos.exibirMensagem("Consulta cancelada com sucesso");
                consultaTabela.setConsultas(daoConsulta.getConsultaTabela());
                consultaTabela.atualizar();
            }
            else {
                viewAgendamentos.exibirMensagem("Não foi possível Cancelar a Consulta");
            }
        }
    }

    public void cancelarExame(){
        if(viewAgendamentos.getLinhaExameSelecionada() == -1){
            viewAgendamentos.exibirMensagem("Nenhum exame selecionado!");
        } else {
            ModeloExame exame = exameTabela.getExames().get(viewAgendamentos.getLinhaExameSelecionada());

            if(DAOExame.cancelarExame(exame)){
                viewAgendamentos.exibirMensagem("Exame excluido com sucesso");
                exameTabela.setExames(daoExame.getExameTabela());
                exameTabela.atualizar();
            }
            else {
                viewAgendamentos.exibirMensagem("Não foi possível Cancelar o Exame");
            }
        }
    }

}