package vendingMachine.states.impl;

import vendingMachine.VendingMachine;
import vendingMachine.enums.MoneyAvailable;
import vendingMachine.states.VendingMachineState;

import java.util.Objects;

public class InsertMoneyState implements VendingMachineState {

    @Override
    public void execute(VendingMachine machine, Object input) {
        final MoneyAvailable money = (MoneyAvailable) input;
        if (!Objects.isNull(money)) {
            final double moneyToSum = money.getAmount();
            System.out.printf("Insert %1$,.2f euros%n", moneyToSum);
            machine.setActualAmountMoney(Double.sum(machine.getActualAmountMoney(), moneyToSum));
        }
        final double currentMoney = machine.getActualAmountMoney();
        System.out.printf("Vending Machine has %1$,.2f euros%n", currentMoney);
        machine.setVendingMachineState(new IdleState());
    }

    @Override
    public void next(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new BuyState());
    }
}
