package br.com.xavecoding.regesc.repository;

import br.com.xavecoding.regesc.orm.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*Usamos a anotação Repository para termos acesso a vários métodos para usar em nosso
* CRUD. Ele extende a interface CrudRepository, que recebe a classe e o tipo da primary key*/
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM professores p INNER JOIN disciplinas d ON p.id = d.professor_id WHERE p.nome LIKE " +
            ":nomeProfessor% AND d.nome LIKE :nomeDisciplina%")
    List<Professor> findProfessorAtribuido(String nomeProfessor, String nomeDisciplina);
}
