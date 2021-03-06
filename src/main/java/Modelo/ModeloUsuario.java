package Modelo;

public class ModeloUsuario {

    private String estado;
    private String cidade;
    private String nome;
    private String cpf;
    private String celular;
    private String nascimento;
    private String sexo;
    private String email;
    private String senha;

    public ModeloUsuario(String estado, String cidade, String nome, String CPF, String celular, String nascimento, String sexo, String eMail, String senha) {
        this.estado = estado;
        this.cidade = cidade;
        this.nome = nome;
        this.cpf = CPF;
        this.celular = celular;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.email = eMail;
        this.senha = senha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String CPF) {
        this.cpf = CPF;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String eMail) {
        this.email = eMail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Estado: " + estado + "\n"+
               "Cidade: " + cidade + "\n"+
               "Usuario: " + nome + "\n"+
               "CPF: " + cpf +"/n"+
               "Celular: " + celular + "\n"+
               "Data de Nascimento: " + nascimento + "\n"+
               "Sexo: " + sexo + "\n"+
               "E-mail: " + email +"\n";
    }


}
