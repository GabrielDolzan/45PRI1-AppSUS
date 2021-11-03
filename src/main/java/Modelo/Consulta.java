/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author User
 */
public class Consulta extends Atendimento{
    private String areaDesejada;
    private Medico medico;
    
    public Consulta(String areaDesejada, Medico medico, LocalAtendimento local, String hora, String data) {
        super(local, hora, data);
//        this.areaDesejada = areaDesejada;
//        this.medico = medico;
    }

    public String getAreaDesejada() {
        return areaDesejada;
    }

    public void setAreaDesejada(String areaDesejada) {
        this.areaDesejada = areaDesejada;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Especialidade: " + areaDesejada +"\n"
             + "Médico: " + medico+"\n" ;
    }
    
    
}
