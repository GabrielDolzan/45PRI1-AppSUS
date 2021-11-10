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
public class DAOEspecialidade {
    private static List<Especialidade> especialidades = new ArrayList<>(); 

    public static boolean gravar(Especialidade especialidade){
        especialidades.add(especialidade);
        return true;
    }

    public static List<Especialidade> getEspecialidade() {
        return especialidades;
    }
}
