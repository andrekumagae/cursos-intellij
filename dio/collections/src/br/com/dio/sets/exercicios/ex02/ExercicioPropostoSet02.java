package br.com.dio.sets.exercicios.ex02;

import java.util.*;

public class ExercicioPropostoSet02 {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto contendo as cores do arco-íris e:");
        Set<String> listaDeCores = new HashSet<>();
           listaDeCores.add("vermelho");
           listaDeCores.add("laranja");
           listaDeCores.add("amarelo");
           listaDeCores.add("verde");
           listaDeCores.add("azul");
           listaDeCores.add("anil");
           listaDeCores.add("violeta");

        System.out.println("\nA. Exiba todas as cores uma abaixo da outra");
        for (String i: listaDeCores) {
            System.out.println(i);
        }
        System.out.println("\nB. A quantidade de cores que o arco-íris tem");
        System.out.println(listaDeCores.size());

        System.out.println("\nC. Exiba as cores em ordem alfabética");
        Set<String> listaCoresNatural = new TreeSet<>(listaDeCores);
        System.out.println(listaCoresNatural);

        System.out.println("\nD. Exiba as cores na ordem inversa da que foi informada");
        List<String> listaInversa = new ArrayList<>(listaCoresNatural);
        Collections.reverse(listaInversa);
        System.out.println(listaInversa);

        System.out.println("\nE. Exiba todas as cores que começam com a letra \"v\"");
        for (String i : listaDeCores) {
            if (i.startsWith("v")) {
                System.out.println(i);
            }
        }

        System.out.println("\nF. Remova todas as cores que não começam com a letra \"v\"");
        Iterator<String> iterador = listaDeCores.iterator();
        while (iterador.hasNext()) {
            String next = iterador.next();
            if (!next.startsWith("v")) {
                iterador.remove();
            }
        }
        System.out.println(listaDeCores);

        System.out.println("\nG. Limpe o conjunto");
        listaDeCores.clear();
        System.out.println(listaDeCores);

        System.out.println("\nH. Confira se o conjunto está vazio");
        System.out.println(listaDeCores.isEmpty());
    }
}