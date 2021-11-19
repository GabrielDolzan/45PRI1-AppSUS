package Estrutura;

import Modelo.ModeloUsuario;

public class Principal {

    public static Principal instance;
    public ModeloUsuario modeloUsuario;

    public static Principal getInstance() {
        if (instance == null) {
            instance = new Principal();
        }

        return instance;
    }

    public ModeloUsuario getModeloUsuario() {
        return modeloUsuario;
    }

    public void setModeloUsuario(ModeloUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }

}