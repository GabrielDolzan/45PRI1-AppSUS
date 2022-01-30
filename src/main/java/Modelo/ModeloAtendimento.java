package Modelo;

public abstract class ModeloAtendimento {

    private Integer id;
    private ModeloLocalAtendimento local;
    private String hora;
    private String data;
    private ModeloUsuario usuario;
    private String status;

    public ModeloAtendimento(String data, String hora, ModeloUsuario usuario, ModeloLocalAtendimento local/*, String status*/) {
        this.hora = hora;
        this.data = data;
        this.usuario = usuario;
        this.local = local;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ModeloLocalAtendimento getLocal() {
        return local;
    }

    public void setLocal(ModeloLocalAtendimento local) {
        this.local = local;
    }

    public String getStatus() {
        return status;
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
             + "Telefone: "+ local.getTelefone()+"\n"
             + "Data: " + data +"\n"
             + "Horario: " + hora+ "\n";
    }



}
