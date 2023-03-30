package fr.codeworks;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportMaker {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
    private static final String REPORT_HEADER =
            "+-------------------+-----------------+\n" +
            "|      ACCOUNT      |  SOLDE INITIAL  |\n" +
            "+-------------------+-----------------+\n";
    private static final String TRANSACTION_HEADER =
            "+------------+------------------------------+--------------+\n" +
            "|    TYPE    |             Date             |    Amount    |\n" +
            "+------------+---------------+--------------+--------------+\n";

    private static final String REPORT_FOOTER =
            "+-------------------+---------------+\n" +
            "|      ACCOUNT      |  SOLDE FINAL  |\n" +
            "+-------------------+---------------+\n";

    public static String createTransactionReport(Account account) {
        List<Transaction> transactions = account.getTransactions();
        String transactionReport = "";
        for (Transaction transac : transactions) {
         transactionReport = transactionReport + "+---"+transac.type+"---+-"+transac.date+"-+-----"+transac.amount+"----+\n";
        }
        return transactionReport;
    }

    public static String createReport(Account account) {
        String report = REPORT_HEADER + "+--"+account.getName()+"--+-----"+account.getInitialBalance()+"------+\n";
        report = report + TRANSACTION_HEADER + createTransactionReport(account);
        report = report + REPORT_FOOTER + "+--"+account.getName()+"--+-----"+account.getBalance()+"------+\n";
        System.out.println(report);
        return report;
    }
}
