package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;

import java.math.BigDecimal;

public interface AccountOperations {

    /**
     * Is used to pay in money
     * @Param The Transaction that has to be paid in
     */
    void deposit(Transaction transaction) throws Exception;

    /**
     * Is used to withdraw money
     * @Param The Transaction that has to be withdrawn
     */
    void withdraw(Transaction transaction) throws Exception;

    /**
     * Is used to transact money from one to another account
     * @Param The Transaction that has to be made
     */
    void transact(Transaction transaction, Account goalAccount) throws Exception;

    /**
     * get the current stock
     * @Return The current stock
     */
    BigDecimal getCurrentStock();
}
