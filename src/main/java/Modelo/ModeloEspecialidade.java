package Modelo;

public class ModeloEspecialidade {

    private Integer id;
    private String descricao;

    public ModeloEspecialidade(String especialidade) {
        this.descricao = especialidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String especialidade) {
        this.descricao = especialidade;
    }

    @Override
    public String toString() {
        return " " + descricao;
    }

}