package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ExerciciosQueue {
    public static void main(String[] args) {
        System.out.println("1 - Adicione 5 nomes:");
        Queue<String>nomes = new LinkedList<>(){{
            add("Juliana");
            add("Pedro");
            add("Carlos");
            add("Larissa");
            add("João");
        }};
        System.out.println("2 - Navegue na fila exibindo cada nome no console:");
        for (String n : nomes) {
            System.out.println(n);
        }
        System.out.println("3 - Retorne o primeiro item da fila, sem removê-lo: " + nomes.peek());
        System.out.println("4 - Retorne o primeiro item da fila, removendo o mesmo: " + nomes.poll());
        System.out.println(nomes);
        System.out.println("5 - Adicione um novo nome: Daniel. Verifique a posição que o mesmo assumiu na fila: " + nomes.add("Daniel"));
        System.out.println(nomes);
        System.out.println("6 - Retorne o tamanho da fila: " + nomes.size());
        System.out.println("7 - Verifique se a fila está vazia: " + nomes.isEmpty());
        System.out.println("8 - Verifique se o nome Carlos está na fila: " + nomes.contains("Carlos"));
    }
}
