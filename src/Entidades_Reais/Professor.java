package Entidades_Reais;

import Autenticavel.Autenticavel;
import Entidades_Irreais.Disciplina;
import Entidades_Irreais.Endereco;

public class Professor extends Pessoa implements Autenticavel  {
    private double salario;
    private Disciplina disciplina;
    private Usuario usuario;

    public Professor(String nome, int idade, String cpf, Endereco endereco, double salario, Disciplina disciplina, Usuario usuario) {
        super(nome, idade, cpf, endereco);
        this.salario = salario;
        this.disciplina = disciplina;
        this.usuario = usuario;
    }

    @Override
    public String apresentarDados() {
        String aux = super.toString() + "\nSalario: " + salario + "\nDisciplina coordenada: " + disciplina.getNome();
        return aux;
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        if(senha.equals(this.usuario.getSenha()) && usuario.equals(this.usuario.getUser())) {
            return true;
        }
        return false;
    }

//    @Override
//    public boolean autenticar(String usuario, String senha) {
//        if(senha.equals(this.senha) && usuario.equals(this.user)) {
//            return true;
//        }
//        return false;
//    }
}
