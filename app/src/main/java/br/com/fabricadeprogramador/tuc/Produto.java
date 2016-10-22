package br.com.fabricadeprogramador.tuc;

/**
 * Created by Virmerson on 10/22/16.
 */
public class Produto {

    private Integer id;
    private String codigoBarra;
    private String descricao;
    private Double valor;

    public Produto() {
    }

    public Produto(Integer id, String codigoBarra, String descricao, Double valor) {
        this.id = id;
        this.codigoBarra = codigoBarra;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
