package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ModeloMedico {
    private String nome;
    private ModeloEspecialidade especialidade;

    public ModeloMedico(String nome, ModeloEspecialidade especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ModeloEspecialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(ModeloEspecialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return  nome + " - "+ especialidade ;
    }


}
