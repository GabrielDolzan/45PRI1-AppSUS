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
public class ModeloConsulta extends ModeloAtendimento {
    private String areaDesejada;
    private ModeloMedico medico;

    public ModeloConsulta(String areaDesejada, ModeloMedico medico, ModeloLocalAtendimento local, String hora, String data) {
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

    public ModeloMedico getMedico() {
        return medico;
    }

    public void setMedico(ModeloMedico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Especialidade: " + areaDesejada +"\n"
             + "Médico: " + medico+"\n" ;
    }


}
