package br.com.xavecoding.regescweb.dto;

import br.com.xavecoding.regescweb.models.Professor;
import br.com.xavecoding.regescweb.models.StatusProfessor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/*Esta classe serve para evitarmos o ataque por Web Parameter Tampering, que é quando um Hacker tenta editar dados no
 código fonte afim de alterar dados sensíveis*/
public class RequisicaoFormProfessor {
    @NotBlank
    /*Importante que este NotNull seja da class validation, não de stacks*/
    @NotNull
    private String nome;
    @DecimalMin("0.0")
    @NotNull
    private BigDecimal salario;
    private StatusProfessor statusProfessor;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusProfessor getStatusProfessor() {
        return statusProfessor;
    }

    public void setStatusProfessor(StatusProfessor statusProfessor) {
        this.statusProfessor = statusProfessor;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    /*Método que cria o objeto para que seja passado para o nosso banco de dados*/
    public Professor toProfessor() {
        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatusProfessor(this.statusProfessor);
        return professor;
    }

    public Professor toProfessor(Professor professor) {
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatusProfessor(this.statusProfessor);
        return professor;
    }

    public void fromProfessor(Professor professor) {
        this.nome = professor.getNome();
        this.salario = professor.getSalario();
        this.statusProfessor = professor.getStatusProfessor();
    }

    @Override
    public String toString() {
        return "RequisicaoNovoProfessor{" +
                "Nome='" + nome + '\'' +
                ", statusProfessor=" + statusProfessor +
                ", salario=" + salario +
                '}';
    }
}
