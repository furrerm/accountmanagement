package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;

import java.math.BigDecimal;

public interface AccountOperations {

    /**
     * Is used to pay in money
     * @Param The amount which is paied in
     */
    void deposit(BigDecimal amount);


    void withdraw(BigDecimal amount);


    void transact(BigDecimal amount, Account goalAccount);

    BigDecimal getCurrentStock();
}
