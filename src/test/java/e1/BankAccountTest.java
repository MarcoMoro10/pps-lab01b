package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount coreAccount;
    private BankAccount silverAccount;
    private BankAccount goldAccount;
    private BankAccount bronzeAccount;
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int EXPECTED_AMOUNT = 1000;
    private static final int WITHDRAWN_AMOUNT = 200;
    private static final int EXPECTED_SILVER_AMOUNT = 799;




    @BeforeEach
    void init(){
        this.coreAccount = new CoreBankAccount();
        this.silverAccount = new SilverBankAccount(new CoreBankAccount());
        this.goldAccount = new GoldBankAccount(new CoreBankAccount());
        this.bronzeAccount = new BronzeBankAccount(new CoreBankAccount());
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.coreAccount.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.coreAccount.deposit(DEPOSIT_AMOUNT);
        assertEquals(EXPECTED_AMOUNT, this.coreAccount.getBalance());
    }

   @Test
    public void testSilverAccountWithdraw() {
        this.silverAccount.deposit(DEPOSIT_AMOUNT);
        this.silverAccount.withdraw(WITHDRAWN_AMOUNT);
        assertEquals(EXPECTED_SILVER_AMOUNT, this.silverAccount.getBalance());
    }

   /* @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }*/

}
