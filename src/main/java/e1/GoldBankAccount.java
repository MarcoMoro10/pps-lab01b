package e1;

public class GoldBankAccount extends BankAccountDecorator{
    public GoldBankAccount(BankAccount decoratedBankAccount) {
        super(decoratedBankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if(getBalance() - amount < -500){
            throw new IllegalStateException("OverDraft limit exceeded");
        }
        decoratedBankAccount.withdraw(amount);
    }
}
