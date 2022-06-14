package br.com.xavecoding.regesc.repository;

import br.com.xavecoding.regesc.orm.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    List<Aluno> findByNomeStartingWith(String nome);
    List<Aluno> findByNomeStartingWithAndIdadeLessThanEqual(String nome, Integer idade);

    @Query("SELECT a FROM Aluno a WHERE a.nome like :nome% AND a.idade >= :idade")
    List<Aluno> findNomeIdadeIgualOuMaior(String nome, Integer idade);

    @Query("SELECT a FROM Aluno a INNER JOIN a.disciplinas d WHERE a.nome like :nome% AND a.idade >= :idade AND d" +
            ".nome LIKE :disciplina%")
    List<Aluno> findNomeIdadeIgualOuMaiorMatriculado(String nome, Integer idade, String disciplina);
}
