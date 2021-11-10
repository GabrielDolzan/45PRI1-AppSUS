/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ModeloConsulta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DAOConsulta {
    private static List<ModeloConsulta> consultas = new ArrayList<>();

    public static boolean gravar(ModeloConsulta consulta){
        consultas.add(consulta);
        return true;
    }

    public static List<ModeloConsulta> getConsulta() {
        return consultas;
    }


}
