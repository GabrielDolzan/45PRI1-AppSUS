package Controlador;

import DAO.DAOConsulta;
import DAO.DAOExame;
import Modelo.Modelo.Tabelas.TabelaConsulta;
import Modelo.Modelo.Tabelas.TabelaExame;
import Modelo.ModeloConsulta;
import View.ViewTodosAgendamentosUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorTodosAgendamentosUsuario {

    private ViewTodosAgendamentosUsuario viewAgendamentos;
    private TabelaConsulta consultaTabela;
    private DAOConsulta daoConsulta;
    private TabelaExame exameTabela;
    private DAOExame daoExame;
    
    public ControladorTodosAgendamentosUsuario() {
        this.viewAgendamentos = new ViewTodosAgendamentosUsuario();
        consultaTabela = new TabelaConsulta(daoConsulta.getConsulta());
        exameTabela = new TabelaExame(daoExame.getExame());
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
