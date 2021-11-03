/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Administrador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AdministradorDAO {
    private static List<Administrador> administradores = new ArrayList<>(); 

    public static boolean gravar(Administrador administrador){
        for(Administrador admin : administradores){
            if(admin.getNome().equals(administrador.getNome())){
                return false;
            }
        }
        administradores.add(administrador);
        return true;
    }
     
    public static List<Administrador> getAdministrador() {
        return administradores;
    }
  
    public static boolean removeAdministrador(String nome){
        for(Administrador admin : administradores){
            if(admin.getNome().equals(nome)){
                administradores.remove(admin);
                return true;
            }
        }
        return false;
    }
    
    
    
}
