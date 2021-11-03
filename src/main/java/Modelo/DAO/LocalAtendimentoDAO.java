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
public class LocalAtendimentoDAO {
    private static List<LocalAtendimento> locais = new ArrayList<>();
    
    public static boolean salvar(LocalAtendimento local){
        for(LocalAtendimento loc : locais){
            if(loc.getLocalAtendimento().equals(local.getLocalAtendimento()) || loc.getEndereço().equals(local.getEndereço()))
                return false;
        }
        locais.add(local);
        return true;
    }
        
   public static List<LocalAtendimento> getLocalAtendimento(){
        return locais;
    }
    
    public static boolean excluirFilial(String localAntendimento){
        for(LocalAtendimento loc : locais){
            if(loc.getLocalAtendimento().equals(localAntendimento)){
                locais.remove(loc);
                return true;
            }
        }
        return false;
    }
    
    
}
