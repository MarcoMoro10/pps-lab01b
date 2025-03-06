package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverAccountTest extends BankAccountTest{
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int WITHDRAWN_AMOUNT = 200;
    private static final int WITHDRAWN_SILVER_AMOUNT = 1200;
    private static final int EXPECTED_SILVER_AMOUNT = 799;

    @Override
    public BankAccount CoreBankAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }
    @Test
    public void testSilverAccountWithdraw() {
        coreAccount.deposit(DEPOSIT_AMOUNT);
        coreAccount.withdraw(WITHDRAWN_AMOUNT);
        assertEquals(EXPECTED_SILVER_AMOUNT, coreAccount.getBalance());
    }
    @Test
    public void testSilverAccountCannotWithdrawMoreThanAvailable() {
        coreAccount.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> coreAccount.withdraw(WITHDRAWN_SILVER_AMOUNT));
    }
}
