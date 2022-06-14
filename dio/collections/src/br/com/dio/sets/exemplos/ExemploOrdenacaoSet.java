package br.com.dio.sets.exemplos;

import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
//        Por característica do HashSet, já adiciona aleatoriamente os elementos
        Set<Series> seriesAleatorias = new HashSet<>() {{
            add(new Series("got", "fantasia", 60));
            add(new Series("dark", "drama", 60));
            add(new Series("that 70's show", "comedia", 25));
        }};

//        Podemos simplificar um laço for que varre do inicio ao fim em i++ bastando colocar a seguinte sintaxe:
//        (tipoPrimitivo nomeIterador : nomeArray)
        for (Series iterador : seriesAleatorias) {
            System.out.println(iterador.getNome() + " - " + iterador.getGenero() + " - " + iterador.getTempo());
        }
//        LinkedSet adiciona os elementos na ordem de inserção
        System.out.println("--\tOrdem de inserção\t--");
        Set<Series> seriesInsercao = new LinkedHashSet<>() {{
            add(new Series("got", "fantasia", 60));
            add(new Series("dark", "drama", 60));
            add(new Series("that 70's show", "comedia", 25));
        }};
        for (Series iterador : seriesInsercao) {
            System.out.println(iterador.getNome() + " - " + iterador.getGenero() + " - " + iterador.getTempo());
        }
        System.out.println("--\tOrdem por tempo de episódio\t--");
//        Para ordernamos pela ordem natural, usamos a Collection TreeSet, dizendo que a ordem a ser seguida é a
//        que está presente do método compareTo da classe
        Set<Series> seriesNatural = new TreeSet<>(seriesInsercao);
        for (Series iterador : seriesNatural) {
            System.out.println(iterador.getNome() + " - " + iterador.getGenero() + " - " + iterador.getTempo());
        }
        System.out.println("--\tOrdem por NOME/GENERO/TEMPO DE EPISODIO\t--");
//        Aqui podemos criar uma TreeSet com um Comparator como argumento
        Set<Series> seriesNomeGeneroTempo = new TreeSet<>(new ComparadorDeNomeGeneroTempo());
//        E após isso, usando o método addAll, pegamos todos os dados de uma Collection para ela, já organizando com
//        o critério do Comparator criado
        seriesNomeGeneroTempo.addAll(seriesAleatorias);
        for (Series iterador : seriesNomeGeneroTempo) {
            System.out.println(iterador.getNome() + " - " + iterador.getGenero() + " - " + iterador.getTempo());
        }
        System.out.println("--\tOrdem genero\t--");
        Set<Series> seriesGenero = new TreeSet<>(new ComparadorGenero());
        seriesGenero.addAll(seriesAleatorias);
        for (Series iterador : seriesGenero) {
            System.out.println(iterador.getNome() + " - " + iterador.getGenero() + " - " + iterador.getTempo());
        }


        System.out.println("--\tOrdem tempo episódio\t--");
        Set<Series> seriesTempoEpisodio = new TreeSet<>(new ComparadorTempoNome());
        seriesTempoEpisodio.addAll(seriesAleatorias);
        for (Series iterador : seriesTempoEpisodio) {
            System.out.println(iterador.getNome() + " - " + iterador.getGenero() + " - " + iterador.getTempo());
        }

    }

}

// temos que implementar um Comparable para usar o método compareTo
class Series implements Comparable<Series> {
    private String nome;
    private String genero;
    private int tempo;

    public Series(String nome, String genero, int tempo) {
        this.nome = nome;
        this.genero = genero;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempo=" + tempo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return tempo == series.tempo && Objects.equals(nome, series.nome) && Objects.equals(genero, series.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempo);
    }

    @Override
    public int compareTo(Series o) {
//        Aqui criamos o criterio da ordem natural ser pelo tempo de episódio e depois genero
        int tempoEpisodio = Integer.compare(this.getTempo(), o.getTempo());
        if (tempoEpisodio != 0) {
            return tempoEpisodio;
        } else {
            return this.getGenero().compareToIgnoreCase(o.getGenero());
        }
    }
}


class ComparadorDeNomeGeneroTempo implements Comparator<Series> {

    @Override
    public int compare(Series s1, Series s2) {
        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
        int tempo = Integer.compare(s1.getTempo(), s2.getTempo());
        if (nome != 0) {
            return nome;
        } else if (genero != 0) {
            return genero;
        } else {
            return tempo;
        }
    }
}

class ComparadorGenero implements Comparator<Series> {

    @Override
    public int compare(Series o1, Series o2) {
        return o1.getGenero().compareToIgnoreCase(o2.getGenero());
    }
}

class ComparadorTempoNome implements Comparator<Series> {

    @Override
    public int compare(Series o1, Series o2) {
        int tempo = Integer.compare(o1.getTempo(), o2.getTempo());
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if (tempo != 0) {
            return tempo;
        }else{
            return nome;
        }
    }
}