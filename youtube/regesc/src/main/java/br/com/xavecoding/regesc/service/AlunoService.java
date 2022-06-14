package br.com.xavecoding.regesc.service;

import br.com.xavecoding.regesc.orm.Aluno;
import br.com.xavecoding.regesc.orm.Disciplina;
import br.com.xavecoding.regesc.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Scanner;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public void menu(Scanner scanner) {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("\nQual ação você deseja executar?");
            System.out.println("1 - Cadastrar novo aluno");
            System.out.println("2 - Atualizar um aluno");
            System.out.println("3 - Mostrar todos os alunos");
            System.out.println("4 - Deletar um aluno");
            System.out.println("5 - Visualizar um aluno pelo id");
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
                    this.visualizarAluno(scanner);
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
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.next();
        System.out.print("Digita a idade do aluno: ");
        Integer idade = scanner.nextInt();
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setIdade(idade);
        this.alunoRepository.save(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void atualizar(Scanner scanner) {
        System.out.print("Digite o ID do aluno a ser atualizado: ");
        Long alunoId = scanner.nextLong();
        Optional<Aluno> optionalAluno = this.alunoRepository.findById(alunoId);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            System.out.print("Novo nome: ");
            String nome = scanner.next();
            System.out.print("Nova idade: ");
            Integer idade = scanner.nextInt();
            aluno.setNome(nome);
            aluno.setIdade(idade);
            this.alunoRepository.save(aluno);
            System.out.println("Aluno de ID " + aluno.getId() + " atualizado com sucesso!");
        }
    }

    private void visualizar() {
        Iterable<Aluno> alunoIterable = this.alunoRepository.findAll();
        for (Aluno aluno : alunoIterable) {
            System.out.println(aluno);
        }
        System.out.println();
    }

    private void deletar(Scanner scanner) {
        System.out.print("Digite o ID do aluno a ser deletado: ");
        Long alunoId = scanner.nextLong();
        Optional<Aluno> optionalAluno = this.alunoRepository.findById(alunoId);
        this.alunoRepository.deleteById(alunoId);
        System.out.println("Aluno deletado!\n");
    }

    @Transactional
    private void visualizarAluno(Scanner scanner) {
        System.out.print("Digite o ID ao aluno que deseja visualizar: ");
        Long alunoId = scanner.nextLong();
        Optional<Aluno> optionalAluno = this.alunoRepository.findById(alunoId);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            System.out.println("Aluno: [ ");
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Idade: " + aluno.getIdade());
            System.out.println("Disciplinas: ");
            if (aluno.getDisciplinas() != null) {
                for (Disciplina disciplina : aluno.getDisciplinas()) {
                    System.out.println("\t- Disciplina: " + disciplina.getNome());
                    System.out.println("\t- Semestre: " + disciplina.getSemestre());
                    System.out.println();
                }
            }
            System.out.println(" ]");
        } else {
            System.out.println("O id do aluno informado: " + alunoId + " é inválido\n");
        }
    }
}
