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
    private static char LINE_BREAK = '\n';
    private static String HEADER = "===== 老王超市，值得信赖 ======" + LINE_BREAK + LINE_BREAK;
    private static String DIVIDER = "-----------------------------------" + LINE_BREAK;
    private static String TAX_TITLE = "税额:   ";
    private static String DISCOUNT_TITLE = "折扣:   ";
    private static String AMOUNT_TITLE = "总价:   ";
    private static String EMPTY_STRING = "";
    private static String COMMA = ", ";
    private static String MULTIPLE_SIGN = " x ";


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
        return DateUtils.format(order.getCreateDate()) + LINE_BREAK;
    }

    private String initOrderItemsInfo() {
        StringBuilder baseInfo = new StringBuilder();
        for (Item lineItem : order.getLineItems()) {
            String itemInfo = lineItem.getDescription() + COMMA
                    + formatDouble(lineItem.getPrice()) + MULTIPLE_SIGN
                    + lineItem.getQuantity() + COMMA
                    + formatDouble(lineItem.amount()) + LINE_BREAK;
            baseInfo.append(itemInfo);
        }
        return baseInfo.toString();
    }

    private String initOrderSummarise() {


        return TAX_TITLE + formatDouble(order.getTotalTax()) + LINE_BREAK +
                initDiscountInfo()
                + AMOUNT_TITLE + formatDouble(order.getTotalAmount()) + LINE_BREAK;
    }

    private String initDiscountInfo() {
        if (order.haveDiscount()) {
            return DISCOUNT_TITLE + formatDouble(order.getDiscount()) + LINE_BREAK;
        }
        return EMPTY_STRING;
    }

    private String formatDouble(double d) {
        return String.format("%.2f", d);
    }

}
