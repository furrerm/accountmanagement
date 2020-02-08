package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;
import ch.lu.erni.account.AccountImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class AccountOperationsImplTest {

    private int CONSIDERED_DECIMALS = 2;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void getCurrentStock_when_newly_initialized_Account_then_return_initial_stock() {

        Account account1 = new AccountImpl(new BigDecimal(123.45));
        AccountOperations operations = new AccountOperationsImpl(account1);

        BigDecimal currentAmount = operations.getCurrentStock();
        BigDecimal expectedResult = new BigDecimal(123.45).setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResult, currentAmount);
    }

    @Test
    public void getCurrentStock_when_Account_initialized_and_something_depoited_then_return_the_sum() {

        Account account1 = new AccountImpl(new BigDecimal(123.45));
        AccountOperations operations = new AccountOperationsImpl(account1);

        Transaction transaction = Transaction.createDeposit(new BigDecimal(6.78), account1);
        try {
            operations.deposit(transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal currentAmount = operations.getCurrentStock();
        BigDecimal expectedResult = new BigDecimal(130.23).setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResult, currentAmount);
    }

    @Test
    public void getCurrentStock_when_Account_initialized_and_something_withdrawn_then_return_the_subtraction_of_withdrawn_amount_from_initialStock() {

        Account account1 = new AccountImpl(new BigDecimal(123.45));
        AccountOperations operations = new AccountOperationsImpl(account1);

        Transaction transaction = Transaction.createWithdrawing(new BigDecimal(6.78), account1);
        try {
            operations.withdraw(transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BigDecimal currentAmount = operations.getCurrentStock();
        BigDecimal expectedResult = new BigDecimal(116.67).setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResult, currentAmount);
    }

    @Test
    public void getCurrentStock_when_Two_Accounts_initialized_and_something_transacted_from_A_to_B_then_return_the_sum_on_B_and_the_subtraction_on_A() {

        Account account_A = new AccountImpl(new BigDecimal(123.45));
        Account account_B = new AccountImpl(new BigDecimal(1234.56));
        AccountOperations operations_A = new AccountOperationsImpl(account_A);
        AccountOperations operations_B = new AccountOperationsImpl(account_B);
        Transaction transaction = Transaction.createTransaction(new BigDecimal(23.45), account_A, account_B);

        try {
            operations_A.transact(transaction, account_B);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal currentAmount_A = operations_A.getCurrentStock();
        BigDecimal currentAmount_B = operations_B.getCurrentStock();
        BigDecimal expectedResultAccount_A = new BigDecimal(100.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal expectedResultAccount_B = new BigDecimal(1258.01).setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResultAccount_A, currentAmount_A);
        Assert.assertEquals(expectedResultAccount_B, currentAmount_B);
    }

    @Test(expected = Exception.class)
    public void getCurrentStock_when_Account_initialized_and_same_transaction_two_times_transacted_then_exception() throws Exception {

        Account account1 = new AccountImpl(new BigDecimal(123.45));
        AccountOperations operations = new AccountOperationsImpl(account1);

        Transaction transaction = Transaction.createWithdrawing(new BigDecimal(6.78), account1);

        operations.withdraw(transaction);
        operations.withdraw(transaction);

    }

    @Test(expected = Exception.class)
    public void getCurrentStock_when_Account_initialized_and_something_bigger_then_current_stock_withdrawn_then_exception() throws Exception {

        Account account1 = new AccountImpl(new BigDecimal(123.45));
        AccountOperations operations = new AccountOperationsImpl(account1);

        Transaction transaction = Transaction.createWithdrawing(new BigDecimal(123.46), account1);

        operations.withdraw(transaction);
    }


}