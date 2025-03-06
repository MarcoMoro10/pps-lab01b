package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldAccountTest extends BankAccountTest{
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int WITHDRAWN_AMOUNT = 200;
    private static final int DEPOSIT_GOLD_AMOUNT = 100;
    private static final int WITHDRAWN_GOLD_AMOUNT = 1200;
    private static final int EXPECTED_GOLD_AMOUNT = 800;

    @Override
    public BankAccount CoreBankAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }
    @Test
    public void testGoldAccountWithdraw() {
        coreAccount.deposit(DEPOSIT_AMOUNT);
        coreAccount.withdraw(WITHDRAWN_AMOUNT);
        assertEquals(EXPECTED_GOLD_AMOUNT, coreAccount.getBalance());
    }
    @Test
    public void testGoldAccountCannotExceedOverdraftLimit() {
        coreAccount.deposit(DEPOSIT_GOLD_AMOUNT);
        assertThrows(IllegalStateException.class, () -> coreAccount.withdraw(WITHDRAWN_GOLD_AMOUNT));
    }
}
