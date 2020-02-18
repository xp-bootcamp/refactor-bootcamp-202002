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

    public String getOrderDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年M月dd日");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        String date_cn = simpleDateFormat.format(date.getTime());
        String week_cn = daysOfWeek[calendar.get(Calendar.DAY_OF_WEEK)];
        return date_cn + '，' + "星期" + week_cn + '\n';
    }
}
