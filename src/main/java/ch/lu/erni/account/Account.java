package ch.lu.erni.account;

import java.math.BigDecimal;

public interface Account {

    BigDecimal getCurrentAmount();
    void setCurrentAmount(BigDecimal CurrentAmount);
}
