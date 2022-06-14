package Optionals;

import java.util.Optional;

public class ExerciciosOptional {
    public static void main(String[] args) {
        System.out.println("Crie optionals com estado vazio, presente e null");
        Optional<String> mensagem1 = Optional.of("Olá, mundo");
        Optional<String> mensagem2 = Optional.empty();
        Optional<String> mensagem3 = Optional.ofNullable(null);

        System.out.println("Se presente, exiba o valor no console");
        System.out.println("Se vazio, lance uma execeção");
//        mensagem1 = Optional.ofNullable(null);
        if (mensagem1.isPresent()) {
            String valor = mensagem1.get();
            System.out.println(mensagem1);
//            System.out.println(mensagem1);
        } else {
            mensagem1.orElseThrow(IllegalStateException::new);
        }

        System.out.println("Se vazio, exiba \"Optional vazio\" no console");
//        mensagem1 = Optional.ofNullable(null);
        mensagem1.ifPresentOrElse(System.out::println, () -> System.out.println("Optional vazio"));

        System.out.println("Se presente, transforme o valor do optional e exiba no console");
        mensagem1.map((mensagem4) -> mensagem4.concat(":::")).ifPresent(System.out::println);
        System.out.println("Se presente, pegue o valor do optional e atribua em uma variável");
        String mensagemNova = "";
        if (mensagem1.isPresent()) {
            mensagemNova = mensagem1.get();
            System.out.println(mensagemNova+"!");
        }

        System.out.println("Se presente, filtre o optional com uma determinada regra de negócio");
    }
}
