package Modelo;

public class ModeloConsulta extends ModeloAtendimento {

    private ModeloMedico medico;

    public ModeloConsulta(ModeloMedico medico, ModeloLocalAtendimento local, String hora, String data) {
        super(local, hora, data);
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
