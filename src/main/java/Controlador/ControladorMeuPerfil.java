/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloUsuario;
import View.ViewCadastroConsulta;
import View.ViewMeuPerfil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorMeuPerfil {
    
    private ViewMeuPerfil viewMeuPerfil;

        private ModeloUsuario usuario;

    public ControladorMeuPerfil() {
        this.viewMeuPerfil = new ViewMeuPerfil();
        preencheCampo();
        texFild();
        adicionarAcoesBotoes();
    }
    
    public void exibir(){
       viewMeuPerfil.exibir();
    }
    
    
    
    
    public void texFild(){
        viewMeuPerfil.textFild();
    }

    public void adicionarAcoesBotoes(){
       

        viewMeuPerfil.adicionarAcaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuUsuario  cont = new ControladorMenuUsuario();
                cont.exibirTela();

                viewMeuPerfil.setVisible(false);
            }
        });
    }
    
    public void preencheCampo(){
        viewMeuPerfil.setCPF(usuario.getCpf()); 
        viewMeuPerfil.setCelular(usuario.getCelular());
        viewMeuPerfil.setDataNascimento(usuario.getNascimento());
        viewMeuPerfil.setEmail(usuario.getEmail());
        viewMeuPerfil.setNome(usuario.getNome());
        viewMeuPerfil.setSexo(usuario.getSexo());
        viewMeuPerfil.setEstado(usuario.getEstado());
        viewMeuPerfil.setCidade(usuario.getCidade());
    }
}
