package Controlador;

import DAO.DAOConsulta;
import DAO.DAOLocalAtendimento;
import DAO.DAOMedico;
import Estrutura.Principal;
import Modelo.Modelo.Tabelas.TabelaConsulta;
import Modelo.ModeloConsulta;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import Modelo.ModeloUsuario;
import View.ViewAgendarConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

public class ControladorAgendarConsulta {

    private ViewAgendarConsulta viewAgendarConsulta;
    private DAOConsulta DAOConsulta;
    private DAOMedico DAOMedico;
    private DAOLocalAtendimento DAOLocalAtendimento;

    private TabelaConsulta tabela;
                
    public ControladorAgendarConsulta() {
        this.viewAgendarConsulta = new ViewAgendarConsulta();
        this.DAOConsulta = new DAOConsulta();
        this.DAOMedico = new DAOMedico();
        this.DAOLocalAtendimento = new DAOLocalAtendimento();

        viewAgendarConsulta.limparCB();
        popularCB();
        adicionarAcoesBotoes();
        adicionarAcoesComboBox();
    }

    public void exibir(){
       viewAgendarConsulta.exibirTela();
    }

    public void popularCB(){
       popularMedicos();
       popularPostoAtendimento();
       popularData();
       popularHora();
    }

    public void adicionarAcoesBotoes(){
        viewAgendarConsulta.addAcaoBotaoAgendar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (viewAgendarConsulta.getData().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecione uma data para agendar.", "Alerta!", JOptionPane.WARNING_MESSAGE);
                } else if (viewAgendarConsulta.getHora().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecione uma hora para agendar.", "Alerta!", JOptionPane.WARNING_MESSAGE);
                } else {
                    String data = viewAgendarConsulta.getData();
                    String hora = viewAgendarConsulta.getHora();
                    ModeloUsuario usuario = Principal.getInstance().getModeloUsuario();
                    ModeloMedico medico = viewAgendarConsulta.getMedico();
                    ModeloLocalAtendimento local = viewAgendarConsulta.getLocalAtendimento();

                    ModeloConsulta consulta = new ModeloConsulta(data, hora, usuario, medico, local);

                    if (DAOConsulta.agendarConsulta(consulta)) {
                        popularData();
                        popularHora();
                        JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao agendar a consulta.", "Erro!", JOptionPane.ERROR_MESSAGE);
                    }
                }
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

    private void adicionarAcoesComboBox() {
        viewAgendarConsulta.adicionarAcaoMedico(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                popularData();
                popularHora();
            }
        });

        viewAgendarConsulta.adicionarAcaoLocal(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                popularData();
                popularHora();
            }
        });

        viewAgendarConsulta.adicionarAcaoData(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                popularHora();
            }
        });
    }

    private void popularMedicos() {
        for (ModeloMedico med : this.DAOMedico.getMedico()) {
            viewAgendarConsulta.popularMedicos(med);
        }
    }

    private void popularPostoAtendimento() {
        for (ModeloLocalAtendimento loc : this.DAOLocalAtendimento.getLocalAtendimento()){
            viewAgendarConsulta.popularPostoAtendimento(loc);
        }
    }

    private void popularData() {
        viewAgendarConsulta.limpaData();
        ModeloMedico medico = viewAgendarConsulta.getMedico();
        ModeloLocalAtendimento local = viewAgendarConsulta.getLocalAtendimento();
        for (ModeloConsulta consulta : this.DAOConsulta.getConsultaLivre(medico, local)) {
            viewAgendarConsulta.popularData(consulta.getData());
        }
    }

    private void popularHora() {
        viewAgendarConsulta.limpaHora();
        String data = viewAgendarConsulta.getData();
        if (!data.isEmpty()) {
            ModeloMedico medico = viewAgendarConsulta.getMedico();
            ModeloLocalAtendimento local = viewAgendarConsulta.getLocalAtendimento();
            for (ModeloConsulta consulta : this.DAOConsulta.getConsultaLivre(medico, local, data)) {
                viewAgendarConsulta.popularHora(consulta.getHora());
            }
        }
    }

}