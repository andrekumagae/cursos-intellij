package br.com.xavecoding.regesc.service;

import br.com.xavecoding.regesc.orm.Aluno;
import br.com.xavecoding.regesc.orm.Professor;
import br.com.xavecoding.regesc.repository.AlunoRepository;
import br.com.xavecoding.regesc.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {
    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;

    public RelatorioService(AlunoRepository alunoRepository, ProfessorRepository professorRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
    }

    @Transactional
    public void menu(Scanner scanner) {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("\nQual ação você deseja executar?");
            System.out.println("1 - Alunos por nome");
            System.out.println("2 - Alunos por nome e idade menor ou igual");
            System.out.println("3 - Alunos por nome e idade maior ou igual");
            System.out.println("4 - Alunos por nome e idade maior ou igual matriculado em uma disciplina");
            System.out.println("5 - Professores atribuídos");
            System.out.println("9 - Voltar ao menu anterior");
            System.out.println("0 - Encerrar programa");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.cadastrar(scanner);
                    break;
                case 2:
                    this.alunosPorNomeIdadeMenorOuIgual(scanner);
                    break;
                case 3:
                    this.alunosPorNomeIdadeMaiorOuIgual(scanner);
                    break;
                case 4:
                    this.alunosPorNomeIdadeIgualOuMaiorMatriculado(scanner);
                    break;
                case 5:
                    this.professoresAtribuidos(scanner);
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
        System.out.print("Nome: ");
        String nome = scanner.next();
        List<Aluno> alunos = this.alunoRepository.findByNomeStartingWith(nome);
        alunos.forEach(System.out::println);
    }

    private void alunosPorNomeIdadeMenorOuIgual(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Idade: ");
        Integer idade = scanner.nextInt();
        List<Aluno> alunos = this.alunoRepository.findByNomeStartingWithAndIdadeLessThanEqual(nome, idade);
        alunos.forEach(System.out::println);
    }

    private void alunosPorNomeIdadeMaiorOuIgual(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Idade: ");
        Integer idade = scanner.nextInt();
        List<Aluno> alunos = this.alunoRepository.findNomeIdadeIgualOuMaior(nome, idade);
        alunos.forEach(System.out::println);
    }

    private void alunosPorNomeIdadeIgualOuMaiorMatriculado(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Idade: ");
        Integer idade = scanner.nextInt();
        System.out.print("Disciplina: ");
        String disciplina = scanner.next();
        List<Aluno> alunos = this.alunoRepository.findNomeIdadeIgualOuMaiorMatriculado(nome, idade, disciplina);
        alunos.forEach(System.out::println);
    }

    private void professoresAtribuidos(Scanner scanner) {
        System.out.print("Nome do professor: ");
        String nomeProfessor = scanner.next();
        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = scanner.next();
        List<Professor> professores = this.professorRepository.findProfessorAtribuido(nomeProfessor, nomeDisciplina);
        professores.forEach(System.out::println);
    }
}
