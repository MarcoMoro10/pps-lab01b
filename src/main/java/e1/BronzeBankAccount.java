package e1;

public class BronzeBankAccount extends BankAccountDecorator{
    public BronzeBankAccount(BankAccount decoratedBankAccount) {
        super(decoratedBankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if(getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds");
        }
        else{
            if(amount < 100){
                decoratedBankAccount.withdraw(amount);
            }else{
                decoratedBankAccount.withdraw(amount+1);
            }
        }
    }
}
