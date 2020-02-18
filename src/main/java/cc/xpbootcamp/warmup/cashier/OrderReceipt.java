package cc.xpbootcamp.warmup.cashier;

import java.util.List;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private List<LineItem> lineItemList;
    private OrderDate orderDate;

    public OrderReceipt(List<LineItem> lineItemList, OrderDate orderDate) {
        this.lineItemList = lineItemList;
        this.orderDate = orderDate;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(getReceiptHeaders());
        output.append(orderDate.getOrderDate());
        output.append(getLineItemList());
        output.append(getFooter());
        return output.toString();
    }

    private String getFooter() {
        double totalTax = .0d;
        double totalPrice = .0d;
        double discount;
        for (LineItem lineItem : lineItemList) {
            totalTax += lineItem.totalAmount() * 0.1;
            totalPrice += lineItem.totalAmount();
        }
        totalPrice += totalTax;
        StringBuilder output = new StringBuilder();
        output.append("税额:   ");
        output.append(String.format("%.2f", totalTax));
        output.append("\n");

        if (orderDate.isDiscountDay()){
            discount = totalPrice * 0.02;
            totalPrice = totalPrice - discount;
            output.append("折扣:   ");
            output.append(String.format("%.2f", discount));
            output.append("\n");
        }
        output.append("总价:   ");
        output.append(String.format("%.2f", totalPrice));
        output.append("\n");


        return output.toString();

    }


    private String getLineItemList() {
        StringBuilder output = new StringBuilder();
        for (LineItem lineItem : lineItemList) {
            output.append(lineItem.getDescription());
            output.append(", ");
            output.append(String.format("%.2f", lineItem.getPrice()));
            output.append(" ");
            output.append("x");
            output.append(" ");
            output.append(lineItem.getQuantity());
            output.append(", ");
            output.append(String.format("%.2f", lineItem.totalAmount()));
            output.append("\n");
        }
        output.append("-----------------------------------\n");
        return output.toString();
    }

    private String getReceiptHeaders() {
        return "===== 老王超市，值得信赖 ======\n";
    }
}
