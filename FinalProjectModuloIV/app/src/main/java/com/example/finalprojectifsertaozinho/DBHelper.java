//**************************************************************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: MATHEUS FERREIRA DE OLIVEIRA COSTA

//**************************************************************************************************

package com.example.finalprojectifsertaozinho;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    //Variaveis necessarias para realizar a conexao com o banco de dados
    //Strings de conexao com nomes do bd, da tabela, comandos sql, etc
    private static final String DATABASE_NAME  = "bancodedados.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME  = "pessoafisica";

    private Context context;
    private SQLiteDatabase db;

    private SQLiteStatement insertStmt;
    private static final String INSERT = "insert into " + TABLE_NAME + " (nome,cpf,rg,nascimento,celular,email) values (?,?,?,?,?,?)";

    //Metodo construtor da classe
    public DBHelper(Context context) {

        this.context = context;
        OpenHelper openHelper = new OpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.insertStmt = this.db.compileStatement(INSERT);

    }

    //Metodo para inserir dados no banco de dados
    public long insert (String nome, String cpf, String rg, String nascimento, String celular, String email) {

        this.insertStmt.bindString(1, nome);
        this.insertStmt.bindString(2, cpf);
        this.insertStmt.bindString(3, rg);
        this.insertStmt.bindString(4, nascimento);
        this.insertStmt.bindString(5, celular);
        this.insertStmt.bindString(6, email);

        return this.insertStmt.executeInsert();
    }

    //Metodo para deletar todos os dados de uma tabela do banco de dados
    public void deleteAll() {

        this.db.delete(TABLE_NAME, null, null);
    }

    //Metodo para pegar todos os registros do banco de dados
    public List<PessoaFisica> queryGetAll() {
        List<PessoaFisica> list = new ArrayList<PessoaFisica>();

        try {
            Cursor cursor = this.db.query(TABLE_NAME, new String[]{"nome", "cpf", "rg", "nascimento", "celular", "email"},
            null, null, null, null, null, null);
            int nregistros = cursor.getCount();
            //Estrutura que verifica se existem dados registrados no banco de dados
            //E se existirem, percorre por todos os dados
            if(nregistros != 0) {
                cursor.moveToFirst();
                do {
                    PessoaFisica pessoaFisica = new PessoaFisica(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                    list.add(pessoaFisica);
                } while (cursor.moveToNext());

                //Estrutura para encerrar a conexao com o banco de dados
                if(cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return list;
            } else {
                return null;
            }
        } catch (Exception err) {
            return null;
        }
    }

    //Criando a classe OpenHelper, que implementa metodos abstratos da classe SQLiteOpenHelper
    private static class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {

            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT, cpf TEXT, rg TEXT, nascimento TEXT, celular TEXT, email TEXT);";
            db.execSQL(sql);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

}
