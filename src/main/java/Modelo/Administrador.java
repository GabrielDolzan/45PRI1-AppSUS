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
public class Administrador {
    private String eMail;
    private String nome;
    private String senha;

    public Administrador(String eMail, String nome, String senha) {
        this.eMail = eMail;
        this.nome = nome;
        this.senha = senha;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "E-mail: " + eMail + "\n"+
               "Nome: " + nome +"\n";
    }
    
    
    
}
