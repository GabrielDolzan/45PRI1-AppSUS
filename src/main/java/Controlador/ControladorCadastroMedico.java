package Controlador;

import DAO.DAOMedico;
import Modelo.ModeloMedico;
import View.ViewCadastroMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCadastroMedico {

    private ViewCadastroMedico view;

    public ControladorCadastroMedico() {
        view = new ViewCadastroMedico();
        adicionaAcoes();
    }

    private void adicionaAcoes() {
        view.adicionaAcaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insere();
            }
        });

        view.adicionaAcaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuAdministrador cont = new ControladorMenuAdministrador();
                cont.exibirTela();

                view.setVisible(false);
            }
        });
    }

    private void insere() {
        ModeloMedico medico = new ModeloMedico(view.getNome(), view.getEspecialidade(), view.getTelefone(), view.getRg());

        DAOMedico dao = new DAOMedico();

        dao.insere(medico);
    }

    public void exibir() {
        view.setVisible(true);
    }

}