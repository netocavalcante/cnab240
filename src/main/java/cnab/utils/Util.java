package cnab.utils;

import java.util.Objects;

public final class Util {

    private Util() {
    }

    public static <T> String formatFieldToBePrinted(T field, int size) {
        if (Objects.isNull(field)){
            return "";
        }

        if (field instanceof String) {
            return formatFieldToBePrinted((String)field, size);
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
            return "0".repeat(size);
        }

        fieldString = fieldString.replace(".","");

        return  "0".repeat(size - fieldString.length()) + fieldString;
    }

    public static <T> String getValueIfExist(T propertie ) {
        return Objects.isNull(propertie) ? "" : propertie.toString();
    }
}
