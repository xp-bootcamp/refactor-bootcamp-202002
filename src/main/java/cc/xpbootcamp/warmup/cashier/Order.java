package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<Item> items;
    private double taxRate = 0.10;

    public Order(String cName, String addr, List<Item> items) {
        this.customerName = cName;
        this.customerAddress = addr;
        this.items = items;
    }

    String getCustomerName() {
        return customerName;
    }

    String getCustomerAddress() {
        return customerAddress;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    List<Item> getLineItems() {
        return items;
    }

    private double getPreTaxAmount() {
        double preTaxAmount = 0d;
        for (Item item : items) {
            preTaxAmount += item.amount();
        }
        return preTaxAmount;
    }

    double getTotalTax() {
        return getPreTaxAmount() * taxRate;
    }

    double getTotalAmount() {
        return getPreTaxAmount() + getTotalTax();
    }


}
