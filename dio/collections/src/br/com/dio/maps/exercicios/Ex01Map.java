package br.com.dio.maps.exercicios;

import java.util.*;

public class Ex01Map {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário e relacione os estados e suas populações");
        Map<String, Integer> estadosNordeste = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        for (Map.Entry<String, Integer> e : estadosNordeste.entrySet()) {
            System.out.println("Sigla: " + e.getKey() + " - População: " + e.getValue());
        }
        System.out.println("\nSubstitua a população do estado do RN por 3534165");
        estadosNordeste.put("RN", 3534165);
        for (Map.Entry<String, Integer> e : estadosNordeste.entrySet()) {
            System.out.println("Sigla: " + e.getKey() + " - População: " + e.getValue());
        }
        System.out.println("\nConfira se o estado PB está no dicionário, caso não, adicione PB - 4093277");
        if (estadosNordeste.containsKey("PB")) {
            System.out.println("Existe!");
        } else {
            System.out.println("Adicionando...");
            estadosNordeste.put("PB", 4039277);
        }
        System.out.println("\nExiba a população PE: " + estadosNordeste.get("PB"));
        System.out.println("\nExiba todos os estqados e suas populações na ordem que foi informada");
        Map<String, Integer> estadosNe1 = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        for (Map.Entry<String, Integer> e : estadosNe1.entrySet()) {
            System.out.println("Sigla: " + e.getKey() + " - População: " + e.getValue());
        }
        System.out.println("\nExiba os estados e suas populações em ordem alfabética:");
        Map<String, Integer> estadosNe2 = new TreeMap<>(estadosNordeste);
        for (Map.Entry<String, Integer> e : estadosNe2.entrySet()) {
            System.out.println("Sigla: " + e.getKey() + " - População: " + e.getValue());
        }
        Integer menorPopulacao = Collections.min(estadosNordeste.values());
        for (Map.Entry<String, Integer> e : estadosNordeste.entrySet()) {
            if (e.getValue().equals(menorPopulacao)) {
                String menorPopulacaoEstado = e.getKey();
                System.out.println("\nExiba o estado com a menor população e sua quantidade: Estado: " + menorPopulacaoEstado + " - População: " + menorPopulacao);
            }
        }

        Integer maiorPopulacao = Collections.max(estadosNordeste.values());
        for (Map.Entry<String, Integer> e : estadosNordeste.entrySet()) {
            if (e.getValue().equals(maiorPopulacao)) {
                String maiorPopulacaoEstado = e.getKey();
                System.out.println("\nExiba o estado com a maior população e sua quantidade: Estado: " + maiorPopulacaoEstado + " - População: " + maiorPopulacao);
            }
        }

        Integer soma = 0;
        for (Map.Entry<String, Integer> e : estadosNordeste.entrySet()) {
            soma += e.getValue();
        }
        System.out.println("\nExiba a soma da população dos estados: " + soma);

        System.out.println("\nExiba a média da população deste dicionário de estados: " + soma/estadosNordeste.size());

        System.out.println("\nRemova os estados com a população menor que 4000000");
        Iterator<Integer> iterador = estadosNordeste.values().iterator();
        while (iterador.hasNext()) {
            Integer i = iterador.next();
            if (i < 4000000) {
                iterador.remove();
            }
        }
        for (Map.Entry<String, Integer> e : estadosNordeste.entrySet()) {
            System.out.println("Sigla: " + e.getKey() + " - População: " + e.getValue());
        }
        System.out.println("\nApague o dicionário de estados");
        estadosNordeste.clear();
        System.out.println("\nConfira se o dicionário está vazio: " + estadosNordeste.isEmpty());
    }
}

class Estados {
    private String nome;
    private Integer populacao;

    public Estados(String nome, Integer populacao) {
        this.nome = nome;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estados estados = (Estados) o;
        return Objects.equals(nome, estados.nome) && Objects.equals(populacao, estados.populacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, populacao);
    }

    @Override
    public String toString() {
        return "Estados{" +
                "nome='" + nome + '\'' +
                ", populacao=" + populacao +
                '}';
    }
}