package Modelo.Tabelas;

import Modelo.ModeloExame;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloTipoExame;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaExame extends AbstractTableModel {

    private List<ModeloExame> exames;
    private String[] nomeColunas = {"Exame", "Local de atendimento", "Data", "Hora"};

    private final int COLUNA_EXAME = 0;
    private final int COLUNA_LOCAL = 1;
    private final int COLUNA_DATA = 2;
    private final int COLUNA_HORARIO = 3;

    public TabelaExame(List<ModeloExame> exames) {
        this.exames = exames;
    }

    @Override
    public int getRowCount() {
        return exames.size();
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
        ModeloExame exame = exames.get(rowIndex);
        String valor = null;
        switch(columnIndex){
            case COLUNA_EXAME:
                valor = exame.getTipoExame().getDescricao();
                break;
            case COLUNA_LOCAL:
                valor = exame.getLocal().getEndereco();
                break;
            case COLUNA_DATA:
                valor = exame.getData();
                break;
            case COLUNA_HORARIO:
                valor = exame.getHora();
                break;
        }

        return valor;
    }

    public void addRow(ModeloExame ex){
        this.exames.add(ex);
        this.fireTableDataChanged();
    }

    public void atualizar() {
        this.fireTableDataChanged();
    }

   @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
    	ModeloExame exame = this.exames.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
            case COLUNA_EXAME:
                exame.setTipoExame((ModeloTipoExame) aValue);
                break;
            case COLUNA_LOCAL:
                exame.setLocal((ModeloLocalAtendimento) aValue);
                break;
            case COLUNA_DATA:
                exame.setData((String)aValue);
                break;
            case COLUNA_HORARIO:
                exame.setHora((String)aValue);
                break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }

    public List<ModeloExame> getExames() {
        return exames;
    }

    public void setExames(List<ModeloExame> exames) {
        this.exames = exames;
    }

}