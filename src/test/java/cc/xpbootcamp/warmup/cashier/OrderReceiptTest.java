package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintReceiptHeaderAndDate() {
        Date orderDate = new Date(120, 1, 17);

        OrderReceipt receipt = new OrderReceipt(new Order(orderDate ,new ArrayList<LineItem>()));

        String output = receipt.printReceipt();


        assertThat(output, containsString("===== 老王超市, 值得信赖 ======\n"));
        assertThat(output, containsString("2020年2月17日, 星期一\n"));
    }

    @Test
    public void shouldNotCalcDiscount() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        Date orderDate = new Date(120, 1, 17);
        OrderReceipt receipt = new OrderReceipt(new Order(orderDate ,lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00\n"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00\n"));
        assertThat(output, containsString("税额:   5.30\n"));
        assertThat(output, containsString("总价:   58.30\n"));
    }

    @Test
    public void shouldCalcDiscount() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        Date orderDate = new Date(120, 1, 19);

        OrderReceipt receipt = new OrderReceipt(new Order(orderDate, lineItems));

        String output = receipt.printReceipt();
        System.out.println(output);

        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00\n"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00\n"));
        assertThat(output, containsString("税额:   5.30\n"));
        assertThat(output, containsString("折扣:   1.17\n"));
        assertThat(output, containsString("总价:   57.13\n"));
    }

}
