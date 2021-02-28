package vendingMachine.states.impl;

import vendingMachine.VendingMachine;
import vendingMachine.states.VendingMachineState;

public class IdleState implements VendingMachineState {

    @Override
    public void execute(VendingMachine machine, Object input) {
        System.out.println("Vending machine is waiting...");
    }

    @Override
    public void next(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new InsertMoneyState());
    }
}
