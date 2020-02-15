package cc.xpbootcamp.warmup.cashier;

public class Item {
	private String desc;
	private double price;
	private int quantity;

	public Item(String desc, double price, int quantity) {
		super();
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
	}

	String getDescription() {
		return desc;
	}

	double getPrice() {
		return price;
	}

	int getQuantity() {
		return quantity;
	}

    double amount() {
        return price * quantity;
    }
}
