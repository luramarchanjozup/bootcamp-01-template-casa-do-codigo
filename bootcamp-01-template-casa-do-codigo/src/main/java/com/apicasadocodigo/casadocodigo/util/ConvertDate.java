package com.apicasadocodigo.casadocodigo.util;

import java.time.LocalDate;
import java.time.Month;

public class ConvertDate {

    public static LocalDate toLocalDate(String datesField){

        System.out.println(datesField);
        String[] dateFieldsArray = datesField.split("\\/");

        int day = Integer.parseInt(dateFieldsArray[0]);
        int month = Integer.parseInt(dateFieldsArray[1]);
        int year = Integer.parseInt(dateFieldsArray[2]);

        return LocalDate.of(year, month, day);
    }

    public static String toBrazilFormat(LocalDate localDate){

        int day = localDate.getDayOfMonth();
        Month month = localDate.getMonth();
        int year = localDate.getYear();

        return String.format("%d/%d/%d", day, month.getValue(), year);
    }

}
