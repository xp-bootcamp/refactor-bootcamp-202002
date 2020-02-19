package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtils;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private static String HEADER = "===== 老王超市，值得信赖 ======" + '\n' + '\n';
    private static String DIVIDER = "-----------------------------------" + '\n';


    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return HEADER +
                formatOrderCreateDate() +
                initOrderItemsInfo() +
                DIVIDER +
                initOrderSummarise();
    }

    private String formatOrderCreateDate() {
        return DateUtils.format(order.getCreateDate()) + '\n';
    }

    private String initOrderItemsInfo() {
        StringBuilder baseInfo = new StringBuilder();
        for (Item lineItem : order.getLineItems()) {
            String itemInfo = lineItem.getDescription() + ", "
                    + formatDouble(lineItem.getPrice()) + " x "
                    + lineItem.getQuantity() + ", "
                    + formatDouble(lineItem.amount()) + '\n';
            baseInfo.append(itemInfo);
        }
        return baseInfo.toString();
    }

    private String initOrderSummarise() {
        return "税额:   " + formatDouble(order.getTotalTax()) + '\n' +
                initDiscountInfo()
                + "总价:   " + formatDouble(order.getTotalAmount()) + '\n';
    }

    private String initDiscountInfo() {
        if (order.haveDiscount()) {
            return "折扣:   " + formatDouble(order.getDiscount()) + '\n';
        }
        return "";
    }

    private String formatDouble(double d) {
        return String.format("%.2f", d);
    }

}
