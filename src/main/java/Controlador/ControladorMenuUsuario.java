package Controlador;

import Estrutura.Principal;
import Modelo.ModeloUsuario;
import View.ViewMenuUsuario;
import View.ViewMeuPerfil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenuUsuario {

    private ViewMenuUsuario viewMenuUsuario;
    private ViewMeuPerfil viewMeuPerfil;
    private ModeloUsuario usuario;

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
        
         viewMenuUsuario.adicionarAcaoMeuPErfil(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorMeuPerfil perfil = new ControladorMeuPerfil();
                perfil.exibir();
                viewMenuUsuario.setVisible(false);
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
    
//    public void preencheCampo(){
//        viewMeuPerfil.setCPF(usuario.getCpf()); 
//        viewMeuPerfil.setCelular(usuario.getCelular());
//        viewMeuPerfil.setDataNascimento(usuario.getNascimento());
//        viewMeuPerfil.setEmail(usuario.getEmail());
//        viewMeuPerfil.setNome(usuario.getNome());
//        viewMeuPerfil.setSexo(usuario.getSexo());
//        viewMeuPerfil.setEstado(usuario.getEstado());
//        viewMeuPerfil.setCidade(usuario.getCidade());
//    }

}