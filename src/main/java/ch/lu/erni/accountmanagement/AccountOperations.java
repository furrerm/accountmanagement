package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;

import java.math.BigDecimal;

public interface AccountOperations {

    /**
     * Is used to pay in money
     * @Param The amount which is paid in
     */
    void deposit(Transaction transaction) throws Exception;


    void withdraw(Transaction transaction) throws Exception;


    void transact(Transaction transaction, Account goalAccount) throws Exception;

    BigDecimal getCurrentStock();
}
