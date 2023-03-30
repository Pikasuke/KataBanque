package fr.codeworks;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Transaction {
    protected TransactionType type;
    protected BigDecimal amount;
    protected LocalDateTime date;
    public double getAmount() {
        return amount.doubleValue();
    }

}
