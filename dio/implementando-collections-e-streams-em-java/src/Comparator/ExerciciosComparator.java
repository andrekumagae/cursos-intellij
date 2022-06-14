package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ExerciciosComparator {
    public static void main(String[] args) {
        System.out.println("Adicione elementos em uma lista");
    List<Estudante> estudantes = new ArrayList<>(){{
       add(new Estudante("Pedro", 19));
       add(new Estudante("Carlos", 23));
       add(new Estudante("Mariana", 18));
       add(new Estudante("João", 20));
       add(new Estudante("Thiago", 22));
       add(new Estudante("Larissa", 21));
    }};
        Collections.sort(estudantes, new EstudanteComparator());
        System.out.println("Ordene implementando a interface Comparator");
        for (Estudante e : estudantes) {
            System.out.println(e.getNome() + " - " + e.getIdade());
        }
        System.out.println(estudantes);
        System.out.println("Ordene implementando um novo objeto com a interface Comparable");
        Collections.sort(estudantes);
        for (Estudante e : estudantes) {
            System.out.println(e.getNome() + " - " + e.getIdade());
        }
        System.out.println("Ordene usando uma expressão lambda na chamada se suaLista.sort");
        estudantes.sort((o1, o2) -> o1.getNome().compareToIgnoreCase(o2.getNome()));
        estudantes.stream().forEach(System.out::println);
        System.out.println("Ordene usando referências de métodos e os métodos estáticos do Comparator");
        estudantes.sort(Comparator.comparing(Estudante::getNome));
    }
}

class EstudanteComparator implements Comparator<Estudante> {

    @Override
    public int compare(Estudante o1, Estudante o2) {
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
}

