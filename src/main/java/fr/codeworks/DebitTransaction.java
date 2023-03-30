package fr.codeworks;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DebitTransaction extends Transaction {
    public DebitTransaction(double amount, LocalDateTime date) {
        this.type = TransactionType.DEBIT;
        this.amount = BigDecimal.valueOf(amount);
        this.date = date;
    }

    public static boolean isWithdrawAuthorized(double amount, Monney balance) {
        return balance.getAmount() - amount >= 0;
    }

    public static Monney actualizedBalanced(double amount, Monney balance) {
        balance.setAmount(balance.getAmount() - amount );
        return balance;
    }

    public TransactionType getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount.doubleValue();
    }
}
