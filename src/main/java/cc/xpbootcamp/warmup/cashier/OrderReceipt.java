package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(getReceiptHeaders());
        output.append(getReceiptBody());
        output.append(getFooter());
        return output.toString();
    }

    private String getReceiptBody() {
        StringBuilder output = new StringBuilder();
        output.append(order.getOrderDate()).append('\n');
        output.append(order.getLineItemList());
        return output.toString();

    }

    private String getFooter() {
        StringBuilder output = new StringBuilder();
        output.append(getTotalTax());
        output.append(getTotalDiscount());
        output.append((getTotalAmout()));
        return output.toString();

    }

    private String getTotalAmout() {
        StringBuilder output = new StringBuilder();
        output.append("总价:   ");
        output.append(String.format("%.2f", order.calcTotalAmount()));
        output.append("\n");
        return output.toString();
    }

    private String getTotalDiscount() {
        StringBuilder output = new StringBuilder();
        if (order.isDiscountDay()){
            output.append("折扣:   ");
            output.append(String.format("%.2f", order.calcTotalDiscount()));
            output.append("\n");
        }
        return output.toString();

    }

    private String getTotalTax() {
        StringBuilder output = new StringBuilder();
        output.append("税额:   ");
        output.append(String.format("%.2f", order.calcTotalTax()));
        output.append("\n");
        return output.toString();
    }

    private String getReceiptHeaders() {
        return "===== 老王超市, 值得信赖 ======\n";
    }
}
