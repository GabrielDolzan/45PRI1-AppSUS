package Controlador;

import DAO.DAOConsulta;
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
        popularCB();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       viewCadastroConsulta.exibir();
       
//       viewCadastroConsulta.limparCB();
//       viewCadastroConsulta.populaEspecialidade();
//       viewCadastroConsulta.populaMedico();
//       viewCadastroConsulta.populaLocal(); 
    }
    
    public void popularCB(){
       viewCadastroConsulta.populaEspecialidade();
       viewCadastroConsulta.populaMedico();
       viewCadastroConsulta.populaLocal();
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
        modeloConsulta = new ModeloConsulta(viewCadastroConsulta.getMedico(), viewCadastroConsulta.getlocalAtendimento(), viewCadastroConsulta.getHora(), viewCadastroConsulta.getData());
        if (verificaPreenchimento()) {
            DAOConsulta cons = new DAOConsulta();
            cons.gravar(modeloConsulta);
            viewCadastroConsulta.limpaTela();
            viewCadastroConsulta.limparCB();
            viewCadastroConsulta.exibirMensagem("Consulta criada com sucesso:"+ modeloConsulta);
            
            
        }
    }

    private boolean verificaPreenchimento() {
        if (viewCadastroConsulta.getEspecialidade()== null)
            return false;
        if (viewCadastroConsulta.getMedico()== null)
            return false;
        if (viewCadastroConsulta.getlocalAtendimento()== null)
            return false;
//        if (viewCadastroConsulta.getEndereço().isEmpty())
//            return false;
        if (viewCadastroConsulta.getData().isEmpty())
            return false;
        if (viewCadastroConsulta.getHora().isEmpty())
            return false;

        return true;
    }

}
