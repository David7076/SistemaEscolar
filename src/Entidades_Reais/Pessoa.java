package Entidades_Reais;

import Entidades_Irreais.Endereco;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pessoa(String nome, int idade, String cpf, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public abstract String apresentarDados();

    @Override
    public String toString() {
        return  "Nome: " + nome  + " " +
                "\nIdade: " + idade +
                "\nCPF:" + cpf;

    }
}
