package Modelo;

public class ModeloMedico {

    private String nome;
    private String telefone;
    private String rg;
    private ModeloEspecialidade especialidade;

    public ModeloMedico(String nome, ModeloEspecialidade especialidade, String telefone, String rg) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String imprimeDados() {
        return  "Medico: " +nome +  " - Especialidade:  " + especialidade ;
    }
    @Override
    public String toString() {
        return  nome + " - " + especialidade ;
    }
}