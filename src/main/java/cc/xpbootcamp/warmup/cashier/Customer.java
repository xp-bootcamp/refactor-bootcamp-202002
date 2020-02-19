package cc.xpbootcamp.warmup.cashier;

public class Customer {
    String cName;
    String addr;

    public Customer(String cName, String addr) {
        this.cName = cName;
        this.addr = addr;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }
}
