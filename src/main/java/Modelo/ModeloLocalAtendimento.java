package Modelo;

public class ModeloLocalAtendimento {

    private String telefone;
    private String endereco;

    public ModeloLocalAtendimento(String telefone, String endereco) {
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Endereço: " + endereco + ", telefone: " + telefone;
    }

}