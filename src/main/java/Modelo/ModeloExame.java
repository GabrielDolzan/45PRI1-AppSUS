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
public class ModeloExame extends Atendimento {
    
    private String exame;

    public ModeloExame(String exame, LocalAtendimento local, String hora, String data) {
        super(local, hora, data);
        this.exame = exame;
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    @Override
    public String toString() {
        return super.toString()+ "Exame: " + exame +"\n";
    }
    
    
    
}
