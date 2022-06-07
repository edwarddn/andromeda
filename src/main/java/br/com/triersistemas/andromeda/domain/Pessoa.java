package br.com.triersistemas.andromeda.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Pessoa {
    private String nome;
    private LocalDate niver;

    protected Pessoa() {
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
        this.nome = nomes.get(r.nextInt(0, nomes.size()));
        this.niver = LocalDate.now();
    }

    protected Pessoa(final String nome, final LocalDate niver) {
        this.nome = nome;
        this.niver = niver;
    }

    public String getNome() {
        return nome;
    }

    public String getNiver() {
        if (Objects.nonNull(niver)) {
            return niver.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return "";
    }

    public Long getIdade() {
            /*
            var hoje = LocalDate.now();
            int idade = hoje.getYear() - niver.getYear();
            if (hoje.getMonthValue() < niver.getMonthValue() ||
                    (hoje.getMonthValue() == niver.getMonthValue()
                            && hoje.getDayOfMonth() < niver.getDayOfMonth())) {
                idade--;
            }
            return idade;
            */
        return Objects.nonNull(niver) ? ChronoUnit.YEARS.between(niver, LocalDate.now()) : 0L;
    }

    public abstract String getDocumento();

    public abstract boolean getDocumentoValido();

    protected int mod11(final List<Integer> digitos, final int... multiplicadores) {
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

    protected String extractNumbers(final String val) {
        if (Objects.nonNull(val)) {
            return val.replaceAll("\\D+", "");
        }
        return "";
    }

    protected List<Integer> extractNumbersToList(final String cpf) {
        List<Integer> digitos = new ArrayList<>();
        for (char item : extractNumbers(cpf).toCharArray()) {
            digitos.add(Integer.parseInt(String.valueOf(item)));
        }
        return digitos;
    }
}
