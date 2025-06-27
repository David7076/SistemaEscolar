package Entidades_Reais;

import Entidades_Irreais.Curso;
import Entidades_Irreais.Endereco;

public class Aluno extends Pessoa{
    private String rm;
    private Curso curso;

    public Aluno(String nome, int idade, String cpf, Endereco endereco, String rm, Curso curso) {
        super(nome, idade, cpf, endereco);
        this.rm = rm;
        this.curso = curso;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String apresentarDados() {
        String aux = super.toString() + "\n RM: " + rm + "\n Curso: " + curso.getNome();
        return aux;
    }
}
