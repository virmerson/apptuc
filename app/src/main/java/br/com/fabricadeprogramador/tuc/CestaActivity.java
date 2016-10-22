package br.com.fabricadeprogramador.tuc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CestaActivity extends AppCompatActivity {


    @Bind(R.id.lvCesta)
    ListView lvCesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);
        ButterKnife.bind(this);

        List<ItemCesta> cestaList  =  ProdutoService.getCestaList();

        ArrayAdapter<ItemCesta> adapter = new ArrayAdapter<ItemCesta>(this, android.R.layout.simple_list_item_1, cestaList);

        lvCesta.setAdapter(adapter);
    }
}
