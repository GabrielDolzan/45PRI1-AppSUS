/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ModeloDescricaoExame;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DAODescricaoExame {
    
    private static List<ModeloDescricaoExame> exames = new ArrayList<>();

    public static boolean gravar(ModeloDescricaoExame exame){
        for(ModeloDescricaoExame ex: exames){
            if(ex.getDescricao().equalsIgnoreCase(exame.getDescricao())){
                return false;
            }
        }
        exames.add(exame);
        System.out.println(exames);

        return true;
    }


    public static List<ModeloDescricaoExame> getExame() {
        return exames;
    }
}