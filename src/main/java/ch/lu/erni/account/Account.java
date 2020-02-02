package ch.lu.erni.account;

import ch.lu.erni.accountmanagement.Transaction;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public interface Account {

    BigDecimal getCurrentAmount();
    void setCurrentAmount(BigDecimal CurrentAmount);
    Map<UUID, Transaction> getTransactions();
}
