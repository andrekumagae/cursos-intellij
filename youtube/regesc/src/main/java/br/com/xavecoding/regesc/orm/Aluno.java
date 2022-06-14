package br.com.xavecoding.regesc.orm;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String nome;
    private Integer idade;

    /*Anotação de n para n
    * Tem que ter o msm nome da List na classe Alunos*/
    @ManyToMany(mappedBy = "alunos")
    private Set<Disciplina> disciplinas;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
