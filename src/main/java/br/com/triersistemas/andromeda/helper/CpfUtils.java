package br.com.triersistemas.andromeda.helper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CpfUtils {

    public static String geraCpf(final List<Integer> digitos) {
        digitos.add(CpfUtils.mod11(digitos, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        digitos.add(CpfUtils.mod11(digitos, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        return StringUtils.listToString(digitos);
    }

    protected static int mod11(final List<Integer> digitos, final int... multiplicadores) {
        /*
        int soma = 0;
        for (int i = 0; i < multiplicadores.length; i++) {
            soma += digitos.get(i) * multiplicadores[i];
        }
        int resto = soma % 11;
        return resto > 9 ? 0 : resto;
        */
        final var i = new AtomicInteger(0);
        final var resto = digitos.stream()
                .reduce(0, (p, e) -> p + e * multiplicadores[i.getAndIncrement()]) % 11;
        return resto > 9 ? 0 : resto;
    }
}
