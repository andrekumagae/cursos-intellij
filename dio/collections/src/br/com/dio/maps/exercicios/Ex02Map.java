package br.com.dio.maps.exercicios;

import java.util.*;

public class Ex02Map{
    public static void main(String[] args) {
        Random random = new Random();
        int somaSorteados = 0;
        Map<Integer, Integer> sorteados = new HashMap<>(){{
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};

        Map<Integer, Integer> dado = new TreeMap<>();
        for (int i = 1; i <= 10; i++) {
            int numero = random.nextInt(6) + 1;
            dado.put(i, numero);
            for (Map.Entry<Integer, Integer> s : sorteados.entrySet()) {
                if (numero == s.getKey()) {
                    somaSorteados = s.getValue();
                    somaSorteados++;
                    sorteados.put(s.getKey(), somaSorteados);
                }
            }
            numero = 0;
        }
        for (Map.Entry<Integer, Integer> d : dado.entrySet()) {
            System.out.println("Tentativa: " + d.getKey() + ": " + d.getValue());
        }
        System.out.println("\n.::\tVezes sorteados\t::.\n");
        for (Map.Entry<Integer, Integer> s : sorteados.entrySet()) {
            System.out.println("Número: " + s.getKey() + " Vezes: " + s.getValue());
        }
    }
}