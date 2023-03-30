package fr.codeworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TransactionTest {

    private Account testAccount(String name, double amount) {
        return new Account(new Client(name), amount, new SystemClock());
    }
    @Test
    public void aTransactionCanBeCredit() {
        Transaction credit = new CreditTransaction(10, LocalDateTime.now());
        Assertions.assertEquals(TransactionType.CREDIT, ((CreditTransaction) credit).getType());
        Assertions.assertEquals(10, credit.getAmount());
    }
    @Test
    public void aTransactioncanBeDebit() {
        Transaction debit = new DebitTransaction(10, LocalDateTime.now());
        Assertions.assertEquals(TransactionType.DEBIT, ((DebitTransaction) debit).getType());
        Assertions.assertEquals(10, debit.getAmount());
    }

    @Test
    public void aDebitCheckWithdrawAutorization() {
        Account account = testAccount("Pierre",100.0);
        account.withdraw(500);
        Assertions.assertEquals(100, account.getBalance());
        account.withdraw(50);
        Assertions.assertEquals(50, account.getBalance());
    }

    @Test
    public void aCreditCheckCreditAutorization() {
        Account account = testAccount("Pierre",100.0);
        account.deposit(0.001);
        Assertions.assertEquals(100, account.getBalance());
        account.deposit(200);
        Assertions.assertEquals(300, account.getBalance());
    }
}
