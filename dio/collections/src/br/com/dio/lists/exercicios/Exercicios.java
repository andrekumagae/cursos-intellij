package br.com.dio.lists.exercicios;

import java.util.*;

public class Exercicios {
    public static void main(String[] args) {
        Set<LinguagensFavoritas> linguagensFavoritas = new LinkedHashSet<>() {{
            add(new LinguagensFavoritas("Python", 1991, "IntelliJ", "James Gosling"));
            add(new LinguagensFavoritas("Python", 1991, "Pycharm", "Guido Van Rossum"));
            add(new LinguagensFavoritas("Python", 1991, "zDev C++", "Bjarne Stroustrup"));
            add(new LinguagensFavoritas("Python", 1991, "PHP Storm", "Rasmus Lerdorf"));
        }};
        System.out.println("Ordem de inserção\n");
        for (LinguagensFavoritas l :
                linguagensFavoritas) {
            System.out.println("Linguagem: " + l.getNome()
                    + "\nAno de criação: " + l.getAnodeCriacao()
                    + "\nIDE favorita: " + l.getNomeIde()
                    + "\nCriador: " + l.getNomeCriador() + "\n");
        }
/*        System.out.println("Ordem natural (nome)");
        Set<LinguagensFavoritas> linguagensFavoritasporNome = new TreeSet<>(new LinguagensOrdemPorNome());
        linguagensFavoritasporNome.addAll(linguagensFavoritas);
        for (LinguagensFavoritas l :
                linguagensFavoritasporNome) {
            System.out.println("Linguagem: " + l.getNome()
                    + "\nAno de criação: " + l.getAnodeCriacao()
                    + "\nIDE favorita: " + l.getNomeIde()
                    + "\nCriador: " + l.getNomeCriador() + "\n");
        }
        System.out.println(".:: Ordem natural (IDE) ::.");
        Set<LinguagensFavoritas> linguagensFavoritasPorIde = new TreeSet<>(new LinguagensOrdemPorIDE());
        linguagensFavoritasPorIde.addAll(linguagensFavoritas);
        for (LinguagensFavoritas l :
                linguagensFavoritasPorIde) {
            System.out.println("Linguagem: " + l.getNome()
                    + "\nAno de criação: " + l.getAnodeCriacao()
                    + "\nIDE favorita: " + l.getNomeIde()
                    + "\nCriador: " + l.getNomeCriador() + "\n");
        }
        System.out.println(".:: ordem natural (Ano/Nome) ::.");
        Set<LinguagensFavoritas> linguagensFavoritasPorAnoeNome = new TreeSet<>(new LinguagensOrdemPorAnoeNome());
        linguagensFavoritasPorAnoeNome.addAll(linguagensFavoritas);
        for (LinguagensFavoritas l :
                linguagensFavoritasPorAnoeNome) {
            System.out.println("Linguagem: " + l.getNome()
                    + "\nAno de criação: " + l.getAnodeCriacao()
                    + "\nIDE favorita: " + l.getNomeIde()
                    + "\nCriador: " + l.getNomeCriador() + "\n");
        }*/
        System.out.println(".:: Ordem por nome, ano e ide");
//        Perceba que precisamos dar uma classe com Comparator como argumento de nosso objeto do tipo TreeSet
        Set<LinguagensFavoritas> linguagensFavoritasPorNomeAnoeIde = new TreeSet<>(new LinguagensOrdemPorNomeAnoeIde());
//        Adicionamos de uma Set já criada. Neste caso uma LinkedHashSet, que respeita a ordem de inserção, porém
//        o Comparator da classe LinguagensOrdemPorNomeAnoeIde trata de organizá-la
        linguagensFavoritasPorNomeAnoeIde.addAll(linguagensFavoritas);
        for (LinguagensFavoritas l :
                linguagensFavoritasPorNomeAnoeIde) {
            System.out.println("Linguagem: " + l.getNome()
                    + "\nAno de criação: " + l.getAnodeCriacao()
                    + "\nIDE favorita: " + l.getNomeIde()
                    + "\nCriador: " + l.getNomeCriador() + "\n");
        }
    }

}

class LinguagensFavoritas implements Comparator<LinguagensFavoritas> {
    private String nome;
    private int anodeCriacao;
    private String nomeIde;
    private String nomeCriador;

    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                        ", anodeCriacao=" + anodeCriacao +
                        ", nomeIde='" + nomeIde + '\'' +
                        ", nomeCriador='" + nomeCriador + '\'' +
                        '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnodeCriacao() {
        return anodeCriacao;
    }

    public void setAnodeCriacao(int anodeCriacao) {
        this.anodeCriacao = anodeCriacao;
    }

    public String getNomeIde() {
        return nomeIde;
    }

    public void setNomeIde(String nomeIde) {
        this.nomeIde = nomeIde;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
        this.nomeCriador = nomeCriador;
    }

    public LinguagensFavoritas(String nome, int anodeCriacao, String nomeIde, String nomeCriador) {
        this.nome = nome;
        this.anodeCriacao = anodeCriacao;
        this.nomeIde = nomeIde;
        this.nomeCriador = nomeCriador;
    }

    @Override
    public int compare(LinguagensFavoritas o1, LinguagensFavoritas o2) {
        return 0;
    }
}

class LinguagensOrdemPorNome implements Comparator<LinguagensFavoritas> {

    @Override
    public int compare(LinguagensFavoritas o1, LinguagensFavoritas o2) {
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
}

class LinguagensOrdemPorIDE implements Comparator<LinguagensFavoritas> {

    @Override
    public int compare(LinguagensFavoritas o1, LinguagensFavoritas o2) {
        return o1.getNomeIde().compareToIgnoreCase(o2.getNomeIde());
    }
}

class LinguagensOrdemPorAnoeNome implements Comparator<LinguagensFavoritas> {

    @Override
    public int compare(LinguagensFavoritas o1, LinguagensFavoritas o2) {
        int ano = Integer.compare(o1.getAnodeCriacao(), o2.getAnodeCriacao());
        int nome = o1.getNomeIde().compareToIgnoreCase(o2.getNomeIde());
        if (ano != 0) {
            return ano;
        } else {
            return nome;
        }
    }
}

class LinguagensOrdemPorNomeAnoeIde implements Comparator<LinguagensFavoritas> {

    @Override
    public int compare(LinguagensFavoritas o1, LinguagensFavoritas o2) {
        int ide =  o1.getNomeIde().compareToIgnoreCase(o2.getNomeIde());
        int ano = Integer.compare(o1.getAnodeCriacao(), o2.getAnodeCriacao());
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if (nome != 0) {
            return nome;
        } else if (ano != 0) {
            return ano;
        } else {
            return ide;
        }
    }
}

class LinguagensOrdemPorCriador implements Comparator<LinguagensFavoritas> {

    @Override
    public int compare(LinguagensFavoritas o1, LinguagensFavoritas o2) {
        return o1.getNomeIde().compareToIgnoreCase(o2.getNomeIde());
    }
}