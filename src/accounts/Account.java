package accounts;

import java.math.BigDecimal;

public abstract class Account {
    private static int numberOfAccounts;

    private BigDecimal balance;

    private int accountNumber;
    private AccountHolder holder;

    public abstract void pay(BigDecimal price);

    public abstract void deposit(BigDecimal depositSum);

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
