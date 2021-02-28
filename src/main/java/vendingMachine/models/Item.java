package vendingMachine.models;

import java.util.Objects;

public class Item {

    private final String description;
    private int amount;
    private final double price;

    public Item(ItemBuilder itemBuilder) {
        this.description = itemBuilder.description;
        this.amount = itemBuilder.amount;
        this.price = itemBuilder.price;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, amount, price);
    }

    public static class ItemBuilder {

        private String description;
        private int amount;
        private double price;

        public ItemBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ItemBuilder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public ItemBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

}
