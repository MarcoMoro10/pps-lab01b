package e1;

public abstract class SilverBankAccount extends BankAccountDecorator {

    public SilverBankAccount(BankAccount decoratedBankAccount) {
        super(decoratedBankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException("Insufficient funds");
        }
        decoratedBankAccount.withdraw(amount+1);
    }
}
