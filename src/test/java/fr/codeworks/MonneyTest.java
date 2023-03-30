package fr.codeworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonneyTest {

    private Account testAccount(String name, double amount) {
        return new Account(new Client(name), amount, new SystemClock());
    }
    @Test
    public void anAccountHasMonney() {
        Account account = testAccount("Tom", 100);
        Monney monney = new Monney(100);
        Assertions.assertEquals(monney.getAmount(), account.getBalance());
    }
}