package Controlador;

import DAO.DAOLocalAtendimento;
import Modelo.ModeloLocalAtendimento;
import View.ViewCadastroLocalAtendimento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCadastroLocalAtendimento {

    private ViewCadastroLocalAtendimento view;

    public ControladorCadastroLocalAtendimento() {
        view = new ViewCadastroLocalAtendimento();
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
        ModeloLocalAtendimento local = new ModeloLocalAtendimento(view.getTelefone(), view.getEndereco());
        
        if(validaCampo()){
            DAOLocalAtendimento dao = new DAOLocalAtendimento();
            dao.salvar(local);
            view.exibirMensagem("Local cadastrado com sucesso. ");
            view.limpaTela();
        }
        else {
            view.exibirMensagem("Algum campo esta em branco ou preenchido incorretamente! ");
        }
    }

    public boolean validaCampo(){
        if(this.view.getTelefone().equals(""))
            return false;
        
        if(this.view.getEndereco().equals(""))
           return false;
        
        return true;
    }
    
    public void exibir() {
        view.setVisible(true);
    }

}
