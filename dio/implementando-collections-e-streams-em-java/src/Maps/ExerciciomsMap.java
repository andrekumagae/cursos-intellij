package Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class ExerciciomsMap {
    public static void main(String[] args) {
        System.out.println("Adicione os 26 estados brasileiros no map, onde a sigla representa a chave e o nome do " +
                "estado o valor" +
                ".");
        Map<String, String> estadosBrasil = new HashMap<>() {{
            put("AC", "Acre");
            put("AL", "Alagoas");
            put("AP", "Amapá");
            put("AM", "Amazonas");
            put("BA", "Bahia");
            put("CE", "Ceará");
            put("ES", "Espírito Santo");
            put("GO", "Goiás");
            put("MA", "Maranhão");
            put("MT", "Mato Grosso");
            put("MS", "Mato Grosso do Sul");
            put("MG", "Minas Gerais");
            put("PA", "Pará");
            put("PB", "Paraíba");
            put("PR", "Paraná");
            put("PE", "Pernambuco");
            put("PI", "Piauí");
            put("RJ", "Rio de Janeiro");
            put("RN", "Rio Grande do Norte");
            put("RS", "Rio Grande do Sul");
            put("RO", "Rondônia");
            put("RR", "Roraima");
            put("SC", "Santa Catarina");
            put("SP", "São Paulo");
            put("SE", "Sergipe");
            put("TO", "Tocantins");
        }};
        for (Map.Entry<String, String> e : estadosBrasil.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        System.out.println("Remova o estado de Minas Gerais: " + estadosBrasil.remove("MG"));
        System.out.println("Adicione o Distrito Federal: " + estadosBrasil.put("DF", "Distrito Federal"));
        System.out.println("Verifique o tamanho do mapa: " + estadosBrasil.size());
        System.out.println("Remova o estado de Mato Grosso do Sul usando o nome: ");
        Iterator<String> iterador = estadosBrasil.values().iterator();
        while (iterador.hasNext()) {
            if (iterador.next().equals("Mato Grosso do Sul")) {
                iterador.remove();
            }
        }
        System.out.println(estadosBrasil.get("MS"));
        System.out.println("Navegue em todos os registros do map, mostrando no console no seguinte formato: NOME " +
                "(SIGLA)");
        for (Map.Entry<String, String> e : estadosBrasil.entrySet()) {
            System.out.println(e.getValue().toUpperCase(Locale.ROOT) + " (" + e.getKey() + ")");
        }
        System.out.println("Verifique se o estado de Santa Catarina existe no map buscando por sua sigla: " + estadosBrasil.containsKey("SC"));
        System.out.println("Verifique se o estado de Maranhão existe no map buscando por seu nome: " + estadosBrasil.containsValue("Maranhão"));
    }
}
