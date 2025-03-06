package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeAccountTest extends BankAccountTest{
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int WITHDRAWN_AMOUNT = 200;
    private static final int WITHDRAWN_BRONZE_AMOUNT = 50;
    private static final int EXPECTED_BRONZE_AMOUNT = 950;
    private static final int EXPECTED_BRONZE_AMOUNT_WITH_FEE = 799;
    private static final int WITHDRAWN_BRONZE_AMOUNT_EXCEDEED = 1001;
    @Override
    public BankAccount CoreBankAccount() {
        return new BronzeBankAccount(new CoreBankAccount());
    }
    @Test
    public void testBronzeAccountWithdrawNoFee() {
        coreAccount.deposit(DEPOSIT_AMOUNT);
        coreAccount.withdraw(WITHDRAWN_BRONZE_AMOUNT);
        assertEquals(EXPECTED_BRONZE_AMOUNT, coreAccount.getBalance());
    }
    @Test
    public void testBronzeAccountWithdrawWithFee() {
        coreAccount.deposit(DEPOSIT_AMOUNT);
        coreAccount.withdraw(WITHDRAWN_AMOUNT);
        assertEquals(EXPECTED_BRONZE_AMOUNT_WITH_FEE, coreAccount.getBalance());
    }
    @Test
    public void testBronzeAccountCannotWithdrawMoreThanAvailable() {
        coreAccount.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> coreAccount.withdraw(WITHDRAWN_BRONZE_AMOUNT_EXCEDEED));
    }
}
