package Controlador;

import View.ViewMenuAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenuAdministrador {
    private ViewMenuAdministrador viewMenuAdmin;

    public ControladorMenuAdministrador() {
        viewMenuAdmin = new ViewMenuAdministrador();
        inicializarAcaoBotoesMenu();
    }

    public void exibirTela() {
        viewMenuAdmin.exibirTela();
    }

    public void inicializarAcaoBotoesMenu() {
        viewMenuAdmin.adicionarAcaoCadastrarConsulta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastroConsulta cont = new ControladorCadastroConsulta();
                cont.exibir();

                viewMenuAdmin.setVisible(false);
            }
        });

        viewMenuAdmin.adicionarAcaoCadastrarNomeExame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastroTipoExame cont = new ControladorCadastroTipoExame();
                cont.exibir();
                
                viewMenuAdmin.setVisible(false);
            }
        });
        
        viewMenuAdmin.adicionarAcaoCadastrarExame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastroExame cont = new ControladorCadastroExame();
                cont.exibir();
                
                viewMenuAdmin.setVisible(false);
            }
        });

        viewMenuAdmin.adicionarAcaoCadastrarEspecialidade(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastroEspecialidade cont = new ControladorCadastroEspecialidade();
                cont.exibir();

                viewMenuAdmin.setVisible(false);
            }
        });

        viewMenuAdmin.adicionarAcaoCadastrarMedico(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastroMedico cont = new ControladorCadastroMedico();
                cont.exibir();

                viewMenuAdmin.setVisible(false);
            }
        });

        viewMenuAdmin.adicionarAcaoCadastrarLocal(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastroLocalAtendimento cont = new ControladorCadastroLocalAtendimento();
                cont.exibir();

                viewMenuAdmin.setVisible(false);
            }
        });

        viewMenuAdmin.adicionarAcaoSair(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorLogin cont = new ControladorLogin();
                cont.exibir();

                viewMenuAdmin.setVisible(false);
            }
        });
    }

}
