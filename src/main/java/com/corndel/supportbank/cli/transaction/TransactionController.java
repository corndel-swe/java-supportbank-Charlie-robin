package com.corndel.supportbank.cli.transaction;

import picocli.CommandLine;

@CommandLine.Command(name = "transaction", subcommands = {SummariseCommand.class, ListCommand.class})
public class TransactionController {
}
