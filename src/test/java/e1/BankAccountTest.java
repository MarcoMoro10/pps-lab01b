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
    private static final int DEPOSIT_GOLD_AMOUNT = 100;
    private static final int EXPECTED_AMOUNT = 1000;
    private static final int WITHDRAWN_AMOUNT = 200;
    private static final int WITHDRAWN_SILVER_AMOUNT = 1200;
    private static final int WITHDRAWN_GOLD_AMOUNT = 1200;
    private static final int WITHDRAWN_BRONZE_AMOUNT = 50;
    private static final int EXPECTED_SILVER_AMOUNT = 799;
    private static final int EXPECTED_GOLD_AMOUNT = 800;
    private static final int EXPECTED_BRONZE_AMOUNT = 950;
    private static final int EXPECTED_BRONZE_AMOUNT_WITH_FEE = 799;
    private static final int WITHDRAWN_BRONZE_AMOUNT_EXCEDEED = 1001;





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
    @Test
    public void testSilverAccountCannotWithdrawMoreThanAvailable() {
        this.silverAccount.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.silverAccount.withdraw(WITHDRAWN_SILVER_AMOUNT));
    }
    @Test
    public void testGoldAccountWithdraw() {
        this.goldAccount.deposit(DEPOSIT_AMOUNT);
        this.goldAccount.withdraw(WITHDRAWN_AMOUNT);
        assertEquals(EXPECTED_GOLD_AMOUNT, this.goldAccount.getBalance());
    }
    @Test
    public void testGoldAccountCannotExceedOverdraftLimit() {
        this.goldAccount.deposit(DEPOSIT_GOLD_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.goldAccount.withdraw(WITHDRAWN_GOLD_AMOUNT));
    }
    @Test
    public void testBronzeAccountWithdrawNoFee() {
        this.bronzeAccount.deposit(DEPOSIT_AMOUNT);
        this.bronzeAccount.withdraw(WITHDRAWN_BRONZE_AMOUNT);
        assertEquals(EXPECTED_BRONZE_AMOUNT, this.bronzeAccount.getBalance());
    }
    @Test
    public void testBronzeAccountWithdrawWithFee() {
        this.bronzeAccount.deposit(DEPOSIT_AMOUNT);
        this.bronzeAccount.withdraw(WITHDRAWN_AMOUNT);
        assertEquals(EXPECTED_BRONZE_AMOUNT_WITH_FEE, this.bronzeAccount.getBalance());
    }

    @Test
    public void testBronzeAccountCannotWithdrawMoreThanAvailable() {
        this.bronzeAccount.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.bronzeAccount.withdraw(WITHDRAWN_BRONZE_AMOUNT_EXCEDEED));
    }


}
