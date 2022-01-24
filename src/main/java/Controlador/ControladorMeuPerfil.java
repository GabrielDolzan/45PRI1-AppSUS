/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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

    public ControladorMeuPerfil() {
        this.viewMeuPerfil = new ViewMeuPerfil();
        adicionarAcoesBotoes();
    }
    
    public void exibir(){
       viewMeuPerfil.exibir();
    }

    public void adicionarAcoesBotoes(){
       

        viewMeuPerfil.adicionarAcaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuAdministrador cont = new ControladorMenuAdministrador();
                cont.exibirTela();

                viewMeuPerfil.setVisible(false);
            }
        });
    }
}
