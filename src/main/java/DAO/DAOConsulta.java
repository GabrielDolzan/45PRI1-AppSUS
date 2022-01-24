package DAO;

import Modelo.ModeloConsulta;
import java.util.ArrayList;
import java.util.List;

public class DAOConsulta {

    private static List<ModeloConsulta> consultas = new ArrayList<>();
    private static List<ModeloConsulta> copias = new ArrayList<>();

    public static boolean gravar(ModeloConsulta consulta){
        consultas.add(consulta);
        return true;
    }

    
    public static boolean pesquisaData(ModeloConsulta consulta, ModeloConsulta copia){
        for(ModeloConsulta ex: consultas){
            if(ex.getStatus().equalsIgnoreCase(consulta.getStatus())){
                copias.add(ex); 
                return true;
            }
             
        }
       
        return false;
    }
    
    public static List<ModeloConsulta> getConsulta() {
        return consultas;
    }
    
    public static List<ModeloConsulta> getConsultaCopiad() {
        return copias;
    }
    public Iterable<ModeloConsulta> getConsultaCopia(){
        return copias;
    }


}
