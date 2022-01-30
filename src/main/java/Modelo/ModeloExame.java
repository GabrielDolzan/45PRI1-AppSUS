package Modelo;

public class ModeloExame extends ModeloAtendimento {

    private ModeloTipoExame tipoExame;

    public ModeloExame(String data, String hora, ModeloUsuario usuario, ModeloTipoExame exame, ModeloLocalAtendimento local/*, String status*/) {
        super(data, hora, usuario, local);
        this.tipoExame = exame;
    }

    public ModeloTipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(ModeloTipoExame exame) {
        this.tipoExame = exame;
    }

    @Override
    public String toString() {
        return super.toString()+ "Exame: " + tipoExame +"\n";
    }

}