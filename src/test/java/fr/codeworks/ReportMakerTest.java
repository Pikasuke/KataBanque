package fr.codeworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ReportMakerTest {

    private Account testAccount(String name, double amount) {
        return new Account(new Client(name), amount, new SystemClock());
    }
    @Test
    public void ReportMakerCreateReport() {
        Clock clock = new StubClock();
        Account account = new Account(new Client("Pierre"), 1000, clock);
        ((StubClock) clock).setDate(LocalDateTime.of(2023, 03, 23, 00, 00, 00));
        account.deposit(1000);
        ((StubClock) clock).setDate(LocalDateTime.of(2023, 03, 25, 00, 00, 00));
        account.withdraw(500);
        ((StubClock) clock).setDate(LocalDateTime.of(2023, 03, 27, 00, 00, 00));
        account.deposit(2000);
        String expectedReport =
                "+---CREDIT---+-2023-03-23T00:00-+-----1000.0----+\n"+
                "+---DEBIT---+-2023-03-25T00:00-+-----500.0----+\n"+
                "+---CREDIT---+-2023-03-27T00:00-+-----2000.0----+\n";
        Assertions.assertEquals(expectedReport, ReportMaker.createTransactionReport(account));
    }
}
