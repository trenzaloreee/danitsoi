package accounts;

import java.math.BigDecimal;

public class DebitAccount extends Account {


    @Override
    public void pay(BigDecimal price) {
        if ((getBalance().subtract(price)).intValue() >= 0) {
            setBalance(getBalance().subtract(price));
        } else {
            System.out.println("Недостаточно средств");
        }
    }

    @Override
    public void deposit(BigDecimal depositSum) {
        setBalance(getBalance().add(depositSum));
        System.out.println("Ваш баланс был пополнен на " + depositSum);
        System.out.println("Ваш текущий баланс " + getBalance());
    }

    //    public void pay(BigDecimal price) {
//        setBalance(getBalance().subtract(price));
//
//        //запрет на оплату при отрицательном балансе
//        //переопределение
//        //выложить гитхаб
//    }
}
