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
public abstract class ModeloAtendimento {

    private ModeloLocalAtendimento local;
    private String hora;
    private String data;
    private ModeloUsuario usuario;

    public ModeloAtendimento(ModeloLocalAtendimento local, String hora, String data) {
        this.local = local;
        this.hora = hora;
        this.data = data;
    }

    public ModeloLocalAtendimento getLocal() {
        return local;
    }

    public void setLocal(ModeloLocalAtendimento local) {
        this.local = local;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ModeloUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(ModeloUsuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Local do atendimento: " + local +"\n"
             + "Data: " + data +"\n"
             + "Horario: " + hora+ "\n";
    }



}
