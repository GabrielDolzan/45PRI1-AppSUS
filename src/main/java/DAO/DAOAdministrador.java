/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ModeloAdministrador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DAOAdministrador {
    private static List<ModeloAdministrador> administradores = new ArrayList<>();

    public static boolean gravar(ModeloAdministrador administrador){
        for(ModeloAdministrador admin : administradores){
            if(admin.getNome().equals(administrador.getNome())){
                return false;
            }
        }
        administradores.add(administrador);
        return true;
    }

    public static List<ModeloAdministrador> getAdministrador() {
        return administradores;
    }

    public static boolean removeAdministrador(String nome){
        for(ModeloAdministrador admin : administradores){
            if(admin.getNome().equals(nome)){
                administradores.remove(admin);
                return true;
            }
        }
        return false;
    }



}
