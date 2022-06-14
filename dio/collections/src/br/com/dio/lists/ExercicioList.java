package br.com.dio.lists;

import java.util.*;

public class ExercicioList {
    public static void main(String[] args) {
        //Conhecendo os métodos List - parte 1

        //Como inicializar listas
        //antes do java 5
        List notasExemplo1 = new ArrayList();

        //A partir do java 1.5 usando Generics e 1.7 usando o diamond operator
        //Perceba que não precisamos repetir o Double no parâmetro do ArrayList
        List<Double> notasExemplo2 = new ArrayList<>();

        //Podemos inicializar diretamente da ArrayList invés da interface List
        //porém como alguns métodos são herdados dela, não é uma forma muito viável
        ArrayList<Double> notasExemplo3 = new ArrayList<>();

        //Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5,7,0, 3.6], faça:

        //Podemos adicionar os elementos usando o método Arrays.asList

        //Adicionando ao instanciar um objeto. Perceba que como nosso tipo é double, todos
        //os números que forem inteiros devem ter uma letra d
        List<Double> notasExemplo4 = new ArrayList<>((Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6)));

        //Podemos adicionar os valores dieratmente na List
        //A desvantagem desta forma é que é a lista fica inalterável
        List<Double> notasExemplo5 = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        ;

        //Outra forma de criar uma List, porém também a torna imutável
        List<Double> notasExemplo6 = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);

        System.out.print("1 - Crie uma lista e adicione as sete notas: ");

        List<Double> notas = new ArrayList<>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);

        System.out.println(notas);

        System.out.println("2 - Exiba o índice da nota 5.0: " + notas.indexOf(5d));

        System.out.print("3 - Adicione na lista a nota 8.0 no índice 4: ");

        //O método add possui sobrecarga de métodos ou overload, ond podemos dar como argumento além da nota, o
        // índice que será adicionado
        notas.add(4, 8d);
        System.out.println(notas);

        System.out.print("4 - Substitua a nota 5.0 pela nota 6.0: ");

        //Usamos o método set, que é bem parecido com o add usado no ex3, porém substituindo o elemento naquela posição
        notas.set(3, 6.0);
        //Pode ser usado o indexof também
        //notas.set(notas.indexOf(5d), 6.0);
        System.out.println(notas);

        System.out.println("5 - Confira se a nota 5.0 está na lista: " + notas.contains(5d));

        System.out.println("6 - Exiba todas as notas na ordem em que foram informadas: ");
        for (Double nota : notas) System.out.print(nota + " ");

        //Conhecendo os métodos List - parte 2
        System.out.println("\n8 - Exiba a terceira nota adicionada: " +notas.get(2));

        System.out.println("9 - Exiba a menor nota: " + Collections.min(notas));

        System.out.println("10 - Exiba a menor nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("11 - Exiba a soma dos valores: " + soma);

        System.out.println("12 - Exiba a média das notas: " + soma/notas.size());

        System.out.println("13 - Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("14 - Remova a nota da posição 0");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("15 - Remova as notas menores que 7 e exiba a lista:");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next1 = iterator1.next();
            if (next1 < 7) {
                iterator1.remove();
            }
        }
        System.out.println(notas);

        System.out.println("16 - Apague toda a lista");
        notas.clear();

        System.out.println("17 - Confira se a lista está vazia: " + notas.isEmpty());

    }
}
