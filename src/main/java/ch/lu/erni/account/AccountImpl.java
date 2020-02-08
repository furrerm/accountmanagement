package ch.lu.erni.account;

import ch.lu.erni.accountmanagement.AccountTransfer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
