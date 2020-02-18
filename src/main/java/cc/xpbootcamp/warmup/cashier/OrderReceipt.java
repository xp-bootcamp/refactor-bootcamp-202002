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
        output.append(order.getOrderDate());
        output.append(order.getLineItemList());
        output.append(getFooter());
        return output.toString();
    }

    private String getFooter() {
        double totalTax = order.calcTotalTax();
        double totalPrice = order.calcTotalPrice(totalTax);
        StringBuilder output = new StringBuilder();
        output.append("税额:   ");
        output.append(String.format("%.2f", totalTax));
        output.append("\n");
        if (order.isDiscountDay())
        {
            double totalDiscount = order.calcTotalDiscount(totalPrice);
            totalPrice -= totalDiscount;
            output.append("折扣:   ");
            output.append(String.format("%.2f", totalDiscount));
            output.append("\n");
        }

        output.append("总价:   ");
        output.append(String.format("%.2f", totalPrice));
        output.append("\n");
        return output.toString();

    }

    private String getReceiptHeaders() {
        return "===== 老王超市，值得信赖 ======\n";
    }
}
