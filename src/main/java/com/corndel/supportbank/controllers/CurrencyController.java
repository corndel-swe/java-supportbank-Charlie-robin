package com.corndel.supportbank.controllers;

import com.corndel.supportbank.controllers.commands.CurrencyCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "currency", subcommands = {CurrencyCommand.class})
public class CurrencyController {
}

