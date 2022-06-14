package br.com.dio.lists.exemplos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PraticandoLists {
    public static void main(String[] args) {
        List<Double> notas = new ArrayList<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6));
//        List<Double> notas = new ArrayList<>();
        System.out.println(notas);
    }
}
