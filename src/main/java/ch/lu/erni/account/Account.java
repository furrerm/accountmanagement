package ch.lu.erni.account;

import ch.lu.erni.accountmanagement.AccountTransfer;
import ch.lu.erni.accountmanagement.Transaction;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public interface Account {

    /**
     * get the current stock
     * @Return The current stock
     */
    BigDecimal getCurrentAmount();
    /**
     * set the current stock
     * @Param The new current stock
     */
    void setCurrentAmount(BigDecimal CurrentAmount);

}
