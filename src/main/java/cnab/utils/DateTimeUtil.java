package cnab.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class DateTimeUtil {

    private DateTimeUtil() {
    }

    public static String dateFormat(LocalDate date) {
        if (Objects.isNull(date)){
            return Util.formatFieldToBePrinted(0,8);
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        return date.format(dateTimeFormatter);
    }

    public static String timeFormat(LocalTime time) {
        if (Objects.isNull(time)){
            return Util.formatFieldToBePrinted(0,6);
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmmss");
        return time.format(dateTimeFormatter);
    }

}
