package Controlador;

import DAO.DAOExame;
import DAO.DAOLocalAtendimento;
import DAO.DAOTipoExame;
import Estrutura.Principal;
import Modelo.ModeloExame;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloTipoExame;
import Modelo.ModeloUsuario;
import View.ViewAgendarExame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

public class ControladorAgendarExame {

    private ViewAgendarExame viewAgendarExame;
    private DAOTipoExame DAOTipoExame;
    private DAOLocalAtendimento DAOLocalAtendimento;
    private DAOExame DAOExame;

    public ControladorAgendarExame() {
        this.viewAgendarExame = new ViewAgendarExame();
        this.DAOTipoExame = new DAOTipoExame();
        this.DAOLocalAtendimento = new DAOLocalAtendimento();
        this.DAOExame = new DAOExame();

        viewAgendarExame.limparCB();
        popularCB();
        adicionarAcoesBotoes();
        adicionarAcoesComboBox();
    }

    public void exibir(){
       viewAgendarExame.exibirTela();
    }

    public void popularCB(){
       popularTipoExame();
       popularPostoAtendimento();
       popularData();
       popularHora();
    }

    public void adicionarAcoesBotoes(){
         viewAgendarExame.addAcaoBotaoAgendar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (viewAgendarExame.getData().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecione uma data para agendar.", "Alerta!", JOptionPane.WARNING_MESSAGE);
                } else if (viewAgendarExame.getHora().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecione uma hora para agendar.", "Alerta!", JOptionPane.WARNING_MESSAGE);
                } else {
                    String data = viewAgendarExame.getData();
                    String hora = viewAgendarExame.getHora();
                    ModeloUsuario usuario = Principal.getInstance().getModeloUsuario();
                    ModeloTipoExame tipo = viewAgendarExame.getTipoExame();
                    ModeloLocalAtendimento local = viewAgendarExame.getLocalAtendimento();

                    ModeloExame exame = new ModeloExame(data, hora, usuario, tipo, local);

                    if (DAOExame.agendarExame(exame)) {
                        popularData();
                        popularHora();
                        JOptionPane.showMessageDialog(null, "Exame agendado com sucesso.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao agendar o exame.", "Erro!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        viewAgendarExame.adicionarAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuUsuario cont = new ControladorMenuUsuario();
                cont.exibirTela();

                viewAgendarExame.setVisible(false);
            }
        });
    }

    private void adicionarAcoesComboBox() {
        viewAgendarExame.adicionarAcaoTipoExame(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                popularData();
                popularHora();
            }
        });

        viewAgendarExame.adicionarAcaoLocal(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                popularData();
                popularHora();
            }
        });

        viewAgendarExame.adicionarAcaoData(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                popularHora();
            }
        });
    }

    private void popularTipoExame() {
        for (ModeloTipoExame tipo : this.DAOTipoExame.getTipoExame()) {
            viewAgendarExame.popularTipoExame(tipo);
        }
    }

    private void popularPostoAtendimento() {
        for (ModeloLocalAtendimento loc : this.DAOLocalAtendimento.getLocalAtendimento()){
            viewAgendarExame.popularPostoAtendimento(loc);
        }
    }

    private void popularData() {
        viewAgendarExame.limpaData();
        ModeloTipoExame tipo = viewAgendarExame.getTipoExame();
        ModeloLocalAtendimento local = viewAgendarExame.getLocalAtendimento();
        if (tipo != null && local != null) {
            for (ModeloExame exame : this.DAOExame.getExameLivre(tipo, local)) {
                viewAgendarExame.popularData(exame.getData());
            }
        }
    }

    private void popularHora() {
        viewAgendarExame.limpaHora();
        String data = viewAgendarExame.getData();
        if (!data.isEmpty()) {
            ModeloTipoExame tipo = viewAgendarExame.getTipoExame();
            ModeloLocalAtendimento local = viewAgendarExame.getLocalAtendimento();
            for (ModeloExame exame : this.DAOExame.getExameLivre(tipo, local, data)) {
                viewAgendarExame.popularHora(exame.getHora());
            }
        }
    }

}