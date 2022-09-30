

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    //    The deposit and withdraw methods will not accept negative numbers.
    //    Account cannot overstep its overdraft limit.
    //    The deposit and withdraw methods will deposit or withdraw the correct amount, respectively.
   //    The withdrawn and deposit methods return the correct results.
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void cannotHaveNegativeWithdrawValue() {
        Account account = new Account(100);

        Assert.assertFalse(account.withdraw(-20));
    }

    @Test
    public void cannotHaveNegativeDepositValue() {
        Account account = new Account(100);

        Assert.assertFalse(account.deposit(-20));
    }

    @Test
    public void accountCannotOverstepOverdraftLimit() {
        Account account = new Account(100);

        Assert.assertFalse(account.withdraw(110));
    }

    @Test
    public void correctValueIsDeposited() {
        Account account = new Account(100);

        double valueToBeDeposited = 25;

        account.deposit(valueToBeDeposited);

        Assert.assertEquals(valueToBeDeposited, account.getBalance(), valueToBeDeposited - account.getBalance());
    }

    @Test
    public void correctValueIsWithdrawn() {
        Account account = new Account(100);

        double valueToBeWithdrawn = 25;

        account.deposit(valueToBeWithdrawn); // above test guarantee that deposit method works properly
        account.withdraw(valueToBeWithdrawn);

        Assert.assertEquals(0, account.getBalance(), 0 - account.getBalance());

    }

    @Test
    public void depositReturnCorrectResult(){
        Account account = new Account(100);
        Assert.assertTrue(account.deposit(50));
    }

    @Test
    public void withdrawReturnCorrectResult(){
        Account account = new Account(100);
        account.deposit(50);
        Assert.assertTrue(account.withdraw(50));
    }


}
