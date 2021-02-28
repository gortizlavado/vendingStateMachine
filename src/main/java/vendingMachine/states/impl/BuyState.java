package vendingMachine.states.impl;

import vendingMachine.VendingMachine;
import vendingMachine.models.Item;
import vendingMachine.states.VendingMachineState;

import java.util.logging.Logger;

public class BuyState implements VendingMachineState {

    static Logger log = Logger.getLogger(BuyState.class.getName());

    @Override
    public void execute(VendingMachine machine, Object input) {
        final Item itemToBuy = (Item) input;
        System.out.println("Trying to buy...");
        System.out.printf("One item of %s%n", itemToBuy.getDescription());
        System.out.printf("With a cost %1$,.2f%n", itemToBuy.getPrice());
        if (itemToBuy.getAmount() <= 0) {
            System.out.println("Not stock");
            returnInitialState(machine);
        } else {
            if(checkEnoughMoney(machine, itemToBuy)) {
                decreaseNumberOfItem(1, itemToBuy, machine);
                decreaseMoneyAmount(machine, itemToBuy);
                System.out.println("Buy successfully!");
            } else {
                System.out.printf("Not enough Money! You have insert at least %1$,.2f money%n",
                        calculateDiffMoney(machine, itemToBuy));
                returnInitialState(machine);
            }
        }
    }

    private void decreaseNumberOfItem(int amountToDecrease, Item item, VendingMachine machine) {
        int currentAmount = getCurrentAmount(item, machine);
        System.out.printf("Before -- Numbers of items: %d%n", currentAmount);
        int amount = currentAmount - amountToDecrease;
        machine.getItemList().stream()
                .filter(i -> i.equals(item))
                .findFirst()
                .orElseThrow()
                .setAmount(amount);
        System.out.printf("After -- Numbers of items: %d%n", getCurrentAmount(item, machine));
    }

    private void decreaseMoneyAmount(VendingMachine machine, Item itemToBuy) {
        final double actualAmountMoney = machine.getActualAmountMoney();
        System.out.printf("Before -- Money in machine: %1$,.2f%n", actualAmountMoney);
        final double price = itemToBuy.getPrice();
        machine.setActualAmountMoney(actualAmountMoney - price);
        System.out.printf("Before -- Money in machine: %1$,.2f%n", machine.getActualAmountMoney());
    }

    private int getCurrentAmount(Item item, VendingMachine machine) {
        return machine.getItemList().stream()
                .filter(i -> i.equals(item))
                .findFirst()
                .orElseThrow()
                .getAmount();
    }

    private double calculateDiffMoney(VendingMachine machine, Item itemToBuy) {
        return itemToBuy.getPrice() - machine.getActualAmountMoney();
    }

    private void returnInitialState(VendingMachine machine) {
        machine.setVendingMachineState(new IdleState());
    }

    private boolean checkEnoughMoney(VendingMachine machine, Item itemToBuy) {
        return machine.getActualAmountMoney() >= itemToBuy.getPrice();
    }

    @Override
    public void next(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new ChangeState());
    }
}
