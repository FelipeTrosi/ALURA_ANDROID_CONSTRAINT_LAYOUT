package br.com.curso.alura.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar dataHoje = Calendar.getInstance();
        Calendar dataFinal = Calendar.getInstance();
        dataFinal.add(Calendar.DATE, dias);
        SimpleDateFormat formataData = new SimpleDateFormat(DIA_MES);
        String dataHojeFormatada = formataData.format(dataHoje.getTime());
        String dataFinalFormatada = formataData.format(dataFinal.getTime());
        return dataHojeFormatada + " - " + dataFinalFormatada + " de " + dataFinal.get(Calendar.YEAR);
    }

}
