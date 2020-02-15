package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private static String HEADER = "======Printing Orders======" + '\n';
    private String baseInfo;
    private String orderItemsInfo;
    private String orderSummarise;


    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {

        initOrderBaseInfo();
        initOrderItemsInfo();
        initOrderSummarise();

        return HEADER + baseInfo + orderItemsInfo + orderSummarise;
    }

    private void initOrderBaseInfo() {
        baseInfo = order.getCustomerName() + order.getCustomerAddress();
    }

    private void initOrderItemsInfo() {
        for (Item lineItem : order.getLineItems()) {
            String itemInfo = lineItem.getDescription() + '\t'
                    + lineItem.getPrice() + '\t'
                    + lineItem.getQuantity() + '\t'
                    + lineItem.amount() + '\n';
            baseInfo += itemInfo;
        }
    }

    private void initOrderSummarise() {
        orderSummarise = "Sales Tax" + '\t' + order.getTotalTax()
                + "Total Amount" + '\t' + order.getTotalAmount();
    }

    public String printReceiptOlder() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (Item lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.amount());
            output.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.amount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.amount() + salesTax;
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
        output.append("Total Amount").append('\t').append(tot);
        return output.toString();
    }

}
