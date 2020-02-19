package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtils;

import java.util.Date;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private static String HEADER = "===== 老王超市，值得信赖 ======" + '\n' + '\n';


    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return HEADER +
                formatOrderCreateDate() +
                initOrderBaseInfo() +
                initOrderItemsInfo() +
                initOrderSummarise();

    }

    private String formatOrderCreateDate() {
        return DateUtils.format(order.getCreateDate());
    }

    private String initOrderBaseInfo() {
        return order.getCustomerName() + order.getCustomerAddress();
    }

    private String initOrderItemsInfo() {
        String baseInfo = "";
        for (Item lineItem : order.getLineItems()) {
            String itemInfo = lineItem.getDescription() + '\t'
                    + lineItem.getPrice() + '\t'
                    + lineItem.getQuantity() + '\t'
                    + lineItem.amount() + '\n';
            baseInfo += itemInfo;
        }
        return baseInfo;
    }

    private String initOrderSummarise() {
        return "Sales Tax" + '\t' + order.getTotalTax()
                + "Total Amount" + '\t' + order.getTotalAmount();

    }

}
