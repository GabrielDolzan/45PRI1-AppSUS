package Controlador;

import Estrutura.Principal;
import Modelo.ModeloUsuario;
import View.ViewMeuPerfil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMeuPerfil {

    private ViewMeuPerfil viewMeuPerfil;

    public ControladorMeuPerfil() {
        this.viewMeuPerfil = new ViewMeuPerfil();
        preencheCampo();
        texFild();
        adicionarAcoesBotoes();
    }

    public void exibir(){
       viewMeuPerfil.exibir();
    }

    public void texFild(){
        viewMeuPerfil.textFild();
    }

    public void adicionarAcoesBotoes(){
        viewMeuPerfil.adicionarAcaoVoltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMenuUsuario  cont = new ControladorMenuUsuario();
                cont.exibirTela();

                viewMeuPerfil.setVisible(false);
            }
        });
    }

    public void preencheCampo() {
        ModeloUsuario usuario = Principal.getInstance().getModeloUsuario();

        viewMeuPerfil.setCPF(usuario.getCpf());
        viewMeuPerfil.setCelular(usuario.getCelular());
        viewMeuPerfil.setDataNascimento(usuario.getNascimento());
        viewMeuPerfil.setEmail(usuario.getEmail());
        viewMeuPerfil.setNome(usuario.getNome());
        viewMeuPerfil.setSexo(usuario.getSexo());
        viewMeuPerfil.setEstado(usuario.getEstado());
        viewMeuPerfil.setCidade(usuario.getCidade());
    }

}