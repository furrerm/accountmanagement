package ch.lu.erni.accountmanagement;

import ch.lu.erni.account.Account;
import ch.lu.erni.account.AccountImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountOperationsImplTest {

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
}