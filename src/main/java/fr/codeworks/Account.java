package fr.codeworks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private Client clientName;
    private Monney balance;
    private double initialBalance;
    private List<Transaction> transactions;

    private Clock clock;

    public Account(Client name, double amount, Clock clock) {
        this.clientName = name;
        this.balance = new Monney(amount);
        this.clock = clock;
        this.initialBalance = amount;
        this.transactions = new ArrayList<>();
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public Client getName() {
        return clientName;
    }

    public void setName(Client name) {
        this.clientName = name;
    }

    public double getBalance() {
        return balance.getAmount();
    }

    public void setBalance(double balance) {
        this.balance = new Monney(balance);
    }

    public void deposit(double amount) {
        if (CreditTransaction.isDepositAllowed(amount)) {
            Transaction transaction = new CreditTransaction(amount, clock.getDate());
            transactions.add(transaction);
            this.balance = CreditTransaction.actualizedBalanced(amount, this.balance);
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void withdraw(double amount) {
        if (DebitTransaction.isWithdrawAuthorized(amount, this.balance)) {
            Transaction transaction = new DebitTransaction(amount, clock.getDate());
            transactions.add(transaction);
            this.balance = (DebitTransaction.actualizedBalanced(amount, this.balance));
        }
    }
}