package vendingMachine;

import vendingMachine.enums.MoneyAvailable;
import vendingMachine.models.Item;
import vendingMachine.states.VendingMachineState;
import vendingMachine.states.impl.IdleState;
import vendingMachine.states.impl.InsertMoneyState;

import java.util.List;

public class VendingMachine {

    public static final Double INITIAL_MONEY = 0.0;

    private double actualAmountMoney;

    private final List<Item> itemList;

    private VendingMachineState vendingMachineState;

    public VendingMachine() {
        this.actualAmountMoney = INITIAL_MONEY;
        this.itemList = loadItems();
        this.vendingMachineState = new IdleState();
    }

    public double getActualAmountMoney() {
        return actualAmountMoney;
    }

    public void setActualAmountMoney(double actualAmountMoney) {
        this.actualAmountMoney = actualAmountMoney;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public void insert(MoneyAvailable moneyAvailable) {
        vendingMachineState.next(this);
        vendingMachineState.execute(this, moneyAvailable);
    }

    public void chooseProduct(Item item) {
        this.setVendingMachineState(new InsertMoneyState());

        vendingMachineState.next(this);
        vendingMachineState.execute(this, item);

        vendingMachineState.next(this);
        vendingMachineState.execute(this, item);
    }

    private List<Item> loadItems() {
        return List.of(
                new Item.ItemBuilder()
                    .description("choco")
                    .amount(10)
                    .price(2.5).build(),
                new Item.ItemBuilder()
                    .description("coke")
                    .amount(8)
                    .price(2.0).build()
        );
    }

}
