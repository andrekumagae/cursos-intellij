package br.com.dio.lists.ex01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex01 {
    /*
Para você: Resolva esses exercícios utilizando os métodos da implementação LinkedList:



*/
    public static void main(String[] args) {

//        System.out.println("Crie uma lista chamada notas2 " +
//                "e coloque todos os elementos da list Arraylist nessa nova lista: ");

        List<Double> notas = new ArrayList<>(); //Generics(jdk 5) - Diamond Operator(jdk 7)
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        LinkedList<Double> notas2 = new LinkedList<>(notas);
        System.out.println(notas2);


        System.out.println("Mostre a primeira nota da nova lista sem removê-lo: " + notas2.get(0));
        System.out.println("Mostre a primeira nota da nova lista removendo-o: " + notas2.remove(0));

        System.out.println(notas2);
    }
}
