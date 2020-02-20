package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Order {
    private double WEDNESDAY_DISCOUNT_RATE =  0.98;
    private double DEFAULT_DISCOUNT_RATE =  1;
    private String customerName;
    private String customerAddress;
    private List<Item> items;
    private double taxRate = 0.10;
    private Date createDate;
    private double discountRate;

    public Order(String name, String addr, List<Item> items) {
        this.customerName = name;
        this.customerAddress = addr;
        this.items = items;
        createDate = new Date();
        discountRate = DateUtils.isWednesday(createDate) ? WEDNESDAY_DISCOUNT_RATE : DEFAULT_DISCOUNT_RATE;
    }

    public Order(List<Item> items, Date date) {
        this.items = items;
        createDate = date;
        discountRate = DateUtils.isWednesday(createDate) ? WEDNESDAY_DISCOUNT_RATE : DEFAULT_DISCOUNT_RATE;
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
