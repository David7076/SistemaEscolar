package Entidades_Reais;

import Autenticavel.Autenticavel;
import Entidades_Irreais.Disciplina;
import Entidades_Irreais.Endereco;

public class Professor extends Pessoa implements Autenticavel {
    private double salario;
    private Disciplina disciplina;

    public Professor(String nome, int idade, String cpf, Endereco endereco, double salario, Disciplina disciplina) {
        super(nome, idade, cpf, endereco);
        this.salario = salario;
        this.disciplina = disciplina;
    }

    @Override
    public String apresentarDados() {
        String aux = super.toString() + "\nSalario: " + salario + "\nDisciplina coordenada: " + disciplina.getNome();
        return aux;
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        return false;
    }
}
