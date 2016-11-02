package br.com.fabricadeprogramador.tuc;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Virmerson on 10/22/16.
 */
public class ProdutoService {

    private static List<Produto> produtoList = new ArrayList<>();

    private static Produto produto;

    private static List<ItemCesta> cestaList = new ArrayList<>();

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
        try {

            //SPRING ANDROID
            final String url = "http://192.168.25.17:8080/produtos/" + cod;
            //Cria um objeto que permite requests no padrao REst
            RestTemplate restTemplate = new RestTemplate();
           //Configura o Gerenciado de Json (Converson)
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            //faz o request para web e pega o retorno já convertido em object
            Produto produto = restTemplate.getForObject(url, Produto.class);
            return produto;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }


    public static void carregarProdutos() {

        produtoList.add(new Produto(1, "1001", "Banana", 1.0));
        produtoList.add(new Produto(2, "1002", "Pera", 2.0));
        produtoList.add(new Produto(3, "1003", "Maçã", 2.5));
        produtoList.add(new Produto(4, "1003", "Goiaba", 1.30));

    }

    public static void adicionarCesta(ItemCesta itemCesta) {
        cestaList.add(itemCesta);
    }

    public static void removerCesta(ItemCesta itemCesta) {
        cestaList.remove(itemCesta);
    }

    public static List<ItemCesta> getCestaList() {
        return cestaList;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


}
