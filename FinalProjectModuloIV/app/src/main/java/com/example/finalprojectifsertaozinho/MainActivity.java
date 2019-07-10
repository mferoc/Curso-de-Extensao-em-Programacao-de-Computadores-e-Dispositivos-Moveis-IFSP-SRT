//**************************************************************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: MATHEUS FERREIRA DE OLIVEIRA COSTA

//**************************************************************************************************

package com.example.finalprojectifsertaozinho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Variavel para fazer o binding do objeto da classe com o que aparece na tela do app
    Button btInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btInsert = (Button) findViewById(R.id.btInserir);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chamaInsertPage();
            }
        });
    }

    //Metodo para levar a tela de insercao de dados atraves de um botao
    void chamaInsertPage() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, InsertActivity.class);
        startActivity(intent);
        finish();
    }
}
