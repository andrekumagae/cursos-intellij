package br.com.dio.maps.paraSaberMais.ObjetoSet;

public class Curso implements Comparable<Curso> {
    private String nome;
    private Integer duracao;

    public Curso(String nome, Integer duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                '}';
    }

    @Override
    public int compareTo(Curso o) {
        return this.getNome().compareToIgnoreCase(o.getNome());
    }
}
