package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AccountOperationsImpl implements AccountOperations{

    private Account account;
    private int CONSIDERED_DECIMALS = 2;

    public AccountOperationsImpl(Account account) {

        this.account = account;
    }


    @Override
    public void deposit(BigDecimal amount) {
        BigDecimal currentAmount = account.getCurrentAmount();
        BigDecimal newCurrentAmount = currentAmount.add(amount);

        account.setCurrentAmount(newCurrentAmount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        BigDecimal currentAmount = account.getCurrentAmount();
        BigDecimal newCurrentAmount = currentAmount.subtract(amount);

        account.setCurrentAmount(newCurrentAmount);
    }

    @Override
    public void transact(BigDecimal amount, Account goalAccount) {

    }

    @Override
    public BigDecimal getCurrentStock() {


        return account.getCurrentAmount().setScale( CONSIDERED_DECIMALS, RoundingMode.HALF_UP);
    }
}
