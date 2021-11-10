/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DAOUsuario {

    private static List<ModeloUsuario> usuarios = new ArrayList<>();

    public static boolean gravar(ModeloUsuario usuario){
        for(ModeloUsuario use : usuarios){
            if(use.getCPF().equals(usuario.getCPF())){
                return false;
            }
        }
        usuarios.add(usuario);
        return true;
    }
     
    public static List<ModeloUsuario> getUsuario() {
        return usuarios;
    }

    public static boolean removeUsuario(String cpf){
        for(ModeloUsuario use : usuarios){
            if(use.getCPF().equals(cpf)){
                usuarios.remove(use);
                return true;
            }
        }
        return false;
    }
}