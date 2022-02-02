/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Modelo.Tabelas;

import Modelo.ModeloConsulta;
import Modelo.ModeloEspecialidade;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class TabelaConsulta extends AbstractTableModel {
    
    private List<ModeloConsulta> consultas;
    private String[] nomeColunas = {"Medico", "Local de atendimento", "Data", "Hora"};
    
    private final int COLUNA_MEDICO = 0;
    private final int COLUNA_LOCAL = 1;
    private final int COLUNA_DATA = 2;
    private final int COLUNA_HORARIO = 3;

    public TabelaConsulta(List<ModeloConsulta> consultas) {
        
        this.consultas = consultas ;
    }

    @Override
    public int getRowCount() {
        return consultas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
    
    @Override
    public String getColumnName (int column){
        return nomeColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModeloConsulta consulta = consultas.get(rowIndex);
        String valor = null;
        switch(columnIndex){
            case COLUNA_MEDICO: 
                valor = consulta.getMedico().getNome();
                break;
            case COLUNA_LOCAL: 
                valor = consulta.getLocal().getEndereco();
                break;
            case COLUNA_DATA: 
                valor = consulta.getData();
                break;
            case COLUNA_HORARIO: 
                valor = consulta.getHora();
                break;
        }    
        System.out.println("tchau ");
 
        return valor;
    }
    
    public void addRow(ModeloConsulta cons){
        this.consultas.add(cons);
        this.fireTableDataChanged();
    }

    public List<ModeloConsulta> getConsultas() {
        return consultas;
    }
    
      
   @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
     
    	ModeloConsulta consulta = this.consultas.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_MEDICO:
                consulta.setMedico((ModeloMedico) aValue);
                break;
            case COLUNA_LOCAL: 
                consulta.setLocal((ModeloLocalAtendimento) aValue);
                break;
            case COLUNA_DATA: 
                consulta.setData((String)aValue);
                break;
            case COLUNA_HORARIO: 
                consulta.setHora((String)aValue);
                break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
