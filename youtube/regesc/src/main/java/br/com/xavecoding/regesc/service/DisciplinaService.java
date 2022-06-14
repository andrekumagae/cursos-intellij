package br.com.xavecoding.regesc.service;

import br.com.xavecoding.regesc.orm.Aluno;
import br.com.xavecoding.regesc.orm.Disciplina;
import br.com.xavecoding.regesc.orm.Professor;
import br.com.xavecoding.regesc.repository.AlunoRepository;
import br.com.xavecoding.regesc.repository.DisciplinaRepository;
import br.com.xavecoding.regesc.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class DisciplinaService {
    /*Criamos uma instância do repositório para injetar as dependências nesta classe*/
    private DisciplinaRepository disciplinaRepository;
    private ProfessorRepository professorRepository;
    private AlunoRepository alunoRepository;

    /*Injetamos no construtor. Com isso, temos acesso aos métodos da interface CrudRepository*/
    public DisciplinaService(DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository,
                             AlunoRepository alunoRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
    }

    public void menu(Scanner scanner) {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("\nQual ação você deseja executar?");
            System.out.println("1 - Cadastrar nova disciplina");
            System.out.println("2 - Atualizar uma disciplina");
            System.out.println("3 - Mostrar todos as disciplinas");
            System.out.println("4 - Deletar uma disciplina");
            System.out.println("5 - Matricular alunos");
            System.out.println("9 - Voltar ao menu anterior");
            System.out.println("0 - Encerrar programa");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.cadastrar(scanner);
                    break;
                case 2:
                    this.atualizar(scanner);
                    break;
                case 3:
                    this.visualizar();
                    break;
                case 4:
                    this.deletar(scanner);
                    break;
                case 5:
                    this.matricularAlunos(scanner);
                    break;
                case 9:
                    isTrue = false;
                    break;
                default:
                    System.exit(1);
            }
        }
        System.out.println();
    }


    private void cadastrar(Scanner scanner) {
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.next();
        System.out.print("Digite o semestre da disciplina: ");
        Integer semestre = scanner.nextInt();
        System.out.print("ID do professor: ");
        Long professorId = scanner.nextLong();
        Optional<Professor> optional = professorRepository.findById(professorId);
        if (optional.isPresent()) {
            Professor professor = optional.get();
            Disciplina disciplina = new Disciplina(nome, semestre, professor);
            this.disciplinaRepository.save(disciplina);
            System.out.println("Professor salvo no banco!\n");
        } else {
            System.out.println("Professor ID " + professorId + " inválido");
        }
    }

    private void atualizar(Scanner scanner) {
        System.out.print("Informe o ID da disciplina que deseja atualizar: ");
        Long disciplinaId = scanner.nextLong();
        Optional<Disciplina> optionalDisciplina = this.disciplinaRepository.findById(disciplinaId);
        if (optionalDisciplina.isPresent()) {
            Disciplina disciplina = optionalDisciplina.get();
            System.out.print("Digite o nome da nova disciplina: ");
            String nome = scanner.next();
            System.out.print("Digite o novo semestre: ");
            Integer semestre = scanner.nextInt();
            System.out.print("ID do professor: ");
            Long professorId = scanner.nextLong();
            Optional<Professor> optionalProfessor = this.professorRepository.findById(professorId);
            if (optionalProfessor.isPresent()) {
                Professor professor = optionalProfessor.get();
                disciplina.setNome(nome);
                disciplina.setSemestre(semestre);
                disciplina.setProfessor(professor);
                disciplinaRepository.save(disciplina);
                System.out.println("Dados atualizados com sucesso!");
            } else {
                System.out.println("Professor ID" + professorId + " inválido!");
            }
        } else {
            System.out.println("Disciplina ID " + disciplinaId + " não encontrada!");
        }
    }

    private void visualizar() {
        Iterable<Disciplina> disciplinas = this.disciplinaRepository.findAll();
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina);
        }
        System.out.println();
    }

    private void deletar(Scanner scanner) {
        System.out.print("Informe o ID do professor que deseja deletar: ");
        Long id = scanner.nextLong();
        this.disciplinaRepository.deleteById(id);
    }

    private void matricularAlunos(Scanner scanner) {
        System.out.print("Digite o Id da Disiciplina para matricular alunos: ");
        Long id = scanner.nextLong();
        Optional<Disciplina> optionalDisciplina = this.disciplinaRepository.findById(id);
        if (optionalDisciplina.isPresent()) {
            Disciplina disciplina = optionalDisciplina.get();
            Set<Aluno> novosAlunos = this.matricular(scanner);
            disciplina.getAlunos().addAll(novosAlunos);
            this.disciplinaRepository.save(disciplina);
        } else {
            System.out.println("O id da disciplina " + id + " é inválido.\n");
        }
    }

    private Set<Aluno> matricular(Scanner scanner) {
        Boolean isTrue =true;
        Set<Aluno> alunos = new HashSet<>();
        while (isTrue) {
            System.out.print("Digite o ID do Aluno a ser matriculado ou 0 para sair: ");
            Long alunoId = scanner.nextLong();
            if (alunoId > 0) {
                System.out.println("Id do aluno: " + alunoId);
                Optional<Aluno> optional = this.alunoRepository.findById(alunoId);
                if (optional.isPresent()) {
                    alunos.add(optional.get());
                } else {
                    System.out.println("Nenhum aluno possui id " + alunoId + "!");
                }
            } else {
                isTrue = false;
            }
        }
        return alunos;
    }
}


