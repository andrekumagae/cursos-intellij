package StreamAPI;

import Comparator.Estudante;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<Estudante> estudantes = new ArrayList<>() {{
            add(new Estudante("Pedro", 19));
            add(new Estudante("Carlos", 23));
            add(new Estudante("Mariana", 18));
            add(new Estudante("João", 20));
            add(new Estudante("Thiago", 22));
            add(new Estudante("Larissa", 21));
            add(new Estudante("Bruno", 17));
        }};
        System.out.println("Transforme cada estudante em uma string com os atributos do objeto" +
                estudantes.stream().map(Object::toString).collect(Collectors.joining(", \n"))
        );
        System.out.println("Conte a quantidade de estudantes na coleção: " + estudantes.stream().count());
        System.out.println("Filtre estudantes com idade igual ou superior a 18 anos: ");
        System.out.println(
                estudantes.stream()
                        .filter(estudante -> estudante.getIdade() > 18)
                        .sorted(Comparator.comparing(Estudante::getIdade))
                        .collect(Collectors.toList()));
        System.out.println("Exibe cada elemento no console");
        estudantes.forEach(System.out::println);
        System.out.println("Retorne estudantes com nome que possui a letra B: " + estudantes.stream().filter(estudante -> estudante.getNome().toLowerCase(Locale.ROOT).contains("b")).collect(Collectors.toList())
        );
        System.out.println("Retorne se existe ao menos um estudante com a letra d no nome: " + estudantes.stream().filter(estudante -> estudante.getNome().toLowerCase(Locale.ROOT).contains("d")).collect(Collectors.toList())
        );
        System.out.println("Retorne o estudante mais velho da coleção: " + estudantes.stream().max(Comparator.comparing(Estudante::getIdade)));
        System.out.println("Retorne o estudante mais novo da coleção: " + estudantes.stream().min(Comparator.comparing(Estudante::getIdade)));

    }
}
