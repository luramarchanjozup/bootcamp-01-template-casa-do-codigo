package dev.arielalvesdutrazup.cdc.utils;

import java.math.BigDecimal;

/**
 * Classe auxiliar para BigDecimal.
 */
public class BigDecimalUtils {

    private static final Integer MAIOR_QUE = 1;

    /**
     * Retorna verdadeiro se 'de' for maior que 'com'.
     *
     * @param de
     * @param com
     * @return
     */
    public static boolean maiorQue(BigDecimal de, BigDecimal com) {
        return de.compareTo(com) == MAIOR_QUE;
    }
}
