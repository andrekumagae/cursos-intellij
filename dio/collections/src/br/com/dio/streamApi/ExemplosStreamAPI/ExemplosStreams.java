package br.com.dio.streamApi.ExemplosStreamAPI;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExemplosStreams {
    public static void main(String[] args) {
        List<String> numeros = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
        System.out.println("Imprima todos os elementos dessa lista de String pela classe anônima");
        numeros.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("Imprima todos os elementos dessa lista de String pela expressão lambda");
        /*Apagamos toda a classe anônima até a variável, colocamos a flecha e o código
         * que estava dentro do método implementado*/
        numeros.stream().forEach(s -> System.out.println(s));


        /*Para converter uma lambda para method reference, basta apertar alt + enter ou apagar as variáveis e colocar
         :: entre a classe e o método*/
        System.out.println("Imprima todos os elementos dessa lista de String pelo method reference");
        numeros.stream().forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
        numeros.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        /*Podemos guardar estes valores em uma variável*/
        Set<String> collect = numeros.stream()
                .limit(5)
                .collect(Collectors.toSet());

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        Set<Integer> numerosParaInteiros = numeros.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        numerosParaInteiros
                .forEach(System.out::println);


        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
        List<Integer> numerosPares = numeros.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList());
        numerosPares
                .forEach(System.out::println);

        System.out.println("Mostre a média dos números: ");
        numeros.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");
        Set<Integer> numerosImpares = new HashSet<>(numerosParaInteiros);
        numerosImpares.removeIf(i -> i % 2 != 0);
        System.out.println(numerosImpares);

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numeros.stream()
                .skip(3)
                .forEach(System.out::println);

        long countNumerosUnicos = numerosParaInteiros.stream()
                .distinct()
                .count();
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);

        System.out.print("Mostre o menor valor da lista: ");
        numerosParaInteiros.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.print("Mostre o maior valor da lista: ");
        numeros.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.print("Pegue apenas os números ímpares e some: ");
        numerosImpares.stream()
                .filter(i -> i % 2 != 0);
        int soma = numerosImpares.stream()
                .mapToInt(Integer::intValue)
                .filter(i -> i % 2 != 0)
                .sum();
        System.out.println(soma);

        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = numerosParaInteiros.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosParaInteiros.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplosDe3E5);

    }
}
