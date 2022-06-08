package br.com.triersistemas.andromeda.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;

public class StringUtils {

    private StringUtils() { }

    public static String getRandomName() {
        List<String> nomes = new ArrayList<>();
        nomes.add("Bianca");
        nomes.add("Vitória");
        nomes.add("Caethana");
        nomes.add("Kay");
        nomes.add("Amanda");
        nomes.add("Carol");
        nomes.add("Davi");
        nomes.add("Igor");
        nomes.add("Antônio");
        nomes.add("Edymar");
        nomes.add("Edward");
        SplittableRandom r = new SplittableRandom();
        return nomes.get(r.nextInt(0, nomes.size()));
    }

    public static List<String> getRandomMeds() {
        List<String> listaRetorno = new ArrayList<>();
        List<String> lista = new ArrayList<>();
        lista.add("Dipirona");
        lista.add("Frauda Anjinho");
        lista.add("Dove my care");
        lista.add("Trident");
        lista.add("Paracetamol");
        lista.add("Rivotril");
        lista.add("Cloridrato de paroxetina");
        lista.add("Valium");
        lista.add("Valeriana");
        lista.add("Floral");
        lista.add("Dramin");

        var r = new SplittableRandom();

        for (int i = 0; i < r.nextInt(2, lista.size()); i++) {
            var p = lista.get(r.nextInt(0, lista.size()));
            listaRetorno.add(p);
            lista.remove(p);
        }
        return listaRetorno;
    }

    public static String getRandomMed() {
        List<String> lista = new ArrayList<>();
        lista.add("Dipirona");
        lista.add("Frauda Anjinho");
        lista.add("Dove my care");
        lista.add("Trident");
        lista.add("Paracetamol");
        lista.add("Rivotril");
        lista.add("Cloridrato de paroxetina");
        lista.add("Valium");
        lista.add("Valeriana");
        lista.add("Floral");
        lista.add("Dramin");
        var r = new SplittableRandom();
        return lista.get(r.nextInt(0, lista.size()));
    }

    public static String extractNumbers(final String val) {
        if (Objects.nonNull(val)) {
            return val.replaceAll("\\D+", "");
        }
        return "";
    }

    public static List<Integer> extractNumbersToList(final String value) {
        List<Integer> digitos = new ArrayList<>();
        for (char item : extractNumbers(value).toCharArray()) {
            digitos.add(Integer.parseInt(String.valueOf(item)));
        }
        return digitos;
    }

    public static String listToString(final List<Integer> list) {
        return list.stream()
                .map(Object::toString)
                .reduce("", (p, e) -> p + e);
    }
}
