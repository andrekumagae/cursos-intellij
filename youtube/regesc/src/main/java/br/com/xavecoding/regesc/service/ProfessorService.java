package br.com.xavecoding.regesc.service;

import br.com.xavecoding.regesc.orm.Disciplina;
import br.com.xavecoding.regesc.orm.Professor;
import br.com.xavecoding.regesc.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Scanner;

/*A anotação Service faz que nossa classe funcione como um Controller, ou seja,
 * irá carregar nossos métodos*/
@Service
public class ProfessorService {
    /*Criamos uma instância do repositório para injetar as dependências nesta classe*/
    private ProfessorRepository professorRepository;

    /*Injetamos no construtor. Com isso, temos acesso aos métodos da interface CrudRepository*/
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Transactional
    public void menu(Scanner scanner) {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("\nQual ação você deseja executar?");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("1 - Cadastrar novo professor");
            System.out.println("2 - Atualiazar um professor");
            System.out.println("3 - Mostrar todos os professores");
            System.out.println("4 - Deletar um professor");
            System.out.println("5 - Mostrar todas as disicplinas de um professor");
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
                    this.visualizaProfessor(scanner);
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
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.next();
        System.out.print("Digite o nome do prontuário: ");
        String prontuario = scanner.next();
        Professor professor = new Professor(nome, prontuario);
        this.professorRepository.save(professor);
        System.out.println("Professor salvo no banco!\n");
    }

    private void atualizar(Scanner scanner) {
        System.out.print("Informe o ID do professor que deseja atualizar: ");
        Long id = scanner.nextLong();
        Optional<Professor> optionalProfessor = this.professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            System.out.print("Digite o nome do professor: ");
            String nome = scanner.next();
            System.out.print("Digite o prontuário do professor: ");
            String prontuario = scanner.next();
            Professor professor = optionalProfessor.get();
            professor.setNome(nome);
            professor.setProntuario(prontuario);
            professorRepository.save(professor);
            System.out.println("Professor cadastrado com sucesso!");
        }
        System.out.println("ID " + id + " não encontrado!");
    }

    private void visualizar() {
        Iterable<Professor> professores = this.professorRepository.findAll();
        professores.forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.print("Informe o ID do professor que deseja deletar: ");
        Long id = scanner.nextLong();
        this.professorRepository.deleteById(id);
        System.out.println("Professor deletado!");
    }

    @Transactional
    private void visualizaProfessor(Scanner scanner) {
        System.out.print("Informe o ID do professor: ");
        Long idProfessor = scanner.nextLong();
        Optional<Professor> optionalProfessor = professorRepository.findById(idProfessor);
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            System.out.println("Professor: [ ");
            System.out.println("ID: " + professor.getId());
            System.out.println("Nome: " + professor.getNome());
            System.out.println("Prontuário: " + professor.getProntuario());
            System.out.println("Disciplinas: [ ");
            for (Disciplina disciplina : professor.getDisciplinas()) {
                System.out.print("Nome da disiciplina: " + disciplina.getNome());
                System.out.print("\t:: Semestre: " + disciplina.getSemestre());
                System.out.print("\t:: ID: " + disciplina.getId()+"\n");
            }
//            System.out.println();
        }
        System.out.println(" ]\n");
    }
}
