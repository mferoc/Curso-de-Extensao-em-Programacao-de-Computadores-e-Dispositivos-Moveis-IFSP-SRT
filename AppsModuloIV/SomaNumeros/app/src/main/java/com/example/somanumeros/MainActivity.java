package com.example.somanumeros;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Criando atributos, que terão valores vindos da tela

    EditText etNumeroA, etNumeroB, etResultado;
    Button btSomar;

    //Metodo construtor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Aqui ficam os códigos para inciar os atributos criados

        etNumeroA = (EditText) findViewById(R.id.etNumeroA);
        etNumeroB = (EditText) findViewById(R.id.etNumeroB);
        etResultado = (EditText) findViewById(R.id.etResultado);

        btSomar = (Button) findViewById(R.id.btSomar);

        btSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Quando houver um clique no botao somar, será
                //executado o codigo desse trecho de codigo

                float num1, num2, resultado;
                num1 = Float.parseFloat(etNumeroA.getText().toString());
                num2 = Float.parseFloat(etNumeroB.getText().toString());
                resultado = num1 + num2;


                String strResultado = String.valueOf(resultado);
                etResultado.setText(strResultado);

                //Colocando uma janela de mensagem para informar que a soma
                //foi realizada com sucesso

                AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(MainActivity.this);
                caixaAlerta.setMessage("Soma executada!");
                caixaAlerta.show();
            }
        });
    }
}
