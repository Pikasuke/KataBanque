package fr.codeworks;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Clock clock = new SystemClock();
        Account account = new Account(new Client("Pierre"), 1000, clock);
        account.deposit(1000);
        account.withdraw(500);
        account.deposit(2000);
        String report = ReportMaker.createTransactionReport(account);
        System.out.println(report);
    }
}