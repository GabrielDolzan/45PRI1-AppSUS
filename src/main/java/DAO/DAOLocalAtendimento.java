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
//        for(ModeloLocalAtendimento loc : locais){
//            if(loc.getLocalAtendimento().equals(local.getLocalAtendimento()) || loc.getEndereço().equals(local.getEndereço()))
//                return false;
//        }
        locais.add(local);
        System.out.println(locais);
        return true;
    }

   public static List<ModeloLocalAtendimento> getLocalAtendimento(){
        return locais;
    }

    public static boolean excluirFilial(String localAntendimento){
        for(ModeloLocalAtendimento loc : locais){
            if(loc.getLocalAtendimento().equals(localAntendimento)){
                locais.remove(loc);
                return true;
            }
        }
        return false;
    }


}
