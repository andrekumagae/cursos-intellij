package br.com.dio.streamApi.RefatorandoEx3Map;

/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);

id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/

import java.util.*;
import java.util.function.Function;

import static javax.swing.UIManager.put;

public class Ex03Map {
    public static void main(String[] args) {
        System.out.println("--\tOrdem número telefone pela classe externa\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};

        Set<Map.Entry<Integer, Contato>> agendaClasseExterna = new TreeSet<>(new OrdemPorNumeroTelefone());
        agendaClasseExterna.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> ag : agendaClasseExterna) {
            System.out.println(ag.getKey() + " - " + ag.getValue().getNome() + " - " + ag.getValue().getNumero());
        }

        System.out.println("--\tOrdem número telefone pela classe anônima\t--");
        /*Criando uma classe anônima ao invés de criar um Comparator numa classe a parte. Perceba que a classe toda
        fica no parêntese do TreeSet como argumento. No bloco de chaves do Comparator fica o método compare(). */
        Set<Map.Entry<Integer, Contato>> agendaClasseAnonima = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> contato1, Map.Entry<Integer, Contato> contato2) {
                return Integer.compare(contato1.getValue().getNumero(), contato2.getValue().getNumero());
            }
        });
        agendaClasseAnonima.addAll(agendaClasseExterna);
        for (Map.Entry<Integer, Contato> ag : agendaClasseAnonima) {
            System.out.println(ag.getKey() + " - " + ag.getValue().getNome() + " - " + ag.getValue().getNumero());
        }
        /*Perceba que usamos o método comparing do Comparator e instanciamos dentro dele a interface Function.
        * Depois Implementei o método apply onde precisamos informar após o tipo do Set, que é Integer e Contato e
        * fora dos <> deve-se substituir o Object pelo tipo primitivo do valor que queremos comparar, no caso o
        * número do telefone que é Integer. Por fim, simplificamos o comando do compare
        * que usávamos para apenas getValue().getter da variável que estamos comparando*/
        System.out.println("--\tOrdem número telefone pela Interface Function\t--");
        Set<Map.Entry<Integer, Contato>> agendaFunction =
                new TreeSet<>(Comparator.comparing(new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> contato) {
                        return contato.getValue().getNumero();
                    }
                }));
        agendaFunction.addAll(agendaClasseExterna);
        for (Map.Entry<Integer, Contato> ag : agendaFunction) {
            System.out.println(ag.getKey() + " - " + ag.getValue().getNome() + " - " + ag.getValue().getNumero());
        }
        /*Comparando com a forma de fazer com a interface Function, nós apagamos toda a parte da classe anônima até a
         variável que desejamos usar, no caso da Function era contFunction. Adicionamos a flecha e apagamos a palavra
          reservada return.*/
        System.out.println("--\tOrdem número telefone pela expressão Lambda\t--");
        Set<Map.Entry<Integer, Contato>> agendaLambda = new TreeSet<>(Comparator.comparing(
                contatoLambda -> contatoLambda.getValue().getNumero()
        ));
        agendaLambda.addAll(agendaClasseExterna);
        for (Map.Entry<Integer, Contato> ag : agendaLambda) {
            System.out.println(ag.getKey() + " - " + ag.getValue().getNome() + " - " + ag.getValue().getNumero());
        }
    }
}

class OrdemPorNumeroTelefone implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
    }
}