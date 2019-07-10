//**************************************************************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: MATHEUS FERREIRA DE OLIVEIRA COSTA

//**************************************************************************************************

package com.example.finalprojectifsertaozinho;

public class PessoaFisica {

    //Declarando variaveis
    private String nome;
    private String cpf;
    private String rg;
    private String nascimento;
    private String celular;
    private String email;

    //Criando o metodo construtor
    PessoaFisica(String nome, String cpf, String rg, String nascimento, String celular, String email) {

        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.nascimento = nascimento;
        this.celular = celular;
        this.email = email;
    }

    //Criando os metodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
