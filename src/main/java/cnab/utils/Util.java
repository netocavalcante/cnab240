package cnab.utils;

import java.util.Objects;

public final class Util {

    private static final String EMPTY_STRING = "";
    private static final String ZERO_AS_STRING = "0";

    private Util() {
    }

    public static <T> String formatFieldToBePrinted(T field, int size, int emptySpace) {
        if (Objects.isNull(field)){
            return EMPTY_STRING;
        }

        return formatFieldToBePrinted(" ", emptySpace) + formatFieldToBePrinted((Number)field, size);
    }

    public static <T> String formatFieldToBePrinted(T field, int size) {
        if (Objects.isNull(field)){
            return EMPTY_STRING;
        }

        if (field instanceof String fieldValue) {
            return formatFieldToBePrinted(fieldValue, size);
        }

        return formatFieldToBePrinted((Number)field, size);
    }

    public static String formatFieldToBePrinted(String field, int size) {
        if (field.length() >= size) {
            return field.substring(0 , size);
        }

        return field + " ".repeat(size - field.length());
    }

    public static <T extends Number>  String formatFieldToBePrinted(T field, int size) {
        String fieldString = String.valueOf(field);

        if (fieldString.length() >= size) {
            return fieldString.substring(0,size);
        }

        if (field.equals(0)) {
            return ZERO_AS_STRING.repeat(size);
        }

        fieldString = fieldString.replace(".",EMPTY_STRING);

        return  ZERO_AS_STRING.repeat(size - fieldString.length()) + fieldString;
    }

    public static <T> String getValueIfExist(T propertie ) {
        return Objects.isNull(propertie) ? EMPTY_STRING : propertie.toString();
    }
}
