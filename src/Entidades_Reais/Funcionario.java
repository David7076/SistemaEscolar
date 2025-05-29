package Entidades_Reais;

import Autenticavel.Autenticavel;
import Entidades_Irreais.Endereco;

public class Funcionario extends Pessoa implements Autenticavel {
    private String cargo;
    private double salario;
    private String user;
    private String senha;

    public Funcionario(String nome, int idade, String cpf, Endereco endereco, String cargo, double salario, String user, String senha) {
        super(nome, idade, cpf, endereco);
        this.cargo = cargo;
        this.salario = salario;
        this.user = user;
        this.senha = senha;
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        if(senha.equals(this.senha) && usuario.equals(this.user)) {
            return true;
        }
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
