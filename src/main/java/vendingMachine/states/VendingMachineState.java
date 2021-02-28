package vendingMachine.states;

import vendingMachine.VendingMachine;

public interface VendingMachineState {

    void execute(VendingMachine machine, Object input);

    void next(VendingMachine vendingMachine);
}
