package Entidades_Reais;

import Entidades_Irreais.Endereco;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private Endereco endereco;

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
