package Controlador;

import View.ViewAgendarConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAgendarConsulta {

    private ViewAgendarConsulta viewAgendarConsulta;

    public ControladorAgendarConsulta() {
       // popularCB();
        adicionarAcoesBotoes();
        adicionarAcoesCB();
    }

    public void exibir(){
       viewAgendarConsulta.exibirTela();

//       viewAgendaConsulta.limparCB();
//       viewAgendaConsulta.popularEspecialidade();
//       viewAgendaConsulta.popularMedico();
//       viewAgendaConsulta.popularPostoAtendimento();
    }

    public void popularCB(){
       viewAgendarConsulta.popularEspecialidade();
       viewAgendarConsulta.popularMedico();
    }

    public void adicionarAcoesBotoes(){
        /*viewAgendarConsulta.addAcaoBotaoPesquisaData(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });*/
    }

    private void adicionarAcoesCB() {

    }

}
