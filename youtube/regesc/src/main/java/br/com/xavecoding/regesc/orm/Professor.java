package br.com.xavecoding.regesc.orm;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
/*Renomear tabela*/
@Table(name = "professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    /*Deixar coluna not null e valor único*/
    @Column(nullable = false, unique = true)
    private String prontuario;

    @Deprecated
    public Professor() {
    }

    /*Anotação de um para muitos mapeando meu objeto da classe Disciplina
    * cascade utiliza a verificação em cascata do sql para casos de integridade*/
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    /*Crio uma List para armazenar muitas disciplinas*/
    private Set<Disciplina> disciplinas;

    public Professor(String nome, String prontuario) {
        this.nome = nome;
        this.prontuario = prontuario;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
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

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    /*Anotação para alterar dados antes de exclusão (ON REMOVE SET NULL)*/
    @PreRemove
    public void atualizaDisciplinasOnRemove() {
        System.out.println("***** atualizaDisciplinasOnRemove *****");
        for (Disciplina disciplina : this.getDisciplinas()) {
            disciplina.setProfessor(null);
        }
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prontuario='" + prontuario + '\'' +
                '}';
    }
}
