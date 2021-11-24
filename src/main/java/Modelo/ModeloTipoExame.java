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
public class ModeloTipoExame {
    
    private String descricao;

    public ModeloTipoExame(String exame) {
        this.descricao = exame;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String exame) {
        this.descricao = exame;
    }

    @Override
    public String toString() {
        return " " + descricao ;
    }
}
