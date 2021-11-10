package DAO;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DAOMedico {
    private static List<Medico> medicos = new ArrayList<>(); 

    public static boolean gravar(Medico medico){
        for(Medico med : medicos){
            if(med.getNome().equals(medico.getNome())){
                return false;
            }
        }
        medicos.add(medico);
        return true;
    }
     
    public static List<Medico> getMedico() {
        return medicos;
    }
  
    public static boolean removeMedico(String nome){
        for(Medico med : medicos){
            if(med.getNome().equals(nome)){
                medicos.remove(med);
                return true;
            }
        }
        return false;
    }
    
}
