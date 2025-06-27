package Menu;

import Autenticavel.Autenticavel;
import Entidades_Irreais.Curso;
import Entidades_Irreais.Disciplina;
import Entidades_Irreais.Endereco;
import Entidades_Reais.*;

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
                    case 4:
                        buscarNome();
                        break;
                    case 5:
                        remove();
                        break;
                }
            }
        }

    }

    private void remove() {
        if(existeCadastro()) {
            String resp = showInputDialog("Digite o nome da pessoa que você deseja remover: ");
            for(Pessoa p : pessoa) {
                if(p.getNome().equalsIgnoreCase(resp)) {
                    pessoa.remove(p);
                    showMessageDialog(null, p.getNome() + " removido com sucesso!");
                }
            }
        }
        else {
            showMessageDialog(null, "Não é possível remover se não há pessoas cadastradas! ");
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
                int resp = parseInt(showInputDialog("Essa pessoa será o que no Sistema? " + gerartiposObjetos()));

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
                            Disciplina disciplina = new Disciplina("Programação Orientada a Objetos", "60 aulas");
                            Usuario usuario = cadastrarUsuario();
                            pessoa.add(new Professor(nome, idade, cpf, endereco, salario, disciplina, usuario));
                            break;
                        case 3:
                            String cargo = showInputDialog("Digite o cargo do Funcionário: ");
                            double salarioFuncionario = parseDouble(showInputDialog("Digite o salario do Funcionário: "));
                            Usuario usuarioFuncionario = cadastrarUsuario();
                            pessoa.add(new Funcionario(nome, idade, cpf, endereco, cargo, salarioFuncionario, usuarioFuncionario));
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


    private void listarPessoas() {
//        if(!pessoa.isEmpty()) {
//            for(Pessoa p : pessoa) {
//                showMessageDialog(null, p.apresentarDados());
//            }
//        }else
//            showMessageDialog(null, "Nenhuma pessoa foi cadastrada ainda! ");

        if (existeCadastro()) {
            for (Pessoa p : pessoa) {
                showMessageDialog(null, p.apresentarDados());
            }
        } else {
            showMessageDialog(null, "Não há pessoas cadastradas no sistema! ");
        }

    }

    private void autenticarLogin() {
        boolean autenticacao = false;

        if (existeCadastro()) {
            String user = showInputDialog("Digite seu usuário: ");
            String password = showInputDialog("Digite sua senha: ");
            for (Pessoa p : pessoa) {
                if (p instanceof Autenticavel) {
                    autenticacao = ((Autenticavel) p).autenticar(user, password);
                    if (autenticacao) {
                        showMessageDialog(null, "Autenticado com sucesso! ");
                        autenticacao = true;
                    }
                }
            }
            if (!autenticacao) {
                showMessageDialog(null, "Login inválido! ");
            }
        } else
            showMessageDialog(null, "Não há pessoas cadastradas para autenticar! ");

    }

    private void buscarNome() {
//        while (true) {
            if(existeCadastro()) {
                String nome = showInputDialog("Digite o nome da pessoa que você quer buscar: ").toLowerCase();
                for(Pessoa p : pessoa) {
                    if(p.getNome().toLowerCase().equals(nome)) {
                        showMessageDialog(null, p.apresentarDados());
                    }
                }
            }else{
                showMessageDialog(null, "Não há pessoas para buscar! ");
            }

//            if (numero == 2) {
//                while (true) {
//                    int num = parseInt(showInputDialog(gerartiposObjetos()));
//                    boolean numeroValido = (num == 1 || num == 2 || num == 3);
//                    if (numeroValido) {
//                        verficaTipoObjeto();
//                        break;
//                    } else {
//                        showMessageDialog(null, "Opção inválida! ");
//                    }
//                }
//                break;
//            } else if (numero == 1) {
//                boolean nomeEncontrado = false;
//                String nome = showInputDialog("Digite o nome que deseja buscar: ");
//                for (Pessoa p : pessoa) {
//                    if(nome.equalsIgnoreCase(p.getNome())) {
//                        showMessageDialog(null, p.apresentarDados());
//                        nomeEncontrado = true;
//                    }
//                }
//                if(!nomeEncontrado) {
//                    showMessageDialog(null, "Nenhum nome encontrado! ");
//                }
//            } else {
//                showMessageDialog(null, "Digite uma opção válida! ");
//            }
//        }




    }

    private String gerarMenu() {
        String aux = "Bem vindo ao Sistema Escolar";
        aux += "\n1 - Cadastrar Pessoa";
        aux += "\n2 - Listar todas as Pessoas";
        aux += "\n3 - Autenticar Login";
        aux += "\n4 - Buscar por nome";
        aux += "\n5 - Excluir pessoa";
        aux += "\n6 - Sair";
        return aux;
    }

    private String gerartiposObjetos() {
        String aux = "\n1 - Aluno"
                + "\n2 - Professor"
                + "\n3 - Funcionario";
        return aux;
    }

    private void verficaTipoObjeto() {
        for (Pessoa p : pessoa) {
            if (p instanceof Aluno) {
                showMessageDialog(null, p.apresentarDados());
            } else if (p instanceof Professor) {
                showMessageDialog(null, p.apresentarDados());
            } else {
                showMessageDialog(null, p.apresentarDados());
            }
        }
    }

    private boolean existeCadastro() {
        if (pessoa.isEmpty()) {
            return false;
        }
        return true;
    }

    private Usuario cadastrarUsuario() {
        Usuario usuario;
        String nomeUser = showInputDialog("Digite o nome de um usuario: ");
        String senha = showInputDialog("Digite uma senha para esse usuário: ");
        return usuario = new Usuario(nomeUser, senha);
    }


}
