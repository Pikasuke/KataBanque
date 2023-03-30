package fr.codeworks;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreditTransaction extends Transaction {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
    public CreditTransaction(double amount, LocalDateTime date) {
        this.type = TransactionType.CREDIT;
        this.amount = BigDecimal.valueOf(amount);
        this.date = date;
    }

    public TransactionType getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount.doubleValue();
    }

    public static boolean isDepositAllowed(double amount) {
        return amount >= 0.01;
    }

    public static Monney actualizedBalanced(double amount, Monney balance) {
        balance.plusMonney(amount);
        return balance;
    }
}
