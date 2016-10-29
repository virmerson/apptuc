package br.com.fabricadeprogramador.tuc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Virmerson on 10/22/16.
 */
public class ProdutoService {

  private static List<Produto> produtoList = new ArrayList<>();


    private  static List<ItemCesta> cestaList = new ArrayList<>();

    /* public static Produto buscarProduto(String cod) {

        for (int i = 0; i < produtoList.size(); i++) {
            //Comparando cada produto
            if (produtoList.get(i).getCodigoBarra().equals(cod)) {
                //Produto encontrado
                return produtoList.get(i);
            }
        }
        return null;
    }*/

    public static Produto buscarProduto(String cod) {
            new Service().execute();
         return null;
    }


    public static void carregarProdutos() {

        produtoList.add(new Produto(1, "1001", "Banana", 1.0));
        produtoList.add(new Produto(2, "1002", "Pera", 2.0));
        produtoList.add(new Produto(3, "1003", "Maçã", 2.5));
        produtoList.add(new Produto(4, "1003", "Goiaba", 1.30));

    }

    public static void adicionarCesta(ItemCesta itemCesta){
        cestaList.add(itemCesta);
    }
    public static void removerCesta(ItemCesta itemCesta){
        cestaList.remove(itemCesta);
    }

    public static List<ItemCesta> getCestaList() {
        return cestaList;
    }


}
