package fr.codeworks;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AccountTest {

    private Account testAccount(String name, double amount) {
        return new Account(new Client(name), amount, new SystemClock());
    }

    @Test
    public void aBankAccountCouldBeCreateWith1cents() {
        Account account = testAccount("Jean", 0.1);
        Assertions.assertEquals("Client : Jean", account.getName().toString());
        Assertions.assertEquals(0.1, account.getBalance());
    }

    @Test
    public void accountCanDepositMoneyStartTo1cents() {
        Account account = testAccount("Pierre",100 );
        account.deposit(0.01);
        Assertions.assertEquals(100.01, account.getBalance());
    }

    @Test
    public void aDepositCreateACreditTransaction() {
        Account account = testAccount("Paul",100 );
        account.deposit(100);
        Transaction credit = new CreditTransaction(100, LocalDateTime.now());
        Assertions.assertEquals(credit.type, account.getTransactions().get(0).type);
        Assertions.assertEquals(credit.getAmount(), account.getTransactions().get(0).getAmount());
    }

    @Test
    public void aWithdrawCreateADebitTransaction() {
        Account account = testAccount("Jaques",100 );
        account.withdraw(99);
        Transaction debit = new DebitTransaction(100 , LocalDateTime.now());
        Assertions.assertEquals(TransactionType.DEBIT, account.getTransactions().get(0).type);
        Assertions.assertEquals(99, account.getTransactions().get(0).getAmount());
    }

    @Test
    void accountHaveAnInitialAndFinalBalance() {
        Account account = testAccount("Tom",1000 );
        account.deposit(1000);
        account.withdraw(500);
        Assertions.assertEquals(1000, account.getInitialBalance());
        Assertions.assertEquals(1500, account.getBalance());
    }
}
