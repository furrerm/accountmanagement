package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.UUID;

public class AccountOperationsImpl implements AccountOperations {

    private Account account;
    private int CONSIDERED_DECIMALS = 2;

    public AccountOperationsImpl(Account account) {

        this.account = account;
    }


    @Override
    public synchronized void deposit(Transaction transaction) throws Exception{
        this.saveTransaction(transaction);

        BigDecimal currentAmount = account.getCurrentAmount();
        BigDecimal newCurrentAmount = currentAmount.add(transaction.getAmount());

        if(newCurrentAmount.compareTo(new BigDecimal(0)) < 0){
            throw new Exception("Minus Values are not allowed");
        }

        account.setCurrentAmount(newCurrentAmount);
    }

    @Override
    public synchronized void withdraw(Transaction transaction) throws Exception{

        this.saveTransaction(transaction);

        BigDecimal currentAmount = account.getCurrentAmount();
        BigDecimal newCurrentAmount = currentAmount.subtract(transaction.getAmount());

        if(newCurrentAmount.compareTo(new BigDecimal(0)) < 0){
            throw new Exception("Minus Values are not allowed");
        }

        account.setCurrentAmount(newCurrentAmount);
    }

    @Override
    public synchronized void transact(Transaction transaction, Account goalAccount) throws Exception{

        this.withdraw(transaction);
        new AccountOperationsImpl(goalAccount).deposit(transaction);
    }

    @Override
    public BigDecimal getCurrentStock() {


        return account.getCurrentAmount().setScale(CONSIDERED_DECIMALS, RoundingMode.HALF_UP);
    }


    private void saveTransaction(Transaction transaction) throws Exception{
        Map<UUID, Transaction> transactions = account.getTransactions();

        if(!transactions.containsKey(transaction.getTransactionId())){
            account.getTransactions().put(transaction.getTransactionId(),transaction);
        } else {
            throw new Exception("Transaction already transacted. (Separate Exception should be written)");
        }


    }


}
