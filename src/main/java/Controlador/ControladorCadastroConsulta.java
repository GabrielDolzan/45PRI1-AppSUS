package Controlador;

import DAO.DAOConsulta;
import Estrutura.Principal;
import Modelo.ModeloConsulta;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloMedico;
import View.ViewCadastroConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCadastroConsulta {

    private ModeloConsulta modeloConsulta;

    private ViewCadastroConsulta viewCadastroConsulta;

    public ControladorCadastroConsulta() {
        this.viewCadastroConsulta = new ViewCadastroConsulta();
        viewCadastroConsulta.limpaCB();
        popularCB();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       viewCadastroConsulta.exibir();
    }

    public void popularCB(){
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
        if (verificaPreenchimento()) {
            String data = viewCadastroConsulta.getData();
            String hora = viewCadastroConsulta.getHora();
            ModeloMedico medico = viewCadastroConsulta.getMedico();
            ModeloLocalAtendimento local = viewCadastroConsulta.getlocalAtendimento();

            //modeloConsulta = new ModeloConsulta(data, hora, Principal.getInstance().getModeloUsuario(), medico, local, "Disponivel");
            modeloConsulta = new ModeloConsulta(data, hora, Principal.getInstance().getModeloUsuario(), medico, local);

            DAOConsulta cons = new DAOConsulta();
            //cons.gravar(modeloConsulta);
            cons.insere(modeloConsulta);

            viewCadastroConsulta.limpaTela();
            viewCadastroConsulta.exibirMensagem("Consulta criada com sucesso: "+ modeloConsulta);
        }
    }

    private boolean verificaPreenchimento() {
        if (viewCadastroConsulta.getMedico() == null)
            return false;
        if (viewCadastroConsulta.getlocalAtendimento() == null)
            return false;
        if (viewCadastroConsulta.getData().isEmpty())
            return false;
        if (viewCadastroConsulta.getHora().isEmpty())
            return false;

        return true;
    }

}
