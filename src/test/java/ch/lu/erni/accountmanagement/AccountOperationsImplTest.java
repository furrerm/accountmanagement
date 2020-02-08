package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;
import ch.lu.erni.account.AccountImpl;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AccountOperationsImplTest {

    @Test
    public void getCurrentStock_when_newly_initialized_Account_then_return_initial_stock() {

        Account account1 = new AccountImpl(new BigDecimal("123.45"));
        AccountOperations operations = AccountOperationsImpl.getInstance();

        BigDecimal currentAmount = operations.getCurrentStockOf(account1);
        BigDecimal expectedResult = new BigDecimal("123.45").setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResult, currentAmount);
    }

    @Test
    public void getCurrentStock_when_Account_initialized_and_something_deposited_then_return_the_sum() {

        Account account1 = new AccountImpl(new BigDecimal("123.45"));
        AccountOperations operations = AccountOperationsImpl.getInstance();

        Transaction deposit = new Deposit(new BigDecimal("6.78"), account1);

        try {
            operations.transact(deposit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal currentAmount = operations.getCurrentStockOf(account1);
        BigDecimal expectedResult = new BigDecimal("130.23").setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResult, currentAmount);
    }

    @Test
    public void getCurrentStock_when_Account_initialized_and_something_withdrawn_then_return_the_subtraction_of_withdrawn_amount_from_initialStock() {

        Account account1 = new AccountImpl(new BigDecimal("123.45"));
        AccountOperations operations = AccountOperationsImpl.getInstance();

        Transaction withdrawing = new Withdraw(new BigDecimal("6.78"), account1);

        try {
            operations.transact(withdrawing);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BigDecimal currentAmount = operations.getCurrentStockOf(account1);
        BigDecimal expectedResult = new BigDecimal("116.67").setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResult, currentAmount);
    }

    @Test
    public void getCurrentStock_when_Two_Accounts_initialized_and_something_transacted_from_A_to_B_then_return_the_sum_on_B_and_the_subtraction_on_A() {

        Account account_A = new AccountImpl(new BigDecimal("123.45"));
        Account account_B = new AccountImpl(new BigDecimal("1234.56"));

        AccountOperations operations = AccountOperationsImpl.getInstance();

        Transaction accountTransfer = new AccountTransfer(new BigDecimal("23.45"), account_A, account_B);

        try {
            operations.transact(accountTransfer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal currentAmount_A = operations.getCurrentStockOf(account_A);
        BigDecimal currentAmount_B = operations.getCurrentStockOf(account_B);

        BigDecimal expectedResultAccount_A = new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP);
        BigDecimal expectedResultAccount_B = new BigDecimal("1258.01").setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResultAccount_A, currentAmount_A);
        Assert.assertEquals(expectedResultAccount_B, currentAmount_B);
    }

    @Test(expected = Exception.class)
    public void getCurrentStock_when_Account_initialized_and_same_transaction_two_times_transacted_then_exception() throws Exception {

        Account account1 = new AccountImpl(new BigDecimal("123.45"));
        AccountOperations operations = AccountOperationsImpl.getInstance();

        Transaction withdrawing = new Withdraw(new BigDecimal("6.78"), account1);

        operations.transact(withdrawing);
        operations.transact(withdrawing);
    }

    @Test(expected = Exception.class)
    public void getCurrentStock_when_Account_initialized_and_something_bigger_then_current_stock_withdrawn_then_exception() throws Exception {

        Account account1 = new AccountImpl(new BigDecimal("123.45"));
        AccountOperations operations = AccountOperationsImpl.getInstance();

        Transaction withdrawing = new Withdraw(new BigDecimal("123.46"), account1);

        operations.transact(withdrawing);
    }


}