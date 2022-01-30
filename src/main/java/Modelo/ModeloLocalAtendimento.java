package Modelo;

public class ModeloLocalAtendimento {

    private Integer id;
    private String telefone;
    private String endereco;

    public ModeloLocalAtendimento(String telefone, String endereco) {
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String imprimeDados() {
        return "Endereço: " + endereco + ", telefone: " + telefone;
    }

    @Override
    public String toString() {
        return  endereco ;
    }

}