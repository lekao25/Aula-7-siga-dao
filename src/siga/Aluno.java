package siga;

public class Aluno {

    private int matricula;
    private String nome;
    private double media;

    public Aluno(String nome, double media) {
        this.nome = nome;
        this.media = media;
    }

    public Aluno(int matricula, String nome, double media) {
        this.matricula = matricula;
        this.nome = nome;
        this.media = media;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", media=" + media +
                '}';
    }
}
