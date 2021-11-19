package Modelo;

public class ModeloEspecialidade {

    private String descricao;

    public ModeloEspecialidade(String especialidade) {
        this.descricao = especialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String especialidade) {
        this.descricao = especialidade;
    }

    @Override
    public String toString() {
        return " " + descricao ;
    }


}
