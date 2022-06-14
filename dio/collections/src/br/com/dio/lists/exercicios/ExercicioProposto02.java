package br.com.dio.lists.exercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class ExercicioProposto02 {
    public static void main(String[] args) {
        int sim = 0;
        ArrayList<String> respostas = new ArrayList<>();
        Scanner pergunta = new Scanner(System.in);
        System.out.print("Telefonou para a vítima?: ");
        String temp = pergunta.next();
        respostas.add(String.valueOf(temp));
        System.out.print("Esteve no local do crime?: ");
        temp = pergunta.next();
        respostas.add(String.valueOf(temp));
        System.out.print("Mora perto da vítima?: ");
        temp = pergunta.next();
        respostas.add(String.valueOf(temp));
        System.out.print("Devia para a vítima?: ");
        temp = pergunta.next();
        respostas.add(String.valueOf(temp));
        System.out.print("Já trabalhou para a vítima?: ");
        temp = pergunta.next();
        respostas.add(String.valueOf(temp));
        System.out.println(respostas);

        for (String resposta : respostas) {
            if (resposta.equals("s")) {
                sim++;
            }
        }

        if (sim == 5) {
            System.out.println("Assassino!");
        } else if (sim > 2) {
            System.out.println("Cúmplice!");
        } else if (sim > 1) {
            System.out.println("Suspeito!");
        } else {
            System.out.println("Inocente");
        }


    }
}
