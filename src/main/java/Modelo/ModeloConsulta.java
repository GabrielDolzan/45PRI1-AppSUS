package Modelo;

public class ModeloConsulta extends ModeloAtendimento {

    private ModeloMedico medico;

    public ModeloConsulta(ModeloMedico medico, ModeloLocalAtendimento local, String hora, String data, String status) {
        super(local, hora, data, status);
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
