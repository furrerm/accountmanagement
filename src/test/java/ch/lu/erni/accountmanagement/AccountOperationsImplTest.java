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
    public void getCurrentStock_when_newly_initialized_Account_then_return_initial_stock () {

        Account account1 = new AccountImpl(new BigDecimal(123.45));
        AccountOperations operations = new AccountOperationsImpl(account1);

        BigDecimal currentAmount = operations.getCurrentStock();

        Assert.assertEquals(new BigDecimal(123.45), currentAmount);
    }

    @Test
    public void getCurrentStock_when_Account_initialized_and_something_depoited_then_return_the_sum () {

        Account account1 = new AccountImpl(new BigDecimal(123.45));
        AccountOperations operations = new AccountOperationsImpl(account1);

        operations.deposit(new BigDecimal(6.78));
        BigDecimal currentAmount = operations.getCurrentStock();
        BigDecimal expectedResult = new BigDecimal(130.23).setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResult, currentAmount);
    }

    @Test
    public void getCurrentStock_when_Account_initialized_and_something_withdrawn_then_return_the_subtraction_of_withdrawn_amount_from_initialStock () {

        Account account1 = new AccountImpl(new BigDecimal(123.45));
        AccountOperations operations = new AccountOperationsImpl(account1);

        operations.withdraw(new BigDecimal(6.78));
        BigDecimal currentAmount = operations.getCurrentStock();
        BigDecimal expectedResult = new BigDecimal(116.67).setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expectedResult, currentAmount);
    }
}