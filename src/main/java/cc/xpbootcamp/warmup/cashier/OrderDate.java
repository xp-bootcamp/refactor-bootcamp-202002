package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OrderDate {
    private Date date;
    private final String daysOfWeek[] = {"", "日", "一", "二", "三", "四", "五", "六"};

    public OrderDate(Date date) {
        this.date = date;
    }

    public OrderDate() {
        this.date = new Date();
    }

    public String getChineseWeek() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return "星期" + daysOfWeek[calendar.get(Calendar.DAY_OF_WEEK)];
    }

    public String getChineseDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年M月dd日");
        return simpleDateFormat.format(date.getTime());
    }

}
