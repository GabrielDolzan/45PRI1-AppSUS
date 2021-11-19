package Controlador;

import Modelo.ModeloConsulta;
import View.ViewCadastroConsulta;
import View.ViewMenuUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCadastroConsulta {

    private ViewMenuUsuario viewMenuUsuario;
    private ModeloConsulta modeloConsulta;

    private ViewCadastroConsulta viewCadastroConsulta;

    public ControladorCadastroConsulta() {
        this.viewCadastroConsulta = new ViewCadastroConsulta();
        //adicionarAcoesBotoes();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       viewCadastroConsulta.exibir();
    }

    public void adicionarAcoesBotoes(){
        viewCadastroConsulta.adicionaAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastraConsulta();
            }
        });

        viewCadastroConsulta.adicionarAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuAdministrador cont = new ControladorMenuAdministrador();
                cont.exibirTela();

                viewCadastroConsulta.setVisible(false);
            }
        });
    }

    private void cadastraConsulta() {
        if (verificaPreenchimento()) {
            
        }
    }

    private boolean verificaPreenchimento() {
        if (viewCadastroConsulta.getEspecialidade().isEmpty())
            return false;
        if (viewCadastroConsulta.getMedico().isEmpty())
            return false;
        if (viewCadastroConsulta.getlocalAtendimento().isEmpty())
            return false;
        if (viewCadastroConsulta.getEndereço().isEmpty())
            return false;
        if (viewCadastroConsulta.getData().isEmpty())
            return false;
        if (viewCadastroConsulta.getHora().isEmpty())
            return false;

        return true;
    }

}
