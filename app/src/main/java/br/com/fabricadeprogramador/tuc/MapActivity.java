package br.com.fabricadeprogramador.tuc;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import butterknife.ButterKnife;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ButterKnife.bind(this);
        MapFragment map =  (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        map.getMapAsync(this);
    }

    GoogleMap googleMap;

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        this.googleMap = googleMap;
        new BuscarLocaisTask().execute();




    }


    private  class BuscarLocaisTask extends AsyncTask<String, Void, List<LatLng>> {

        ProgressDialog dialog;
        //ANTES DA TAREFA PESADA
        @Override
        protected void onPreExecute() {

            dialog = ProgressDialog.show(MapActivity.this, "Buscando ...", "Buscando...", true);
            //Exibe
            super.onPreExecute();
        }

        //TAREFA PESADA
        @Override
        protected  ArrayList<LatLng> doInBackground(String... params) {
            try {


                //SPRING ANDROID
                final String url = "http://192.168.25.17:8080/mapas/" ;
                //Cria um objeto que permite requests no padrao REst
                RestTemplate restTemplate = new RestTemplate();
                //Configura o Gerenciado de Json (Converson)
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                //faz o request para web e pega o retorno já convertido em object
              //  List<LatLng> locais = restTemplate.getForObject(url, List.class);

                ResponseEntity<? extends ArrayList<LatLng>> locais =
                 restTemplate.getForEntity(url, (Class<? extends ArrayList<LatLng>>)ArrayList.class);


                return  locais.getBody();

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }


        /**
         * CALL BACK - APÓS A TAREFA PESADA
         * @param lista
         */
        @Override
        protected void onPostExecute(List<LatLng> lista) {
            dialog.dismiss();
            //Ocultar

            for (LatLng local : lista) {
                googleMap.addMarker(new MarkerOptions().position(local));
            }

        }



    }


}
