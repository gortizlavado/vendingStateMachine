package vendingMachine.enums;

import org.junit.jupiter.api.Test;
import vendingMachine.exceptions.NotMoneyAvailableFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MoneyAvailableTest {

    @Test
    void shouldFoundMoneyAvailable() {
        MoneyAvailable oneCent = MoneyAvailable.valueOf(0.01);
        MoneyAvailable twoCent = MoneyAvailable.valueOf(0.02);
        MoneyAvailable fiveCent = MoneyAvailable.valueOf(0.05);
        MoneyAvailable tenCent = MoneyAvailable.valueOf(0.10);
        MoneyAvailable twentyCent = MoneyAvailable.valueOf(0.20);
        MoneyAvailable fiftyCent = MoneyAvailable.valueOf(0.50);
        MoneyAvailable oneEuro = MoneyAvailable.valueOf(1.00);
        MoneyAvailable twoEuro = MoneyAvailable.valueOf(2.00);
        MoneyAvailable fiveEuro = MoneyAvailable.valueOf(5.00);
        MoneyAvailable tenEuro = MoneyAvailable.valueOf(10.00);
        MoneyAvailable twentyEuro = MoneyAvailable.valueOf(20.00);
        assertEquals(oneCent, MoneyAvailable.ONE_CENT);
        assertEquals(twoCent, MoneyAvailable.TWO_CENT);
        assertEquals(fiveCent, MoneyAvailable.FIVE_CENT);
        assertEquals(tenCent, MoneyAvailable.TEN_CENT);
        assertEquals(twentyCent, MoneyAvailable.TWENTY_CENT);
        assertEquals(fiftyCent, MoneyAvailable.FIFTY_CENT);
        assertEquals(oneEuro, MoneyAvailable.ONE_EUR);
        assertEquals(twoEuro, MoneyAvailable.TWO_EUR);
        assertEquals(fiveEuro, MoneyAvailable.FIVE_EUR);
        assertEquals(tenEuro, MoneyAvailable.TEN_EUR);
        assertEquals(twentyEuro, MoneyAvailable.TWENTY_EUR);
    }

    @Test
    void shouldNotFoundAmountAvailable() {
        assertThrows(NotMoneyAvailableFoundException.class, () -> MoneyAvailable.valueOf(0.35));
    }
}