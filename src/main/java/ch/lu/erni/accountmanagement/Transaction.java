package ch.lu.erni.accountmanagement;

import lombok.Getter;

import java.util.UUID;

public abstract class Transaction {

    @Getter
    private UUID transactionId;

    public Transaction (){
        this.transactionId = UUID.randomUUID();
    }

    /**
     *
     * @return true if transaction was successfully executed.
     */
    abstract boolean execute() throws Exception;


}
