package Modelo;

public class ModeloConsulta extends ModeloAtendimento {

    private ModeloMedico medico;

    public ModeloConsulta(String data, String hora, ModeloUsuario usuario, ModeloMedico medico, ModeloLocalAtendimento local) {
        super(data, hora, usuario, local);
        this.medico = medico;
    }

    public ModeloMedico getMedico() {
        return medico;
    }

    public void setMedico(ModeloMedico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Especialidade: " + medico.getEspecialidade().getDescricao() +"\n"
             + "Médico: " + medico+"\n"
             + super.toString()+"\n";
    }

}