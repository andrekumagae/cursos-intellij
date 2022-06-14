package Sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExerciciosSet {
    public static void main(String[] args) {
        System.out.println("Adicione 5 números");
    TreeSet<Integer> numeros = new TreeSet<>(){{
        add(3);
        add(88);
        add(20);
        add(44);
        add(3);
    }};
        System.out.println("Navegue no Set exibindo cada número no console");
        for (Integer n : numeros) {
            System.out.println(n);
        }
        System.out.println("Remova o primeiro item do Set." + numeros.pollFirst());
        System.out.println(numeros);
        System.out.println("Adicione um novo número no Set: " + numeros.add(23));
        System.out.println(numeros);
        System.out.println("Verifique o tamanho no Set: " + numeros.size());
        System.out.println("Verifique se o Set está vazio: " + numeros.isEmpty());

    }
}
