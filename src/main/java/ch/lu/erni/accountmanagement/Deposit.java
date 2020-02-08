package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;


import java.math.BigDecimal;



public class Deposit extends Transaction{

    BigDecimal amount;
    Account goalAccount;


    public Deposit(BigDecimal amount, Account goalAccount) {
        this.amount = amount;
        this.goalAccount = goalAccount;
    }

    @Override
    public boolean execute() throws Exception{

        BigDecimal currentAmount = goalAccount.getCurrentAmount();
        BigDecimal newCurrentAmount = currentAmount.add(this.amount);

        if(newCurrentAmount.compareTo(new BigDecimal(0)) < 0){
            throw new Exception("Minus Values are not allowed");
        }
        goalAccount.setCurrentAmount(newCurrentAmount);
        return true;
    }
}
