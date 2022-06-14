package br.com.xavecoding.regesc;

import br.com.xavecoding.regesc.orm.Professor;
import br.com.xavecoding.regesc.repository.ProfessorRepository;
import br.com.xavecoding.regesc.service.AlunoService;
import br.com.xavecoding.regesc.service.DisciplinaService;
import br.com.xavecoding.regesc.service.ProfessorService;
import br.com.xavecoding.regesc.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
/*Criamos uma classe que implementa a interface CommandLineRunner para rodarmos comandos do Repository*/
public class RegescApplication implements CommandLineRunner {
	/*Também podemos instanciar nossa classe Service*/
	private ProfessorService professorService;
	private DisciplinaService disciplinaService;
	private AlunoService alunoService;
	private RelatorioService relatorioService;


	/*Aqui injetamos os métodos de nosso Service*/
	public RegescApplication(ProfessorService professorService, DisciplinaService disciplinaService,
							 AlunoService alunoService, RelatorioService relatorioService) {
		this.professorService = professorService;
		this.disciplinaService = disciplinaService;
		this.alunoService = alunoService;
		this.relatorioService = relatorioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RegescApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);
		while (isTrue) {
			System.out.println("O que deseja fazer/interagir?");
			System.out.println("1 - Professor");
			System.out.println("2 - Disciplina");
			System.out.println("3 - Aluno");
			System.out.println("4 - Relatório");
			System.out.println("9 - Voltar ao menu anterior");
			System.out.println("0 - Encerrar programa");
			System.out.print("Opção: ");
			int opcao = scanner.nextInt();
			switch (opcao) {
				case 1:
					this.professorService.menu(scanner);
					break;
				case 2:
					this.disciplinaService.menu(scanner);
					break;
				case 3:
					this.alunoService.menu(scanner);
					break;
				case 4:
					this.relatorioService.menu(scanner);
					break;
				case 9:
					isTrue = false;
					break;
				default:
					System.exit(1);
			}
		}
	}
}
