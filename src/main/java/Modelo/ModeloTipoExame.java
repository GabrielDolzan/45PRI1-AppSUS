package Modelo;

public class ModeloTipoExame {

    private Integer id;
    private String descricao;

    public ModeloTipoExame(String exame) {
        this.descricao = exame;
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

    public void setDescricao(String exame) {
        this.descricao = exame;
    }

    @Override
    public String toString() {
        return " " + descricao ;
    }
}
