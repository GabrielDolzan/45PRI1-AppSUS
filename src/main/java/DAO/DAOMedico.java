package DAO;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMedico {

    private static List<ModeloMedico> medicos = new ArrayList<>();

    public static boolean gravar(ModeloMedico medico){
//        for(ModeloMedico med : medicos){
//
//            System.out.println(med.getRg()+" xxxxxxxxxx "+ medico.getRg());
//
//            if(med.getRg().equals(medico.getRg())){
//                return false;
//            }
//        }
        medicos.add(medico);
        System.out.println(medicos);

        return true;
    }

    public static List<ModeloMedico> getMedico() {
        return medicos;
    }

    public static boolean removeMedico(String nome){
        for(ModeloMedico med : medicos){
            if(med.getNome().equals(nome)){
                medicos.remove(med);
                return true;
            }
        }
        return false;
    }

    public boolean insere(ModeloMedico medico) {
        return false;
    }

}
