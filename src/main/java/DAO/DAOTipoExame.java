/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ModeloTipoExame;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DAOTipoExame {
    
    private static List<ModeloTipoExame> exames = new ArrayList<>();

    public static boolean gravar(ModeloTipoExame exame){
        for(ModeloTipoExame ex: exames){
            if(ex.getDescricao().equalsIgnoreCase(exame.getDescricao())){
                return false;
            }
        }
        exames.add(exame);
        System.out.println(exames);

        return true;
    }


    public static List<ModeloTipoExame> getExame() {
        return exames;
    }
}