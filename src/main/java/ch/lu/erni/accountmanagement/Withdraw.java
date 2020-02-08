package ch.lu.erni.accountmanagement;


import ch.lu.erni.account.Account;

import java.math.BigDecimal;

public class Withdraw extends Transaction{

    BigDecimal amount;
    Account initiatingAccount;

    public Withdraw(BigDecimal amount, Account initiatingAccount) {
        this.amount = amount;
        this.initiatingAccount = initiatingAccount;
    }

    @Override
    public boolean execute() throws Exception{

        BigDecimal currentAmount = initiatingAccount.getCurrentAmount();
        BigDecimal newCurrentAmount = currentAmount.subtract(this.amount);

        if(newCurrentAmount.compareTo(new BigDecimal(0)) < 0){
            throw new Exception("Minus Values are not allowed");
        }
        initiatingAccount.setCurrentAmount(newCurrentAmount);
        return true;
    }
}
