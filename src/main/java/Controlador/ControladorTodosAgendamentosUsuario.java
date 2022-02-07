package Controlador;

import DAO.DAOConsulta;
import DAO.DAOExame;
import Estrutura.Principal;
import Modelo.Modelo.Tabelas.TabelaConsulta;
import Modelo.Modelo.Tabelas.TabelaExame;
import View.ViewTodosAgendamentosUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTodosAgendamentosUsuario {

    private ViewTodosAgendamentosUsuario viewAgendamentos;
    private TabelaConsulta consultaTabela;
    private DAOConsulta daoConsulta;
    private TabelaExame exameTabela;
    private DAOExame daoExame;
    private Principal principal;
    
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

    public void atualizarDados(){
        consultaTabela.fireTableDataChanged();
    }
    
   
     private void adicionarAcoesBotoes(){

        viewAgendamentos.addAcaoBotaoCancelaExame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelarExame();
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
                CancelarConsulta();
            }
        });
    }
    
    public void CancelarConsulta(){
        String Data = viewAgendamentos.getDataConsultaSelecionada();
        String hora = viewAgendamentos.getHoraConsultaSelecionada();
        if(DAOConsulta.excluirConsulta(Data, hora)){
            viewAgendamentos.exibirMensagem("Consulta excluida com sucesso");
            atualizarDados();
        }
        else {
            viewAgendamentos.exibirMensagem("Não foi possível Cancelar a Consulta");
        }
    }
    
    public void CancelarExame(){
        String Data = viewAgendamentos.getDataExameSelecionada();
        String hora = viewAgendamentos.getHoraExameSelecionada();
        if(DAOExame.excluirExame(Data, hora)){
            viewAgendamentos.exibirMensagem("Exame excluido com sucesso");
            atualizarDados();
        }
        else {
            viewAgendamentos.exibirMensagem("Não foi possível Cancelar o Exame");
        }
    }
}
