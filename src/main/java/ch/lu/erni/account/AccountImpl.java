package ch.lu.erni.account;

import java.math.BigDecimal;

public class AccountImpl implements Account{

    private BigDecimal currentAmount;

    public AccountImpl(BigDecimal initialAmount){
        this.currentAmount = initialAmount;
    }

    @Override
    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    @Override
    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

}
