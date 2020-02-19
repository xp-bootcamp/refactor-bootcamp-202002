package cc.xpbootcamp.warmup.cashier;

import java.util.Date;
import java.util.List;

public class Order {
    private final double taxPercent = 0.1;
    private final double discount = 0.98;
    private OrderDate orderDate;
    private List<LineItem> lineItemList;
    private Customer customer;

    public Order(OrderDate orderDate, List<LineItem> lineItemList) {
        this.orderDate = orderDate;
        this.lineItemList = lineItemList;
    }

    public Order(OrderDate orderDate, List<LineItem> lineItemList, Customer customer) {
        this.orderDate = orderDate;
        this.lineItemList = lineItemList;
        this.customer = customer;
    }

    public  String getOrderDate(){
        String date_cn = orderDate.getChineseDate();
        String week_cn = orderDate.getChineseWeek();
        return date_cn + '，' + week_cn + '\n';
    }

    public String getLineItemList() {
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

    public double calcTotalTax(){
        double totalTax = .0d;
        for (LineItem lineItem : lineItemList) {
            totalTax += lineItem.totalAmount() * taxPercent;
        }
        return totalTax;
    }

    public double calcTotalAmout(){
        double totalPrice = .0d;
        for (LineItem lineItem : lineItemList) {
            totalPrice += lineItem.totalAmount();
        }

        return totalPrice + calcTotalTax() - (isDiscountDay() ? calcTotalDiscount() : 0);
    }


    public boolean isDiscountDay() {
        return "星期三".equals(orderDate.getChineseWeek());

    }

    public double calcTotalDiscount() {
        double totalPrice = .0d;
        for (LineItem lineItem : lineItemList) {
            totalPrice += lineItem.totalAmount();
        }
        return (totalPrice + calcTotalTax()) * (1 - discount);
    }
}

