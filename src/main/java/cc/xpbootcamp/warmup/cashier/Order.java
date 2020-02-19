package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<Item> items;
    private double taxRate = 0.10;
    private Date createDate;
    private double discountRate;

    public Order(String name, String addr, List<Item> items, Date date) {
        this.customerName = name;
        this.customerAddress = addr;
        this.items = items;
        createDate = date;
        discountRate = DateUtils.isWednesday(createDate) ? 0.98 : 1;
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

    Date getCreateDate() {
        return createDate;
    }

    boolean haveDiscount() {
        return discountRate < 1;
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
        return (getPreTaxAmount() + getTotalTax()) * discountRate;
    }


    double getDiscount() {
        return (getPreTaxAmount() + getTotalTax()) * (1 - discountRate);
    }
}
