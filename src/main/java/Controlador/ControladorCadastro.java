/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOUsuario;
import Modelo.ModeloUsuario;
import View.ViewCadastro;
import View.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorCadastro {
    
    private ViewLogin viewLogin;
    private ModeloUsuario modeloUsuario;
    
    private ViewCadastro viewCadastro;
    
    public ControladorCadastro(ViewLogin viewLogin, ViewCadastro viewCadastro, ModeloUsuario modeloUsuario) {
        this.viewCadastro = viewCadastro;
        this.modeloUsuario =modeloUsuario;
        this.viewLogin = viewLogin;
        adicionarAcoesBotoes();
    }
    public void exibir(){
       viewCadastro.exibirTela();
    }
       
    public void adicionarAcoesBotoes(){
        viewCadastro.addAcaoBotaoCriarConta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    CadastraUsuario();
                    //viewCadastro.exibirMensagem("Consulta XXXX");
            }
        });
    }
    
    public void CadastraUsuario(){
        modeloUsuario = new ModeloUsuario(viewCadastro.getEstado(), viewCadastro.getCidade(), viewCadastro.getNomeCompleto(), viewCadastro.getCPF(), viewCadastro.getCelular(), viewCadastro.getDataNascimento(), viewCadastro.getSexo(), viewCadastro.getEmail(), viewCadastro.getSenha());
        
        if(validarUsuario()){
            if(DAOUsuario.gravar(modeloUsuario)){
                viewCadastro.exibirMensagem("Usuario criado com sucesso. ");
                viewCadastro.LimpaTela();
            }
        }
        else {
                viewCadastro.exibirMensagem("Algum Campo esta em branco ou preenchido incorretamente! ");
        }
    }
   
    public boolean validarUsuario(){
        
        if (this.modeloUsuario.getEstado().equals(""))
            return false;
        if (this.modeloUsuario.getCidade().equals(""))
            return false;
        if (this.modeloUsuario.getNome().equals(""))
            return false;
        if (this.modeloUsuario.getCPF().equals(""))
            return false;
        if (this.modeloUsuario.getCelular().equals(""))
            return false;
        if (this.modeloUsuario.getNascimento().equals(""))
            return false;
        if (this.modeloUsuario.getSexo().equals(""))
            return false;
        if (this.modeloUsuario.geteMail().equals(""))
            return false;
        if (this.modeloUsuario.getSenha().equals(""))
            return false;
        return true;
    }

    public ViewCadastro getViewCadastro() {
        return viewCadastro;
    } 
}
