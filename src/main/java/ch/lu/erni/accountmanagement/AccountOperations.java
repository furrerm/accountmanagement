package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;

import java.math.BigDecimal;

public interface AccountOperations {

    /**
     * get the current stock
     * @Return The current stock
     */
    BigDecimal getCurrentStockOf(Account account);

    /**
     * @param transaction: The Transaction to be executed.
     * @return True if transaction was successfully.
     */
    boolean transact(Transaction transaction) throws Exception;
}
