package com.example.lojadelivros;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    //Declarar os objetos relativos a parte gráfica no Java

    Button btPurchase;
    CheckBox cbBook1, cbBook2, cbBook3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //O que será executado após a inicialização do aplicativo

        //Associando os objetos do código Java aos seus respectivos na tela do app
        btPurchase = (Button) findViewById(R.id.btComprar);
        cbBook1 = (CheckBox) findViewById(R.id.cbLivro1);
        cbBook2 = (CheckBox) findViewById(R.id.cbLivro2);
        cbBook3 = (CheckBox) findViewById(R.id.cbLivro3);

        //Programando o evendo do botão comprar
        //ação executada após clicar no botão comprar
        btPurchase.setOnClickListener(new View.OnClickListener() {

            //Será executado o que estiver dentro do método onClick
            @Override
            public void onClick(View v) {

                String message = "Você comprou os seguintes livros:\n";

                //Verificando quais livros foram selecionados no CheckBox
                if(cbBook1.isChecked()) {

                    message = message + "\nLinux completo e total";
                }
                if(cbBook2.isChecked()) {

                    message = message + "\nJava completo e total";
                }
                if(cbBook3.isChecked()) {

                    message = message + "\nJavascript completo e total";
                }

                //Mostrando a messagem para o usuário
                //usando uma caixa de alerta

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                //setando a mensagem que será exibida na tela
                alertDialog.setMessage(message);
                //mostrando de fato a caixa de alerta na tela
                //a mensagem será exibida apenas se algum livro foi selecionado
                if(cbBook1.isChecked() || cbBook2.isChecked() || cbBook3.isChecked()) {

                    alertDialog.show();
                } else {

                    message = message + "\nOps, nenhum livro comprado!";
                    alertDialog.setMessage(message);
                    alertDialog.show();
                }

                //FAZENDO O CELULAR VIBRAR AO ACIONAR O BOTAO
                vibrar();

            }
        });

    }
    //Criando o metodo vibrar
    //metodo deve ser criado na classe principal fora do onCreate
    private void vibrar( ) {
        //Utilizando o serviço do vibração do celular
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Defininfo um tempo em milisegundos
        long ms = 100;

        //é necessário que o app diga para o SO que irá utilizar um recurso de hardware
        //isso deve ser definido no arquivo AndroidManifest.xml
        vb.vibrate(ms);
    }
}
