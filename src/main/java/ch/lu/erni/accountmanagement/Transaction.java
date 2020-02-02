package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Transaction {

    private Account initiatingAccount;
    private Account goalAccount;
    private BigDecimal amount;
    private UUID transactionId;

    private Transaction(BigDecimal amount, Account initiatingAccount, Account goalAccount) {
        this.goalAccount = goalAccount;
        this.amount = amount;
        this.transactionId = UUID.randomUUID();
    }

    public static Transaction createDeposit(BigDecimal amount, Account initiatingAccount){
        return new Transaction(amount, initiatingAccount, initiatingAccount);
    }

    public static Transaction createWithdrawing(BigDecimal amount, Account initiatingAccount){
        return new Transaction(amount, initiatingAccount, initiatingAccount);
    }

    public static Transaction createTransaction(BigDecimal amount, Account initiatingAccount, Account goalAccount){
        return new Transaction(amount, initiatingAccount, goalAccount);
    }
}
