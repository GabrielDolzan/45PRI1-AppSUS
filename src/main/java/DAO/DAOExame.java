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
public class DAOExame {

    private static List<ModeloExame> exames = new ArrayList<>();

    public static boolean gravar(ModeloExame exame){
        exames.add(exame);
        return true;
    }

    public static List<ModeloExame> getExame() {
        return exames;
    }

}
