//**************************************************************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: MATHEUS FERREIRA DE OLIVEIRA COSTA

//**************************************************************************************************

package com.example.finalprojectifsertaozinho;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class InsertActivity extends AppCompatActivity {

    //Declarando variaveis necessarias para fazer o binding dos objeto da classe com o que aparece
    // na tela do app
    //Criando uma instancia da classe DBHelper para utilizar os seus metodos
    Button btInicio;

    private DBHelper dh;
    EditText etNome, etCpf, etRg, etNascimento, etCelular, etEmail;
    Button btInserir, btListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        //Necessario para voltar a tela inicial quando usado o botao inicio na tela de insercao
        btInicio = (Button) findViewById(R.id.btHome);
        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chamaHomePage();
            }
        });

        //Fazendo o binding das variaveis, definindo a relacao dos objetos da classe com o que
        //aparece na tela do app
        this.dh = new DBHelper(this);
        etNome = (EditText) findViewById(R.id.etInserirNome);
        etCpf = (EditText) findViewById(R.id.etInserirCPF);
        etRg = (EditText) findViewById(R.id.etInserirRG);
        etNascimento = (EditText) findViewById(R.id.etInserirNacimento);
        etCelular = (EditText) findViewById(R.id.etInserirCelular);
        etEmail = (EditText) findViewById(R.id.etInserirEmail);

        btInserir = (Button) findViewById(R.id.btInsert);
        btListar = (Button) findViewById(R.id.btList);

        //Acao do botao inserir
        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //INSERIR NO BANCO DE DADOS OS VALORES QUE ESTÃO NOS CAMPOS EDIT_TEXT
                if(etNome.getText().length() > 0 && etCpf.getText().length() > 0 && etRg.getText().length() > 0 && etNascimento.getText().length() > 0 && etCelular.getText().length() > 0 && etEmail.getText().length() > 0) {

                    dh.insert(etNome.getText().toString(), etCpf.getText().toString(), etRg.getText().toString(), etNascimento.getText().toString(), etCelular.getText().toString(), etEmail.getText().toString());
                    AlertDialog.Builder adb = new AlertDialog.Builder(InsertActivity.this);
                    adb.setTitle("Sucesso!!!");
                    adb.setMessage("Os dados foram cadastrados.");
                    adb.show();

                    etNome.setText("");
                    etCpf.setText("");
                    etRg.setText("");
                    etNascimento.setText("");
                    etCelular.setText("");
                    etEmail.setText("");
                } else {

                    AlertDialog.Builder adb = new AlertDialog.Builder(InsertActivity.this);
                    adb.setTitle("Erro!!!");
                    adb.setMessage("Todos os campos devem ser preenchidos.");
                    adb.show();

                    etNome.setText("");
                    etCpf.setText("");
                    etRg.setText("");
                    etNascimento.setText("");
                    etCelular.setText("");
                    etEmail.setText("");
                }
            }
        });

        //Acao do botao listar
        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mostrar a lista de dados que ja foram registrados
                List<PessoaFisica> pessoas = dh.queryGetAll();

                //Decisao para verificar se existe algum registro no banco de dados e mostrar uma
                //mensagem caso não haja
                if(pessoas == null) {

                    AlertDialog.Builder adb = new AlertDialog.Builder(InsertActivity.this);
                    adb.setTitle("Erro!!!");
                    adb.setMessage("Não existem registros cadastrados.");
                    adb.show();

                    //saindo da funcao
                    return;
                }

                //Este laco percorre toda a lista de registros 1 a 1
                for (int i = 0; i < pessoas.size(); i++) {

                    PessoaFisica pessoaFisica = (PessoaFisica) pessoas.get(i);

                    AlertDialog.Builder adb = new AlertDialog.Builder(InsertActivity.this);
                    adb.setTitle("Pessoa " + (i + 1));
                    adb.setMessage("Nome: " + pessoaFisica.getNome()+ "\nCPF: "+ pessoaFisica.getCpf() + "\nRG: " +  pessoaFisica.getRg() +"\nData de Nascimento: " + pessoaFisica.getNascimento() + "\nCelular: " + pessoaFisica.getCelular() + "\nE-mail: " + pessoaFisica.getEmail());
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //SERA EXECUTADO AO CLICAR NO BOTAO OK DA CAIXA DE DIALOGO
                            //Funcao: Mostrar uma janela com um registro
                            //apertar ok e ir para a proxima janela com proximo registro
                            dialog.dismiss();
                        }
                    });

                    adb.show();

                }
            }
        });

    }

    //Metodo para adicionar acao ao botao inicio na tela de insercao de dados
    void chamaHomePage() {
        Intent intent = new Intent();
        intent.setClass(InsertActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
