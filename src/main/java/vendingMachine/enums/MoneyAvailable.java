package vendingMachine.enums;

import vendingMachine.exceptions.NotMoneyAvailableFoundException;

import java.util.Arrays;

public enum MoneyAvailable {

    ONE_CENT(0.01),
    TWO_CENT(0.02),
    FIVE_CENT(0.05),
    TEN_CENT(0.10),
    TWENTY_CENT(0.20),
    FIFTY_CENT(0.50),
    ONE_EUR(1.00),
    TWO_EUR(2.00),
    FIVE_EUR(5.00),
    TEN_EUR(10.00),
    TWENTY_EUR(20.00);

    private double amount;

    MoneyAvailable(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public static MoneyAvailable valueOf(double amount) {
        return Arrays.stream(MoneyAvailable.values())
                .filter(moneyAvailable -> amount == moneyAvailable.getAmount())
                .findFirst()
                .orElseThrow(() -> new NotMoneyAvailableFoundException(
                        String.format("Not found money with this amount: %1$,.2f", amount)));
    }
}
