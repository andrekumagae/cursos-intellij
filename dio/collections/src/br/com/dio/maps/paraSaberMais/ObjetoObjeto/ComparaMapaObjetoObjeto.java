package br.com.dio.maps.paraSaberMais.ObjetoObjeto;

import br.com.dio.maps.paraSaberMais.ObjetoSet.Aluno;
import br.com.dio.maps.paraSaberMais.ObjetoSet.Curso;

import java.awt.*;
import java.util.*;

public class ComparaMapaObjetoObjeto {
    public static void main(String[] args) {
        Aluno aluno4 = new Aluno("Jobs", 113);
        Aluno aluno5 = new Aluno("Alliso", 114);
        Aluno aluno6 = new Aluno("Le", 115);

        Curso curso4 = new Curso("HTML", 20);
        Curso curso5 = new Curso("Javascript", 14);
        Curso curso6 = new Curso("MySQL", 8);

        Map<Curso, Aluno> discAluno = new HashMap<>() {{
            put(curso4, aluno4);
            put(curso5, aluno5);
            put(curso6, aluno6);
        }};

        System.out.println("Exibindo o dicionário");
        for (Map.Entry<Curso, Aluno> ca : discAluno.entrySet()) {
            System.out.println("Curso: " + ca.getKey().getNome() + " - Duração: " + ca.getKey().getDuracao());
        }
        System.out.println("-------\nNome Disciplina");
        Map<Curso, Aluno> disciplinaEAluno2 = new TreeMap<>(discAluno);
        for (Map.Entry<Curso, Aluno> ca : disciplinaEAluno2.entrySet()) {
            System.out.println("Curso: " + ca.getKey().getNome() + " - Duração: " + ca.getKey().getDuracao() +
                    "\nAluno: " + ca.getValue().getNome() + " - RA: " + ca.getValue().getMatricula());
            System.out.println("----");
        }
        System.out.println("-------\nDuração da disciplina\t---");
        Map<Curso, Aluno> disciplinaEAluno3 = new TreeMap<>(new ComparaDuracao());
        disciplinaEAluno3.putAll(discAluno);
        for (Map.Entry<Curso, Aluno> ca : disciplinaEAluno3.entrySet()) {
            System.out.println("Curso: " + ca.getKey().getNome() + " - Duração: " + ca.getKey().getDuracao() +
                    "\nAluno: " + ca.getValue().getNome() + " - RA: " + ca.getValue().getMatricula());
            System.out.println("----");
        }
        System.out.println("-------\nNome do Aluno");
        Set<Map.Entry<Curso, Aluno>> discAluno4 = new TreeSet<>(new ComparaNomeAluno());
        discAluno4.addAll(discAluno.entrySet());
        for (Map.Entry<Curso, Aluno> ca : discAluno4) {
            System.out.println("Curso: " + ca.getKey().getNome() + " - Duração: " + ca.getKey().getDuracao() +
                    "\nAluno: " + ca.getValue().getNome() + " - RA: " + ca.getValue().getMatricula());
            System.out.println("----");
        }
        System.out.println("-------\nMatrícula do Aluno");
        TreeSet<Map.Entry<Curso, Aluno>> disciplinaEAluno5 = new TreeSet<>(new ComparaMatricula());
        disciplinaEAluno5.addAll(discAluno.entrySet());
        for (Map.Entry<Curso, Aluno> ca : disciplinaEAluno5) {
            System.out.println("Curso: " + ca.getKey().getNome() + " - Duração: " + ca.getKey().getDuracao() +
                    "\nAluno: " + ca.getValue().getNome() + " - RA: " + ca.getValue().getMatricula());
        }

    }
}

class ComparaDuracao implements Comparator<Curso> {

    @Override
    public int compare(Curso d1, Curso d2) {
        return Integer.compare(d1.getDuracao(), d2.getDuracao());
    }
}

class ComparaNomeAluno implements Comparator<Map.Entry<Curso,Aluno>> {


    @Override
    public int compare(Map.Entry<Curso, Aluno> o1, Map.Entry<Curso, Aluno> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}

class ComparaMatricula implements Comparator<Map.Entry<Curso,Aluno>>{

    @Override
    public int compare(Map.Entry<Curso, Aluno> o1, Map.Entry<Curso, Aluno> o2) {
        return Integer.compare(o1.getValue().getMatricula(),o2.getValue().getMatricula());
    }
}