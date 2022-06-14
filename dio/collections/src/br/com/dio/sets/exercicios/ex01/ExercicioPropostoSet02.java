package br.com.dio.sets.exercicios.ex01;

import java.util.*;

public class ExercicioPropostoSet02 {
    public static void main(String[] args) {
        Set<Linguagens> linguagensFavoritas = new LinkedHashSet<>(){{
            add(new Linguagens("Java", 1995, "Intellij"));
            add(new Linguagens("Python", 1991, "PyCharm"));
            add(new Linguagens("C++", 1979, "VS Code"));
            add(new Linguagens("JS", 1995, "VS Code"));
            add(new Linguagens("PHP", 1995, "PHPStorm"));
            add(new Linguagens("C", 1972, "Code Blocks"));
        }};
        System.out.println(".::\tOrdenação por inserção\t::.");
        for (Linguagens i:linguagensFavoritas) {
            System.out.println(i.getNomeLinguagem() + " - " + i.getAnoDeCriacao() + " - " + i.getIde());
        }
        System.out.println("\n--\tOrdem natural (por nome)\t--");
        Set<Linguagens> linguagensPorNome = new TreeSet<>(linguagensFavoritas);
        for (Linguagens i:linguagensPorNome) {
            System.out.println(i.getNomeLinguagem() + " - " + i.getAnoDeCriacao() + " - " + i.getIde());
        }

        System.out.println("\n--\tOrdem por nome de IDE\t--");
        Set<Linguagens> linguagensPorIde = new TreeSet<>(new ComparadorPorIde());
        linguagensPorIde.addAll(linguagensFavoritas);
        for (Linguagens i:linguagensPorIde) {
            System.out.println(i.getNomeLinguagem() + " - " + i.getAnoDeCriacao() + " - " + i.getIde());
        }

        System.out.println("\n--\tOrdem por ano de criação e nome da linguagem\t--");
        Set<Linguagens> linguagensPorAnoNome = new TreeSet<>(new ComparadorAnoNome());
        linguagensPorAnoNome.addAll(linguagensFavoritas);
        for (Linguagens i:linguagensPorAnoNome) {
            System.out.println(i.getNomeLinguagem() + " - " + i.getAnoDeCriacao() + " - " + i.getIde());
        }

    }
}

class Linguagens implements Comparable<Linguagens>{
    private String nomeLinguagem;
    private int anoDeCriacao;
    private String ide;

    public Linguagens(String nomeLinguagem, int anoDeCriacao, String ide) {
        this.nomeLinguagem = nomeLinguagem;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNomeLinguagem() {
        return nomeLinguagem;
    }

    public void setNomeLinguagem(String nomeLinguagem) {
        this.nomeLinguagem = nomeLinguagem;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nomeLinguagem='" + nomeLinguagem + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(Linguagens o) {
        return this.getNomeLinguagem().compareToIgnoreCase(o.getNomeLinguagem());
    }
}

class ComparadorPorIde implements Comparator<Linguagens> {

    @Override
    public int compare(Linguagens o1, Linguagens o2) {
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}

class ComparadorAnoNome implements Comparator<Linguagens> {

    @Override
    public int compare(Linguagens o1, Linguagens o2) {
        int ano = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (ano != 0) {
            return ano;
        }else{
            return o1.getNomeLinguagem().compareToIgnoreCase(o2.getNomeLinguagem());
        }
    }
}