/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class UsuarioDAO {
    
    private static List<Usuario> usuarios = new ArrayList<>(); 

    public static boolean gravar(Usuario usuario){
        for(Usuario use : usuarios){
            if(use.getCPF().equals(usuario.getCPF())){
                return false;
            }
        }
        usuarios.add(usuario);
        return true;
    }
     
    public static List<Usuario> getUsuario() {
        return usuarios;
    }
  
    public static boolean removeUsuario(String cpf){
        for(Usuario use : usuarios){
            if(use.getCPF().equals(cpf)){
                usuarios.remove(use);
                return true;
            }
        }
        return false;
    }
}
