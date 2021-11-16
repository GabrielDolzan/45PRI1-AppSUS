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
public class ModeloLocalAtendimento {
    private String localAtendimento;
    private String endereço;

    public ModeloLocalAtendimento(String localAtendimento, String endereço) {
        this.localAtendimento = localAtendimento;
        this.endereço = endereço;
    }

    public String getLocalAtendimento() {
        return localAtendimento;
    }

    public void setLocalAtendimento(String localAtendimento) {
        this.localAtendimento = localAtendimento;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
    
    

    @Override
    public String toString() {
        return "" + localAtendimento ;
    }
    
    
    
}
