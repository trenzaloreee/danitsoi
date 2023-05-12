package accounts;

import java.math.BigDecimal;

public class CreditAccount extends Account {

    private int interest;
    private BigDecimal creditLimit;


    @Override
    public void pay(BigDecimal price) {
        setBalance(getBalance().subtract(price));
    }

    @Override
    public void deposit(BigDecimal depositSum) {
        setBalance(getBalance().add(depositSum));
        System.out.println("Ваш баланс был пополнен на " + depositSum);
        System.out.println("Ваш текущий баланс " + getBalance());
    }
}
