package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class AccountOperationsImpl implements AccountOperations {

    private int CONSIDERED_DECIMALS = 2;

    private Map<UUID, Transaction> transactions = new HashMap<>();

    public static AccountOperationsImpl accountOperations;

    private AccountOperationsImpl() {
    }

    public static AccountOperationsImpl getInstance(){
        return Objects.requireNonNullElseGet(accountOperations, AccountOperationsImpl::new);
    }

    synchronized public boolean transact(Transaction transaction) throws Exception{
        this.saveTransaction(transaction);
        return transaction.execute();
    }

    @Override
    public BigDecimal getCurrentStockOf(Account account) {

        return account.getCurrentAmount().setScale(CONSIDERED_DECIMALS, RoundingMode.HALF_UP);
    }

    private void saveTransaction(Transaction transaction) throws Exception{


        if(!transactions.containsKey(transaction.getTransactionId())){
            transactions.put(transaction.getTransactionId(),transaction);
        } else {
            throw new Exception("Transaction already executed. (Separate Exception should be written)");
        }
    }


}
