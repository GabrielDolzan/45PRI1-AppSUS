package Controlador;

import Estrutura.Principal;
import View.ViewMenuUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenuUsuario {

    private ViewMenuUsuario viewMenuUsuario;

     public ControladorMenuUsuario() {
        viewMenuUsuario = new ViewMenuUsuario();
        inicializarAcaoBotoesMenu();
    }

    public void exibirTela() {
        viewMenuUsuario.exibirTela();
    }

    public void inicializarAcaoBotoesMenu() {
        viewMenuUsuario.adicionarAcaoAgendaConsulta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorAgendarConsulta cont = new ControladorAgendarConsulta();
                cont.exibir();

                viewMenuUsuario.setVisible(false);
            }
        });

        viewMenuUsuario.adicionarAcaoAgendaExame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        viewMenuUsuario.adicionarAcaoSair(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorLogin cont = new ControladorLogin();
                cont.exibir();

                Principal.getInstance().setModeloUsuario(null);

                viewMenuUsuario.setVisible(false);
            }
        });

    }

}