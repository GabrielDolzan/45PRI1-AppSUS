package Controlador;

import DAO.DAOConsulta;
import DAO.DAOExame;
import Estrutura.Principal;
import Modelo.ModeloConsulta;
import Modelo.ModeloExame;
import View.ViewMenuUsuario;
import View.ViewTodosAgendamentosUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenuUsuario {

    private ViewTodosAgendamentosUsuario telaTabelas;
    private ViewMenuUsuario viewMenuUsuario;
    private DAOConsulta daoConsulta;
    private DAOExame DAOExame;

    private int cont =0;

    public ControladorMenuUsuario() {
        viewMenuUsuario = new ViewMenuUsuario();
        daoConsulta = new DAOConsulta();
        DAOExame = new DAOExame();

        popularProximaConsulta();
        popularProximoExame();
        inicializarAcaoBotoesMenu();
    }

    public void exibirTela() {
        viewMenuUsuario.exibirTela();
    }

    private void popularProximaConsulta() {
        ModeloConsulta consulta = daoConsulta.getProximaConsulta(Principal.getInstance().getModeloUsuario());

        if (consulta != null) {
            viewMenuUsuario.setProximaConsulta(consulta.toString());
        }
    }

    private void popularProximoExame() {
        ModeloExame exame = DAOExame.getProximoExame(Principal.getInstance().getModeloUsuario());

        if (exame != null) {
            viewMenuUsuario.setProximoExame(exame.toString());
        }
    }

    private void inicializarAcaoBotoesMenu() {
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
                ControladorAgendarExame cont = new ControladorAgendarExame();
                cont.exibir();

                viewMenuUsuario.setVisible(false);
            }
        });

         viewMenuUsuario.adicionarAcaoMeuPerfil(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMeuPerfil perfil = new ControladorMeuPerfil();
                perfil.exibir();
                viewMenuUsuario.setVisible(false);
            }
        });

        viewMenuUsuario.adicionarAcaoTodos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cont <= 1){
                    cont++;
                    ControladorTodosAgendamentosUsuario cont = new ControladorTodosAgendamentosUsuario();
                    cont.exibir();
                    viewMenuUsuario.setVisible(false);
                }else{
                    viewMenuUsuario.setVisible(false);
                    telaTabelas.setVisible(true);

                }
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