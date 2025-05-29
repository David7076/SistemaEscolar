package Entidades_Reais;

import Autenticavel.Autenticavel;
import Entidades_Irreais.Endereco;

public class Funcionario extends Pessoa implements Autenticavel {
    private String cargo;
    private double salario;

    public Funcionario(String nome, int idade, String cpf, Endereco endereco, String cargo, double salario) {
        super(nome, idade, cpf, endereco);
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        return false;
    }

    @Override
    public String apresentarDados() {
        String aux = super.toString()
                + "\nCargo: " + cargo
        + "\nSalario: " + salario;
        return aux;
    }
}
