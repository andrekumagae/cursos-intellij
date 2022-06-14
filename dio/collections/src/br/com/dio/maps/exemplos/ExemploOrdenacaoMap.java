package br.com.dio.maps.exemplos;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<String, Livros> meusLivros = new HashMap<>() {{
            put("HAWKING, Steven", new Livros("Uma breve história do tempo", 256));
            put("DUHIGG, Charles", new Livros("O poder do hábito", 408));
            put("HARARI, Yuval Noah", new Livros("21 lições para o século 21", 432));
        }};
        for (Map.Entry<String, Livros> livro : meusLivros.entrySet()) {
            System.out.println("Autor: " + livro.getKey() + " - Livro: " + livro.getValue().getNome() + " - Páginas: " + livro.getValue().getPaginas());
        }

        System.out.println("\n--\tOrdem de inserção\t--");
        Map<String, Livros> meusLivros1 = new LinkedHashMap<>() {{
            put("HAWKING, Steven", new Livros("Uma breve história do tempo", 256));
            put("DUHIGG, Charles", new Livros("O poder do hábito", 408));
            put("HARARI, Yuval Noah", new Livros("21 lições para o século 21", 432));
        }};
        for (Map.Entry<String, Livros> livro :
                meusLivros1.entrySet()) {
            System.out.println("Autor: " + livro.getKey() + " - Livro: " + livro.getValue().getNome());
        }
        System.out.println("\n--\tOrdem alfabética por nome do autor\t--");
        Map<String, Livros> meusLivros2 = new TreeMap<>(meusLivros);
        for (Map.Entry<String, Livros> livro :
                meusLivros2.entrySet()) {
            System.out.println("Autor: " + livro.getKey() + " - Livro: " + livro.getValue().getNome() + " - Páginas: " + livro.getValue().getPaginas());
        }
        System.out.println("\n--\tOrdem alfabética por nome dos livros\t--");
        Set<Map.Entry<String, Livros>> meusLivros3 = new TreeSet<>(new LivrosPorNomeDoLivro());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livros> livro :
                meusLivros3) {
            System.out.println("Autor: " + livro.getKey() + " - Livro: " + livro.getValue().getNome() + " - Páginas: " + livro.getValue().getPaginas());
        }
        System.out.println("\n--\tOrdem alfabética por número de páginas\t--");
        Set<Map.Entry<String, Livros>> meusLivros4 = new TreeSet<>(new LivrosPorPagina());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livros> livro :
                meusLivros4) {
            System.out.println("Autor: " + livro.getKey() + " - Livro: " + livro.getValue().getNome() + " - Páginas: " + livro.getValue().getPaginas());
        }

    }
}

class Livros{
    private String nome;
    private Integer paginas;

    public Livros(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Livros{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livros livros = (Livros) o;
        return Objects.equals(nome, livros.nome) && Objects.equals(paginas, livros.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }
}

class LivrosPorNomeDoLivro implements Comparator<Map.Entry<String, Livros>> {

    @Override
    public int compare(Map.Entry<String, Livros> l1, Map.Entry<String, Livros> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class LivrosPorPagina implements Comparator<Map.Entry<String, Livros>> {

    @Override
    public int compare(Map.Entry<String, Livros> l1, Map.Entry<String, Livros> l2) {
        return Integer.compare(l1.getValue().getPaginas(), l2.getValue().getPaginas());
    }
}