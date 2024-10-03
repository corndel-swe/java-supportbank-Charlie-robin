package com.corndel.supportbank.controllers;

import com.corndel.supportbank.controllers.commands.ListCommand;
import com.corndel.supportbank.controllers.commands.SummariseCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "transaction", subcommands = {SummariseCommand.class, ListCommand.class})
public class TransactionController {
}
