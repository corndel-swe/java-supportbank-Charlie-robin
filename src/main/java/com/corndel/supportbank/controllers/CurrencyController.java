package com.corndel.supportbank.controllers;

import com.corndel.supportbank.controllers.commands.CurrencyCommand;
import com.corndel.supportbank.controllers.commands.LatestCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "currency", subcommands = {CurrencyCommand.class, LatestCommand.class})
public class CurrencyController {
}

