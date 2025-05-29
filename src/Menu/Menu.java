package Menu;

import Autenticavel.Autenticavel;
import Entidades_Irreais.Curso;
import Entidades_Irreais.Disciplina;
import Entidades_Irreais.Endereco;
import Entidades_Reais.Aluno;
import Entidades_Reais.Funcionario;
import Entidades_Reais.Pessoa;
import Entidades_Reais.Professor;

import static javax.swing.JOptionPane.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;


public class Menu {

    private List<Pessoa> pessoa = new ArrayList<>();


    //Método responsável por conter a lógica do programa
    public void logicaMenu() {
        int opcao;
        int resposta;
        while (true) {
            opcao = parseInt(showInputDialog(gerarMenu()));
            if (opcao == 6) {
                resposta = showConfirmDialog(null, "Tem certeza que deseja encerrar o programa? ");
                if (resposta == YES_OPTION)
                    break;
            } else if (opcao > 6 || opcao <= 0)
                showMessageDialog(null, "Opção inválida! ");
            else {
                switch (opcao) {
                    case 1:
                        cadastrarPessoa();
                        break;
                    case 2:
                        listarPessoas();
                        break;
                    case 3:
                        autenticarLogin();
                        break;
                }
            }
        }

    }



    private void cadastrarPessoa() {
//        String resp = showInputDialog("Você gostaria de cadastrar um Aluno, Professor ou um Funcionário? ");
//        while(true) {
//           if(resp != "Aluno" && resp != "Professor" && resp != "Funcionario")
//               showMessageDialog(null, "Resposta inválida! ");
//           else {
//               switch(resp) {
//                   case "Aluno":
//                       String nome = showInputDialog("Digite o nome do Aluno: ");
//                       int idade = parseInt(showInputDialog("Digite a idade do Aluno: "));
//                       String cpf = showInputDialog("Digite o CPF: ");
//               }
//           }
//        }
        String nome;
        int idade;
        String cpf;
        boolean pararLacoPrincipal = true;
        boolean pararLaco = true;

        while (pararLacoPrincipal) {

            pararLaco = true;
            nome = showInputDialog("Digite o nome: ");
            idade = parseInt(showInputDialog("Digite a idade: "));
            cpf = showInputDialog("Digite o cpf: ");
            Endereco endereco = new Endereco();

            while (pararLaco) {
                int resp = parseInt(showInputDialog("Essa pessoa será o que no Sistema? "
                        + "\n1 - Aluno"
                        + "\n2 - Professor"
                        + "\n3 - Funcionario"));

                if (resp < 1 || resp > 3) showMessageDialog(null, "Resposta inválida! ");
                else {
                    switch (resp) {
                        case 1:
                            String rm = showInputDialog("Digite o RM (Matrícula): ");
                            Curso curso = new Curso("Sistemas de Informação", 4, "FIAP");
                            pessoa.add(new Aluno(nome, idade, cpf, endereco, rm, curso));
                            break;
                        case 2:
                            double salario = parseDouble(showInputDialog("Salário do professor: "));
                            String user = showInputDialog("Digite o nome de um Usuario para o professor");
                            String password = showInputDialog("Digite a senha do professor:  ");
                            Disciplina disciplina = new Disciplina("Programação Orientada a Objetos", "60 aulas");
                            pessoa.add(new Professor(nome, idade, cpf, endereco, salario, disciplina));
                            break;
                        case 3:
                            String cargo = showInputDialog("Digite o cargo do Funcionário: ");
                            double salarioFuncionario = parseDouble(showInputDialog("Digite o salario do Funcionário: "));
                            String users = showInputDialog("Digite o nome de um Usuario para o professor");
                            String passwords = showInputDialog("Digite a senha do professor:  ");
                            pessoa.add(new Funcionario(nome, idade, cpf, endereco, cargo, salarioFuncionario, users, passwords));
                            break;
                    }
                    int num = parseInt(showInputDialog("Deseja cadastrar mais alguma pessoa? " +
                            "\n1- SIM" +
                            "\n2- NÃO"));
                    if (num == 2) {
                        pararLaco = false;
                        pararLacoPrincipal = false;
                    } else {
                        pararLaco = false;
                    }
                }
            }
        }
    }

    public void listarPessoas() {
        for(Pessoa p : pessoa) {
            showMessageDialog(null, p.apresentarDados());
        }
    }

    private void autenticarLogin() {
        boolean autenticacao = false;
        String user = showInputDialog("Digite seu usuário: ");
        String password = showInputDialog("Digite sua senha: ");

        for(Pessoa p : pessoa) {
            if(p instanceof Autenticavel) {
                 autenticacao = ((Autenticavel) p).autenticar(user, password);
                if(autenticacao)
                    showMessageDialog(null, p.apresentarDados());
                else
                    showMessageDialog(null, "Usuário ou senha incorretos! ");
            }
        }
    }


    public String gerarMenu() {
        String aux = "Bem vindo ao Sistema Escolar";
        aux += "\n1 - Cadastrar Pessoa";
        aux += "\n2 - Listar todas as Pessoas";
        aux += "\n3 - Autenticar Login";
        aux += "\n4 - Buscar por nome ou tipo";
        aux += "\n5 - Excluir pessoa";
        aux += "\n6 - Sair";
        return aux;
    }
}
