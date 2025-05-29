package Entidades_Irreais;

public class Curso {
    private String nome;
    private int duracao;
    private String instituicao;

    public Curso(String nome, int duracao, String instituicao) {
        this.nome = nome;
        this.duracao = duracao;
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
