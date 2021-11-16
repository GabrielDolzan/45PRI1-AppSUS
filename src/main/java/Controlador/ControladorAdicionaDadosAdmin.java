/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOEspecialidade;
import DAO.DAOLocalAtendimento;
import DAO.DAOMedico;
import Modelo.ModeloEspecialidade;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import View.ViewAdicionaDadosConsultaAdmin;
import View.ViewMenuAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorAdicionaDadosAdmin {
    
    private ModeloMedico modeloMedico;
    private ModeloEspecialidade modeloEspecialidade;
    private ModeloLocalAtendimento modeloLocal;
    
    private ViewAdicionaDadosConsultaAdmin viewAdicionaDados;
    private ViewMenuAdministrador viewMenuAdmin;

            
    public ControladorAdicionaDadosAdmin(ViewMenuAdministrador viewMenuAdmin, ViewAdicionaDadosConsultaAdmin viewAdicionaDados, ModeloMedico modeloMedico, ModeloEspecialidade modeloEspecialidade, ModeloLocalAtendimento modeloLocal) {
       this.viewMenuAdmin = viewMenuAdmin;
       this.viewAdicionaDados = viewAdicionaDados;
       this.modeloEspecialidade = modeloEspecialidade;
       this.modeloMedico = modeloMedico;
       this.modeloLocal = modeloLocal;
       adicionarAcoesBotoes();
    }
    
    public void adicionarAcoesBotoes(){
           viewAdicionaDados.addAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                salvarDados();
            }
        });
    }
    
    public void exibir(){
       viewAdicionaDados.exibir();  
    }
    
    public void salvarDados() {
        //modeloCarro = new Carro( cadCarrosView.marca(), cadCarrosView.modelo(), cadCarrosView.ano(), cadCarrosView.quilometragem(), cadCarrosView.filial(), "disponivel", cadCarrosView.portas());
        modeloEspecialidade = new ModeloEspecialidade(viewAdicionaDados.getEspecialidade());
        modeloLocal = new ModeloLocalAtendimento(viewAdicionaDados.getlocalAtendimento(), viewAdicionaDados.getEndereço());
        modeloMedico = new ModeloMedico(viewAdicionaDados.getMedico(), modeloEspecialidade);
        
        
        DAOEspecialidade.gravar(modeloEspecialidade);
        DAOLocalAtendimento.salvar(modeloLocal);
        DAOMedico.gravar(modeloMedico);
    }
 
    public ViewAdicionaDadosConsultaAdmin getViewAddDadosConsultaAdmin() {
        return viewAdicionaDados;
    }  
    
}
