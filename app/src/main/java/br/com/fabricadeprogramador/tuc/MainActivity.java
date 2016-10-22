package br.com.fabricadeprogramador.tuc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    @Bind(R.id.etCodigoBarra)
    EditText codigoBarra;

    @Bind(R.id.etQuantidade)
    EditText quantidade;


    @Bind(R.id.tvDescricao)
    TextView descricao;

    @Bind(R.id.tvValor)
    TextView valor;


    @Bind(R.id.btnAddCesta)
    Button btnAddCesta;





    Produto produtoSelecionado;

    @OnClick(R.id.btnBuscar)
    public void buscar() {
        String cod = codigoBarra.getText().toString();
        produtoSelecionado = ProdutoService.buscarProduto(cod);
        if (produtoSelecionado != null) {
            //Display
            descricao.setText(produtoSelecionado.getDescricao());
            valor.setText(produtoSelecionado.getValor().toString());

            quantidade.setEnabled(true);
            quantidade.setVisibility(View.VISIBLE);
            btnAddCesta.setEnabled(true);
            btnAddCesta.setVisibility(View.VISIBLE);

        } else {
            Toast.makeText(this, "Produto não encontrado!", Toast.LENGTH_SHORT).show();
            descricao.setText("");
            valor.setText("");


            deixarInvisivel();
        }
    }

    @OnClick(R.id.btnMinhaCesta)
    public void minhaCesta(){
        Intent irParaCesta =  new Intent(this, CestaActivity.class);
        startActivity(irParaCesta);
    }


    private void deixarInvisivel() {
        quantidade.setEnabled(false);
        quantidade.setVisibility(View.INVISIBLE);
        btnAddCesta.setEnabled(false);
        btnAddCesta.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.btnAddCesta)
    public void adicionarCestar(){
        if (produtoSelecionado!=null){
                int qtd =  Integer.parseInt(quantidade.getText().toString());

                ItemCesta itemCesta = new ItemCesta(produtoSelecionado, qtd);

                ProdutoService.adicionarCesta(itemCesta);

                produtoSelecionado =  null;

                deixarInvisivel();

                Toast.makeText(this, "Adicionado com Sucesso!", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ProdutoService.carregarProdutos();
    }
}
