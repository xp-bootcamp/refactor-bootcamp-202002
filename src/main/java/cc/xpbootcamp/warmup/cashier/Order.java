package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Order {
    private final double TAX_PERCENT = 0.1;
    private final double DISCOUNT = 0.98;
    private final String DISCOUNT_DAY = "星期三";
    private Date orderDate;
    private List<LineItem> lineItemList;

    public Order(Date orderDate, List<LineItem> lineItemList) {
        this.orderDate = orderDate;
        this.lineItemList = lineItemList;
    }

    public  String getOrderDate(){
        return new SimpleDateFormat("yyyy年M月dd日, E\n", Locale.CHINA).format(orderDate);
    }
    private  String getDayOfWeek(){
        return new SimpleDateFormat("E\n", Locale.CHINA).format(orderDate);
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
            totalTax += lineItem.totalAmount() * TAX_PERCENT;
        }
        return totalTax;
    }

    public double calcTotalAmount(){
        double totalPrice = .0d;
        for (LineItem lineItem : lineItemList) {
            totalPrice += lineItem.totalAmount();
        }

        return totalPrice + calcTotalTax() - (isDiscountDay() ? calcTotalDiscount() : 0);
    }


    public boolean isDiscountDay() {
        return DISCOUNT_DAY.equals(getDayOfWeek().trim());
    }

    public double calcTotalDiscount() {
        double totalPrice = .0d;
        for (LineItem lineItem : lineItemList) {
            totalPrice += lineItem.totalAmount();
        }
        return (totalPrice + calcTotalTax()) * (1 - DISCOUNT);
    }
}

