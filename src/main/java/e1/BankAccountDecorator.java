package e1;

public abstract class BankAccountDecorator implements BankAccount{
    protected BankAccount decoratedBankAccount;
    public BankAccountDecorator(BankAccount decoratedBankAccount) {
        this.decoratedBankAccount = decoratedBankAccount;
    }

    @Override
    public void deposit(int amount) {
        this.decoratedBankAccount.deposit(amount);
    }

    @Override
    public int getBalance() {
        return this.decoratedBankAccount.getBalance();
    }
}
