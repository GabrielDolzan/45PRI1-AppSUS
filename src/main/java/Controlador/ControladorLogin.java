package Controlador;

import Modelo.ModeloUsuario;
import View.ViewCadastro;
import View.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ControladorLogin {

    private ViewLogin  logView;
    private ControladorCadastro controladorCadastro;

    public ControladorLogin() {
        logView = new ViewLogin();
        adicionarAcoesBotoes();
        inicializarAgendaConsulta();
        
    }
    
    public void exibir(){
        logView.exibirTela();
    }
   
    
    public void adicionarAcoesBotoes(){
        logView.addAcaoBotaoCriarConta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorCadastro.exibir();
            }
        });
        
        
        logView.addAcaoBotaoLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificaFuncionario();
            }
        });
        
    }
    
    
   public void verificaFuncionario(){
    
       String senha = logView.getSenha();
        if(senha.equalsIgnoreCase("admin")){
            logView.abrirMenuAdmin();
        }else{
            logView.abrirMenuUsuario();

        }
    }
   
   public void inicializarAgendaConsulta() {
        controladorCadastro = new ControladorCadastro(new ViewLogin(),new ViewCadastro(), new ModeloUsuario("", "","", "", "", "", "", "", ""));
    }
}
       
 


