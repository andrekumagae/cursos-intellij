package br.com.dio.sets.exemplos;


import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

//      Set notas = new HashSet(); //antes do java 5
//      HashSet<Double> notas = new HashSet<>();
//      Set<Double> notas = new HashSet<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
/*      Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        notas.add(1d);
        notas.remove(5d);
        System.out.println(notas);
*/

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);
        System.out.println();

//        System.out.println("Exiba a posição da nota 5.0: ");
//        Não é possível, pois a coleção Set não possui índice, logo não podemos usar o método indexOf()

//        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
//        Por não ter índice, não conseguimos usar o método add em uma posição específica

//        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
//        O mesmo vale para o método set

        System.out.print("Confira se a nota 5.0 está no conjunto: " +  notas.contains(5d));
//        É possível pelo método contains(valor desejado);

//        System.out.println("Exiba a terceira nota adicionada: ");
//        Não podemos usar o método get no Set

        System.out.print("Exiba a menor nota: ");
//        Devemos utilizar o método min da Classe Collections
        System.out.println(Collections.min(notas));

        System.out.print("Exiba a maior nota: ");
        System.out.println(Collections.max(notas));

//      Chame o método da classe Set e guarde na var iterador de classe Iterator
        Iterator<Double> iterador = notas.iterator();
        double soma = 0d;
//      Essa var irá iterar e utilizando o método hasNext irá retornar um boolean se tiver ou não um elemento na próxima
//      posição
        while (iterador.hasNext()) {
//            Caso true irá guardar este valor na var next e somá-la
            double next = iterador.next();
            soma += next;
        }


        System.out.printf("Exiba a soma dos valores: %4.2f ", soma);

        System.out.printf("\nExiba a média das notas: %4.2f ", (soma / notas.size()));

        System.out.println("\nRemova a nota 0: ");
//        Importante colocar o "d" depois do número para o código entender que quero remover o numeral 0 double, e não o
//        objeto de indices 0, que no caso da classe Set, não consegue trabalhar com indices
        notas.remove(0d);
        System.out.println(notas);

//        System.out.println("Remova a nota da posição 0");
//        Não é possível, pois a classe Set não trabalha com índices

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterador2 = notas.iterator();
        while (iterador2.hasNext()) {
            Double next = iterador2.next();
            if (next < 7) {
//                Perceba que o método remove é da classe Iterator e não da classe Set como feito acima.
                iterador2.remove();
            }
        }


        System.out.println(notas);

        System.out.print("Exiba todas as notas na ordem em que foram informados: ");
//        Usamos a collection LinkedHashSet para "linkarmos" a ordem de adição
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
//        Perceba o erro por ter valores repetidos, que não são permitidos nas classes Set
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);


        System.out.print("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto");
        notas.clear();

        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());

    }
}

