package vendingMachine.states.impl;

import vendingMachine.VendingMachine;
import vendingMachine.states.VendingMachineState;

import static vendingMachine.VendingMachine.INITIAL_MONEY;

public class ChangeState implements VendingMachineState {


    @Override
    public void execute(VendingMachine machine, Object input) {
        if (INITIAL_MONEY.compareTo(machine.getActualAmountMoney()) < 0) {
            System.out.printf("Money back! %1$,.2f euros%n", machine.getActualAmountMoney());
            machine.setActualAmountMoney(0.0);
            machine.setVendingMachineState(new IdleState());
        } else {
            System.out.println("Not Money back");
        }
    }

    @Override
    public void next(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new IdleState());
    }
}
