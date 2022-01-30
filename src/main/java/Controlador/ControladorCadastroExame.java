package Controlador;

import DAO.DAOExame;
import Estrutura.Principal;
import Modelo.ModeloExame;
import Modelo.ModeloLocalAtendimento;
import Modelo.ModeloTipoExame;
import View.ViewCadastroExame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCadastroExame {

    private ViewCadastroExame view;
    private ModeloExame modeloExame;

    public ControladorCadastroExame() {
        this.view = new ViewCadastroExame();
        popularCB();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       view.exibir();
    }

    public void popularCB(){
       view.populaExame();
       view.populaLocal();
    }

    public void adicionarAcoesBotoes(){
        view.adicionaAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastraExame();
            }
        });

        view.adicionarAcaoBotaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuAdministrador cont = new ControladorMenuAdministrador();
                cont.exibirTela();

                view.setVisible(false);
            }
        });
    }

    private void cadastraExame() {
        //modeloExame = new ModeloExame(view.getExame(), view.getlocalAtendimento(), view.getHora(), view.getData(), "Disponivel");

        if (verificaPreenchimento()) {
            String data = view.getData();
            String hora = view.getHora();
            ModeloTipoExame tipoExame = view.getTipoExame();
            ModeloLocalAtendimento local = view.getlocalAtendimento();
            modeloExame = new ModeloExame(data, hora, Principal.getInstance().getModeloUsuario(), tipoExame, local);

            DAOExame exame = new DAOExame();
            //exame.gravar(modeloExame);
            exame.insere(modeloExame);
            view.limpaTela();
            view.exibirMensagem("Exame criado com sucesso: \n"+ modeloExame);
        }
        else {
            view.exibirMensagem("Algum campo esta em branco ou preenchido incorretamente! ");
        }
    }

    private boolean verificaPreenchimento() {
        if (view.getTipoExame() == null)
            return false;
        if (view.getlocalAtendimento() == null)
            return false;
        if (view.getData().isEmpty())
            return false;
        if (view.getHora().isEmpty())
            return false;

        return true;
    }

}