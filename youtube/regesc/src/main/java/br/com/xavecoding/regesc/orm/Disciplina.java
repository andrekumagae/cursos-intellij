package br.com.xavecoding.regesc.orm;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="disciplinas")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private Integer semestre;


    @Deprecated
    public Disciplina() {

    }

    /*Anotação Muitos para um do lado da disciplina
    * fetch type eager permite carregar todos os dados
    * das tabelas, ao contrário do padrão, que é lazy*/
    @ManyToOne(fetch = FetchType.EAGER)
    /*Indico a minha foreign key que nesse caso pode ser nula*/
    @JoinColumn(name= "professor_id", nullable = true)
    private Professor professor;

    /*Anotação de muitos para muitos
    * Faço junção de 2 tabelas e informo as suas chaves estrangeiras*/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "disciplinas_alunos",
            joinColumns = @JoinColumn(name = "disciplina_fk"),
            inverseJoinColumns = @JoinColumn(name = "aluno_fk")
    )
    private Set<Aluno> alunos;

    public Disciplina(String nome, Integer semestre, Professor professor) {
        this.nome = nome;
        this.semestre = semestre;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", semestre=" + semestre +
                ", professor=" + professor +
                ", alunos=" + alunos +
                '}';
    }
}
