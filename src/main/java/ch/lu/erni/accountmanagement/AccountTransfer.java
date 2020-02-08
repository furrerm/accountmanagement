package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AccountTransfer extends Transaction{

    private Account initiatingAccount;
    private Account goalAccount;
    private BigDecimal amount;


    public AccountTransfer(BigDecimal amount, Account initiatingAccount, Account goalAccount) {
        this.initiatingAccount = initiatingAccount;
        this.goalAccount = goalAccount;
        this.amount = amount;
    }

    @Override
    public boolean execute() throws Exception{

        new Deposit(amount, goalAccount).execute();
        new Withdraw(amount, initiatingAccount).execute();

        return true;
    }
}
