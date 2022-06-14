package br.com.dio.maps.paraSaberMais.ObjetoSet;

import java.util.*;

public class ComparaMapObjetoSet {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Kuma", 110);
        Aluno aluno2 = new Aluno("Harry", 111);
        Aluno aluno3 = new Aluno("Black", 112);

        Curso curso1 = new Curso("Java", 12);
        Curso curso2 = new Curso("Python", 8);
        Curso curso3 = new Curso("Javascript", 16);

        Set<Curso> disciplina1 = new HashSet<>(Arrays.asList(curso1, curso2));
        Set<Curso> disciplina2 = new HashSet<>(Arrays.asList(curso2, curso3));
        Set<Curso> disciplina3 = new HashSet<>(Arrays.asList(curso1, curso3));

        Map<Aluno, Set<Curso>> alunosEDisciplinas = new HashMap<>(){{
            put(aluno1, disciplina1);
            put(aluno2, disciplina2);
            put(aluno3, disciplina3);
        }};

        for (Map.Entry<Aluno, Set<Curso>> ac : alunosEDisciplinas.entrySet()) {
            System.out.println("Nome: " + ac.getKey().getNome() + " / Matrícula: " + ac.getKey().getMatricula() + " ");
//            Usando como tipo de referência o Curso iterando pela variável do 1º foreach
            for (Curso cr : ac.getValue()) {
                System.out.println("Curso: " + cr.getNome() + " / Duração: " + cr.getDuracao());
            }
            System.out.println("");
        }

    }
}
