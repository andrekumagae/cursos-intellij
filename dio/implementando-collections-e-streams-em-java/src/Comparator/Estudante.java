package Comparator;

public class Estudante implements Comparable<Estudante> {
    private String nome;
    private Integer idade;

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Estudante(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public int compareTo(Estudante o) {
        return Integer.compare(this.getIdade(), o.getIdade());
    }
}
