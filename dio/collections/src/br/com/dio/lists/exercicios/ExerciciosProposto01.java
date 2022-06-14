package br.com.dio.lists.exercicios;

import java.util.*;


public class ExerciciosProposto01 {
    /*Faça um programa que receba a temperatura média dos 6 primeiros
     * meses do ano e armazena-as numa lista. Após isto, calcule a média
     * semestral das temperaturas e mostre todas as temperaturas acima desta média e em que
     * mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro, etc).*/

    public static void main(String[] args) {
        List<String> meses = new ArrayList<>(Arrays.asList("1 - Janeiro","2 - Fevereiro","3 - Março","4 - Abril","5 - Maio","6 - Junho"));
        List<Double> temperaturas = new ArrayList<>();
        temperaturas.add(20.5);
        temperaturas.add(22.5);
        temperaturas.add(33.2);
        temperaturas.add(36.5);
        temperaturas.add(15.5);
        temperaturas.add(10.5);
        System.out.println(temperaturas);

        Iterator<Double> iterator = temperaturas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("\nSoma das temparaturas: " +soma);
        Double media = soma/temperaturas.size();
        System.out.printf("Média das temperaturas: %.1f ",media);

        System.out.println("\nTemperaturas acima da média e meses correspondentes\n");
        Iterator<Double> iterator1 = temperaturas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next > media) System.out.println("Temperatura: " + temperaturas.get(temperaturas.indexOf(next)) +" //" +
                    " " +
                    "Mês: " + meses.get((temperaturas.indexOf(next))));
        }

    }
}
