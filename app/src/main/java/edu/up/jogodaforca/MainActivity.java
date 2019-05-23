package edu.up.jogodaforca;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imgForca;
    private TextView txtLetrasErradas, txtPalavra;
    private EditText edtLetra;
    private Button btnVerificar;

    private String palavra;

    private char[] vetorPalavraInteira;
    private String[] vetorPalpite;

    private ArrayList<String> letrasErradas =  new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sortearPalavra();

        imgForca = (ImageView) findViewById(R.id.imgForca);
        txtLetrasErradas = (TextView) findViewById(R.id.txtLetrasErradas);
        txtPalavra = (TextView) findViewById(R.id.txtPalavra);
        edtLetra = (EditText) findViewById(R.id.edtLetra);
        btnVerificar = (Button) findViewById(R.id.btnVerificar);

        vetorPalavraInteira = palavra.toCharArray();
        vetorPalpite = new String[palavra.length()];

        for(int i = 0; i< vetorPalavraInteira.length; i++)
        {
            vetorPalpite[i] = "_";
            txtPalavra.setText(txtPalavra.getText() + "_ ");
        }

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Encontrar uma alternativa para letras maiúsculas e minúsculas
                String letra = edtLetra.getText().toString().toUpperCase();

                //Limpando a caixa de texto
                edtLetra.setText("");

                if(palavra.toUpperCase().contains(letra)){

                    for(int i=0; i < vetorPalavraInteira.length; i++)
                    {
                        if(vetorPalavraInteira[i] == letra.charAt(0)){
                            //Para imprimir no Log os valores paara efetuar verificação
                            //Log.i("Index", String.valueOf(i));

                            vetorPalpite[i] = String.valueOf(vetorPalavraInteira[i]);
                            desenharPalavra();
                        }
                    }
                    //Toast.makeText(MainActivity.this, "Tem", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(letrasErradas.contains(letra))
                    {
                        Toast.makeText(MainActivity.this, "Esta letra já foi selecionada!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        letrasErradas.add(letra);
                        //Toast.makeText(MainActivity.this, "Não Tem", Toast.LENGTH_SHORT).show();
                    }

                    trocarImagem(letrasErradas.size());
                    desenharLetrasErradas();

                    //txtLetrasErradas.setText(letrasErradas.toString());
                }
                if(verificarFim())
                {
                    Toast.makeText(MainActivity.this, "Parabéns! You WIN!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void desenharPalavra()
    {
        txtPalavra.setText("");
        for(int i = 0; i < vetorPalpite.length; i++)
        {
            txtPalavra.setText(txtPalavra.getText() + vetorPalpite[i] + " ");
        }
    }

    private boolean verificarFim()
    {
        for(int i = 0; i < vetorPalpite.length; i++)
        {
            if(vetorPalpite[i] == "_")
            {
                return false;
            }
        }
        exibirMensagemSucesso();
        return true;
    }

    private void desenharLetrasErradas()
    {
        txtLetrasErradas.setText("");
       for(String letraErrada : letrasErradas)
       {
           txtLetrasErradas.setText(txtLetrasErradas.getText() + letraErrada + " - ");
       }
    }

    private void trocarImagem(int qtdeErro)
    {
        switch (qtdeErro){
            case 1:
                imgForca.setImageResource(R.drawable.image2);
                break;
            case 2:
                imgForca.setImageResource(R.drawable.image3);
                break;
            case 3:
                imgForca.setImageResource(R.drawable.image4);
                break;
            case 4:
                imgForca.setImageResource(R.drawable.image5);
                break;
            case 5:
                imgForca.setImageResource(R.drawable.image6);
                break;
            case 6:
                imgForca.setImageResource(R.drawable.image7);
                break;
            case 7:
                imgForca.setImageResource(R.drawable.image8);
                break;
            case 8:
                imgForca.setImageResource(R.drawable.image9);

                Toast.makeText(this, "Que pena! You LOSE!", Toast.LENGTH_SHORT).show();
                btnVerificar.setEnabled(false);

                txtPalavra.setText("");
                String palavraFim = "";
                for(int i=0; i < vetorPalavraInteira.length; i++)
                {
                    palavraFim = palavraFim + " " + vetorPalavraInteira[i];
                }
                txtPalavra.setText(palavraFim);
                exibirMensagemErro();
                break;
            default:
                break;
        }
    }

    private void exibirMensagemErro(){
        //Caixa de Mensagem
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        //Conteúdo da Mensagem
        builder.setTitle("You Lose!");
        builder.setMessage("Deseja reiniciar?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reiniciarJogo();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void exibirMensagemSucesso(){
        //Caixa de Mensagem
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        //Conteúdo da Mensagem
        builder.setTitle("You WIN!");
        builder.setMessage("Deseja reiniciar?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reiniciarJogo();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void reiniciarJogo()
    {
        btnVerificar.setEnabled(true);
        txtLetrasErradas.setText("");
        txtPalavra.setText("");
        letrasErradas.clear();
        imgForca.setImageResource(R.drawable.image1);
        sortearPalavra();
        iniciarJogo();
    }

    private void sortearPalavra(){
        palavra = ListaDePalavras.retornarPalavra().toUpperCase();
    }

    private void iniciarJogo()
    {
        vetorPalavraInteira = palavra.toCharArray();
        vetorPalpite = new String[palavra.length()];

        for(int i = 0; i< vetorPalavraInteira.length; i++)
        {
            vetorPalpite[i] = "_";
            txtPalavra.setText(txtPalavra.getText() + "_ ");
        }
    }
}
