package cc.xpbootcamp.warmup.cashier;

import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private static final String LINE_ITEM_PRINT_FORMAT = "%s, %.2f x %s, %.2f\n";
    private static final String SEPARATE_LINE = "-----------------------------------\n";

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {

        String output = buildReceiptHeaders() +
                buildDateInfo() + '\n' +
                buildReceiptBody() +
                buildFooter();
        return output;
    }

    private String buildDateInfo() {
        return order.getOrderDate();
    }

    private String buildReceiptBody() {
        StringBuilder output = new StringBuilder();
        output.append(printLineItemList());
        output.append(SEPARATE_LINE);
        return output.toString();

    }
    private String getLineItemInfo(LineItem lineItem){
        return String.format(LINE_ITEM_PRINT_FORMAT, lineItem.getDescription(), lineItem.getPrice(),
                lineItem.getQuantity(), lineItem.totalAmount());
    }
    private String printLineItemList() {
        return order.getLineItemList().stream().map(this::getLineItemInfo).collect(Collectors.joining());
    }

    private String buildFooter() {
        String output = printTotalTax() +
                printTotalDiscount() +
                printTotalAmount();
        return output;

    }

    private String printTotalAmount() {
        StringBuilder output = new StringBuilder();
        output.append("总价:   ");
        output.append(String.format("%.2f", order.calcTotalAmount()));
        output.append("\n");
        return output.toString();
    }

    private String printTotalDiscount() {
        StringBuilder output = new StringBuilder();
        if (order.isDiscountDay()) {
            output.append("折扣:   ");
            output.append(String.format("%.2f", order.calcTotalDiscount()));
            output.append("\n");
        }
        return output.toString();

    }

    private String printTotalTax() {
        StringBuilder output = new StringBuilder();
        output.append("税额:   ");
        output.append(String.format("%.2f", order.calcTotalTax()));
        output.append("\n");
        return output.toString();
    }

    private String buildReceiptHeaders() {
        return "===== 老王超市, 值得信赖 ======\n";
    }
}
