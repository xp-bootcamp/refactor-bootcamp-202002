package cc.xpbootcamp.warmup.cashier.utils;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class DateUtils {
    static DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);

    public static String format(Date date) {
        return df.format(date).replace(" ","，");
    }

    public static boolean isWednesday(Date date) {
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        return dateFm.format(date).equals("星期三");
    }
}
