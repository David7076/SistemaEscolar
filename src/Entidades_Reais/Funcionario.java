package Entidades_Reais;

import Autenticavel.Autenticavel;
import Entidades_Irreais.Endereco;

public class Funcionario extends Pessoa implements Autenticavel {
    private String cargo;
    private double salario;
    private Usuario usuario;

    public Funcionario(String nome, int idade, String cpf, Endereco endereco, String cargo, double salario, Usuario usuario) {
        super(nome, idade, cpf, endereco);
        this.cargo = cargo;
        this.salario = salario;
        this.usuario = usuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        if(senha.equals(this.usuario.getSenha()) && usuario.equals(this.usuario.getUser())) {
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
