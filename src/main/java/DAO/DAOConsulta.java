package DAO;

import Modelo.ModeloConsulta;
import java.util.ArrayList;
import java.util.List;

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
