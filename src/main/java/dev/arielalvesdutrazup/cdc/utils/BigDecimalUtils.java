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
     * Exemplo: 100.00 == 80.00 ->  true
     *
     * @param de
     * @param com
     * @return
     */
    public static boolean maiorQue(BigDecimal de, BigDecimal com) {
        return de.compareTo(com) == MAIOR_QUE;
    }

    public static BigDecimal porcentagemDe(Integer porcentagem, BigDecimal total) {
        return porcentagemDe(new BigDecimal(porcentagem), total);

    }

    /**
     * Retorna a porcental do total fornecido.
     *
     * Exemplo: 80.00, 200.00 -> 160.00
     *
     * @param porcentagem
     * @param total
     * @return
     */
    public static BigDecimal porcentagemDe(BigDecimal porcentagem, BigDecimal total) {
        return total
                .multiply(porcentagem)
                .divide(new BigDecimal("100.00"));
    }

    /**
     * Retorna o total subtraido pela porcentagem.
     *
     * Exemplo: 80.00, 200.00 -> 40.00
     *
     * @param porcentagem
     * @param total
     * @return
     */
    public static BigDecimal discontaPorcentagemDe(Integer porcentagem, BigDecimal total) {
        return total.subtract(porcentagemDe(porcentagem, total));
    }
}
