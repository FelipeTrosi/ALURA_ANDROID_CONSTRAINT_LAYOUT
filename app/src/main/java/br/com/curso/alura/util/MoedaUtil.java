package br.com.curso.alura.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static String formataMoedaBrasileira(BigDecimal valor) {
        NumberFormat formataMoeda = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        return formataMoeda.format(valor).replace("R$", "R$ ");
    }
}
