package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;

import java.math.BigDecimal;

public class AccountOperationsImpl implements AccountOperations{

    private Account account;

    public AccountOperationsImpl(Account account) {

        this.account = account;
    }


    @Override
    public void deposit(BigDecimal amount) {

    }

    @Override
    public void withdraw(BigDecimal amount) {

    }

    @Override
    public void transact(BigDecimal amount, Account goalAccount) {

    }

    @Override
    public BigDecimal getCurrentStock() {
        return null;
    }
}
