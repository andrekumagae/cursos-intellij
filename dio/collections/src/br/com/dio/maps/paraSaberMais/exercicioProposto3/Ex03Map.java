package br.com.dio.maps.paraSaberMais.exercicioProposto3;

/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);

id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/

import java.util.*;

public class Ex03Map {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        for (Map.Entry<Integer, Contato> ag : agenda.entrySet()) {
            System.out.println(ag.getKey() + " - " + ag.getValue().getNome());
        }
        System.out.println("--\tOrdem inserção\t--");
        Map<Integer, Contato> agenda2 = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        for (Map.Entry<Integer, Contato> ag : agenda2.entrySet()) {
            System.out.println(ag.getKey() + " - " + ag.getValue().getNome());
        }
        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> agenda3 = new TreeMap<>(agenda);
        for (Map.Entry<Integer, Contato> ag : agenda3.entrySet()) {
            System.out.println(ag.getKey() + " - " + ag.getValue().getNome());
        }
        System.out.println("--\tOrdem número telefone\t--");
        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(new OrdemPorNumeroTelefone());
        agenda4.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> ag : agenda4) {
            System.out.println(ag.getKey() + " - " + ag.getValue().getNome() + " - " + ag.getValue().getNumero());
        }
        System.out.println("--\tOrdem nome de contato\t--");
        Set<Map.Entry<Integer, Contato>> agenda5 = new TreeSet<>(new OrdemPorNomeContato());
        agenda5.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> ag : agenda5) {
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

class OrdemPorNomeContato implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}
