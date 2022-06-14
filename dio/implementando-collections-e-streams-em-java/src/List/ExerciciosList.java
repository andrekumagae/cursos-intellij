package List;

import java.util.ArrayList;
import java.util.List;


public class ExerciciosList {
    public static void main(String[] args) {
        System.out.println(".::\tCrie uma lista e execute as seguintes operações\t::.");
        System.out.println(".::\tAdicione 5 nomes\t::.");
        List<String> nomes = new ArrayList<>(){{
            add("Juliana");
            add("Pedro");
            add("Carlos");
            add("Larissa");
            add("João");
        }};
        System.out.println(".::\tNavegue na lista exibindo cada nome no console\t::.");
        for (String n : nomes) {
            System.out.println(n);
        }
        System.out.println(".::\tSubstitua o nome Carlos por Roberto\t::.");
        nomes.set(2,"Roberto");
        System.out.println(nomes);
        System.out.println("\n.::\tRetorne o nome da posição 1\t::.\n" + nomes.get(1));
        System.out.println("\n.::\tRemova o nome da posição 4\t::.");
        nomes.remove(4);
        System.out.println(nomes);
        System.out.println("\n.::\tRemova o nome João\t::.");
        nomes.remove("João");
        System.out.println(nomes);
        System.out.println("\n.::\tRetorne a quanntidade de itens na lista\t::.\n" +nomes.size()) ;
        System.out.println("\n.::\tVerifique se o nome Juliano existe na lista\t::.\n" + nomes.contains("Juliano"));
        System.out.println("\n.::\tCrie uma nova lista com os nomes: Ismael e Rodrigo\t::.");
        List<String> nomes2 = new ArrayList<>(){{
            add("Ismael");
            add("Rodrigo");
        }};
        nomes2.addAll(nomes);
        System.out.println(nomes2);



    }
}
