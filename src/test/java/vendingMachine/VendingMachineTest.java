package vendingMachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendingMachine.enums.MoneyAvailable;
import vendingMachine.models.Item;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    void shouldHaveMoneyInMachine_whenInsertMoney() {
        vendingMachine.insert(MoneyAvailable.TWENTY_EUR);
        assertEquals(MoneyAvailable.TWENTY_EUR.getAmount(), vendingMachine.getActualAmountMoney());
        vendingMachine.insert(MoneyAvailable.ONE_EUR);
        assertEquals(21.0, vendingMachine.getActualAmountMoney());
    }

    @Test
    void shouldNotHaveMoneyInMachine_whenBuyItemWithExactMoney() {
        vendingMachine.setActualAmountMoney(2.0);
        Item item = new Item.ItemBuilder()
                .description("coke")
                .amount(1)
                .price(2.0)
                .build();
        int initialNumberOfThisItem = getCurrentAmount(item, vendingMachine);

        vendingMachine.chooseProduct(item);
        assertEquals(0.0, vendingMachine.getActualAmountMoney());
        assertEquals(initialNumberOfThisItem - 1, getCurrentAmount(item, vendingMachine));
    }

    private int getCurrentAmount(Item item, VendingMachine machine) {
        return machine.getItemList().stream()
                .filter(i -> i.equals(item))
                .findFirst()
                .orElseThrow()
                .getAmount();
    }

}