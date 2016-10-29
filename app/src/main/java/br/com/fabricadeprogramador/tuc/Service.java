package br.com.fabricadeprogramador.tuc;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Virmerson on 10/29/16.
 */
public class Service extends AsyncTask<Void, Void, Produto> {
        @Override
        protected Produto doInBackground(Void... params) {
            try {
                final String url = "http://192.168.25.17:8080/produtos/1001";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Produto produto = restTemplate.getForObject(url, Produto.class);
                return produto;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Produto produto) {
            //
        }

    }

