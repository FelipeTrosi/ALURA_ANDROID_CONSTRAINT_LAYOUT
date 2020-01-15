package br.com.curso.alura.util;

public class DiasUtil {

    public static String formataDiasEmTexto(int quantidadeDeDias) {
        if (quantidadeDeDias > 1) {
            return quantidadeDeDias + " dias";
        }
        return quantidadeDeDias + " dia";
    }
}
