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
public class ConsultaDAO {
    private static List<Consulta> consultas = new ArrayList<>(); 

    public static boolean gravar(Consulta consulta){
        consultas.add(consulta);
        return true;
    }

    public static List<Consulta> getConsulta() {
        return consultas;
    }

    
}
