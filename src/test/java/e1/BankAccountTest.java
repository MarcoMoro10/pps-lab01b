package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class BankAccountTest {
    protected BankAccount coreAccount;
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int EXPECTED_AMOUNT = 1000;
    @BeforeEach
    void init(){
        coreAccount = CoreBankAccount();
    }
    protected abstract BankAccount CoreBankAccount();
    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, coreAccount.getBalance());
    }
    @Test
    public void testCanDeposit() {
        coreAccount.deposit(DEPOSIT_AMOUNT);
        assertEquals(EXPECTED_AMOUNT, coreAccount.getBalance());
    }
}
