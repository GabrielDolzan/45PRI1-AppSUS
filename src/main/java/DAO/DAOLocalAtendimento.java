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
public class DAOLocalAtendimento {
    private static List<ModeloLocalAtendimento> locais = new ArrayList<>();

    public static boolean salvar(ModeloLocalAtendimento local){
       
        locais.add(local);
        System.out.println(locais);
        return true;
    }

   public static List<ModeloLocalAtendimento> getLocalAtendimento(){
        return locais;
    }

    public static boolean excluirFilial(String endereco){
        for(ModeloLocalAtendimento loc : locais){
            if(loc.getEndereco().equals(endereco)){
                locais.remove(loc);
                return true;
            }
        }
        return false;
    }

    public void insere(ModeloLocalAtendimento local) {

    }

}
