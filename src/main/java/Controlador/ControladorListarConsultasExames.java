/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOConsulta;
import Modelo.Modelo.Tabelas.TabelaConsulta;
import Modelo.Modelo.Tabelas.TabelaExame;
import View.ViewTodosAgendamentosUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorListarConsultasExames {
    
    private ViewTodosAgendamentosUsuario telaListarconsultas;
    private TabelaConsulta consultaTabela;
    private TabelaExame exameTabela;

    
    public ControladorListarConsultasExames(ViewTodosAgendamentosUsuario telaListarconsultas, TabelaConsulta consultaTabela) {
        this.telaListarconsultas = telaListarconsultas;
        this.consultaTabela = consultaTabela;
        setTableModel();
        adicionarAcaoBotaoExcluir();
    }
    private void setTableModel(){
        telaListarconsultas.setTableModelConsulta(this.consultaTabela);
        telaListarconsultas.setTableModelExamae(this.exameTabela);
    }
    
    public void exibir(){
        telaListarconsultas.exibirTela();
    }
    
    public void atualizarDados(){
        consultaTabela.fireTableDataChanged();
    }
    
    public void adicionarAcaoBotaoExcluir(){
        telaListarconsultas.addAcaoBotaoCancelaConsulta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelarConsulta();
            }
        });
    }
    
    public void CancelarConsulta(){
        String Data = telaListarconsultas.getDataConsultaSelecionada();
        String hora = telaListarconsultas.getHoraConsultaSelecionada();
        if(DAOConsulta.excluirConsulta(Data, hora)){
            telaListarconsultas.exibirMensagem("Consulta excluida com sucesso");
            atualizarDados();
        }
        else {
            telaListarconsultas.exibirMensagem("Não foi possível Cancelar a Consulta");
        }
    }
}
