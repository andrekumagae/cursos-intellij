package br.com.dio.lists.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
//        Consigo criar uma List do tipo Classe. Ao adicionar um novo elemento nela, consigo criar um objeto e informar
//        os valores que constam no construtor desta classe
        List<Gato> meusGatos = new ArrayList<>() {{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println(meusGatos);
        System.out.println("--\tOrdem aleatória\t--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);
        System.out.println("--\tOrdem Natural (nome)\t--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);
        System.out.println("--\tOrdem por idade\t--");
        meusGatos.sort(new comparadorDeIdades());
        System.out.println(meusGatos);
        System.out.println("--\tOrdem por cor\t--");
        meusGatos.sort(new comparadorDeCores());
        System.out.println(meusGatos);
        System.out.println("--\tOrdem por nome, cor e idade\t");
        meusGatos.sort(new comparadorDeNomeCorIdade());
        System.out.println(meusGatos);

    }
}

// Aqui implmentamos a interface Comparable para utilizar o método compareTo
class Gato implements Comparable<Gato> {
    private String nome;
    private String cor;
    private int idade;

    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", idade=" + idade +
                '}';
    }

    //    E neste método comparamos dois elementos onde temos os possíveis resultados:
//    -1: menor, 0 = iguais, 1 = maior.
    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

// Para comparamos usando múltiplos critérios, usamos a interface Comparator
// Precisamos de uma classe externa e implementá-la com o tipo primitivo a classe que queremos comparar seus
// atributos
class comparadorDeIdades implements Comparator<Gato> {
    @Override
    public int compare(Gato i1, Gato i2) {
        return Integer.compare(i1.getIdade(), i2.getIdade());
    }
}

// Aqui aplicamos o mesmo conceito do Comparable, porém com as variaveis dos parametros inves do this
class comparadorDeCores implements Comparator<Gato> {
    @Override
    public int compare(Gato c1, Gato c2) {
        return c1.getCor().compareToIgnoreCase(c2.getCor());
    }
}

// Se quisermos comparar por múltiplos critérios, podemos criar blocos if-else para cada um deles.
// Lembrando que o método compare considera que 0 é igual, -1 é menor e 1 é maior.
// Logo se for != 0, vai ser maior ou menor.Caso sejam iguais, desconsidera este critério e vai pro próximo.
// Guardamos os tres compares em variáveis para um código mais limpo nos if-elses
class comparadorDeNomeCorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato c1, Gato c2) {
        int nome = c1.getNome().compareToIgnoreCase(c2.getNome());
        int idade = Integer.compare(c1.getIdade(), c2.getIdade());
        int cor = c1.getCor().compareToIgnoreCase(c2.getCor());
        if (nome != 0)
            return nome;
        else if (cor != 0)
            return cor;
        else
            return idade;
    }
}