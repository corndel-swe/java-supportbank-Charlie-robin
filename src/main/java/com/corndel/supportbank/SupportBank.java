package com.corndel.supportbank;

import com.corndel.supportbank.cli.bill.BillController;
import com.corndel.supportbank.cli.currency.CurrencyController;
import com.corndel.supportbank.cli.invest.InvestController;
import com.corndel.supportbank.cli.transaction.TransactionController;
import com.github.tomaslanger.chalk.Chalk;
import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command(name = "supportbank", subcommands = {
        BillController.class,
        CurrencyController.class,
        TransactionController.class,
        InvestController.class
})
public class SupportBank implements Runnable {

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new SupportBank());
        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        System.out.println(Chalk.on("Welcome to the support bank!").green());
    }
}
