package cc.xpbootcamp.warmup.cashier;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;

class OrderReceiptTest {

    @Test
    void should_print_right_receipt_not_contain_discount_given_date_is_not_wednesday() {
        Date date = new Date(2020 - 1900, 1, 18);
        List<Item> items = new ArrayList<Item>() {{
            add(new Item("巧克力", 21.50, 2));
            add(new Item("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, items, date));

        String output = receipt.printReceipt();
        assertEquals(output, "===== 老王超市，值得信赖 ======\n\n2020年2月18日，星期二\n巧克力, 21.50 x 2, 43.00\n小白菜, 10.00 x 1, 10.00\n-----------------------------------\n税额:   5.30\n总价:   58.30\n");
    }

    @Test
    void should_print_right_receipt_contain_discount_given_date_is_wednesday() {
        Date date = new Date(2020 - 1900, 1, 19);
        List<Item> items = new ArrayList<Item>() {{
            add(new Item("巧克力", 21.50, 2));
            add(new Item("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, items, date));

        String output = receipt.printReceipt();
        assertEquals(output, "===== 老王超市，值得信赖 ======\n\n2020年2月19日，星期三\n巧克力, 21.50 x 2, 43.00\n小白菜, 10.00 x 1, 10.00\n-----------------------------------\n税额:   5.30\n折扣:   1.17\n总价:   57.13\n");
    }

}
