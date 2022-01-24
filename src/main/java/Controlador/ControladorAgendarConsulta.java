package Controlador;

import DAO.DAOConsulta;
import Modelo.ModeloConsulta;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import View.ViewAgendarConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAgendarConsulta {

    private ViewAgendarConsulta viewAgendarConsulta;
    private ModeloConsulta modeloConsulta;
    private ModeloConsulta modeloConsultaCopia;
    private DAOConsulta consDAO;

    public ControladorAgendarConsulta() {
        this.viewAgendarConsulta = new ViewAgendarConsulta();
        viewAgendarConsulta.limparCB();
        popularCB();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       viewAgendarConsulta.exibirTela();
    }

    public void popularCB(){
       viewAgendarConsulta.popularMedicos();
       viewAgendarConsulta.popularPostoAtendimento();
    }

    public void adicionarAcoesBotoes(){
         viewAgendarConsulta.addAcaoBotaoPesquisaData(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisaData();
            }
        });

        viewAgendarConsulta.adicionarAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuAdministrador cont = new ControladorMenuAdministrador();
                cont.exibirTela();

                viewAgendarConsulta.setVisible(false);
            }
        });
    }
    
    private void pesquisaData() {
        ModeloMedico med= viewAgendarConsulta.getMedico();
        ModeloLocalAtendimento loc= viewAgendarConsulta.getLocalAtendimento();

        
    

        modeloConsulta = new ModeloConsulta(viewAgendarConsulta.getMedico(), viewAgendarConsulta.getLocalAtendimento(), "", "", "Disponivel");
        modeloConsultaCopia = new ModeloConsulta(null, null, "", "", "");

        DAOConsulta cons= new DAOConsulta();
        if ( cons.pesquisaData(modeloConsulta,modeloConsultaCopia)) {
                   DAOConsulta consDAO= new DAOConsulta();

            //for( ModeloConsulta mod:this.consDAO.getConsultaCopia){
            //aqui seria um for para listar as consultas disponiveis e o usuario escolher qual quer.
            //Porem acho que precisa fazer em outra teli com um checbox
            //}
        }
    }

    
}
