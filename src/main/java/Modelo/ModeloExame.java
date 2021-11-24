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
public class ModeloExame extends ModeloAtendimento {

    private ModeloTipoExame exame;

    public ModeloExame(ModeloTipoExame exame, ModeloLocalAtendimento local, String hora, String data) {
        super(local, hora, data);
        this.exame = exame;
    }

    public ModeloTipoExame getExame() {
        return exame;
    }

    public void setExame(ModeloTipoExame exame) {
        this.exame = exame;
    }

    @Override
    public String toString() {
        return super.toString()+ "Exame: " + exame +"\n";
    }



}
