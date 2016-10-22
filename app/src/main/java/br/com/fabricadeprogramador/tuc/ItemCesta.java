package br.com.fabricadeprogramador.tuc;

/**
 * Created by Virmerson on 10/22/16.
 */
public class ItemCesta {

    private Produto produto;
    private int quantidade;

    public ItemCesta(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemCesta() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return getProduto().getDescricao() +" " + getProduto().getValor()  +" "+ getQuantidade() ;
    }
}
