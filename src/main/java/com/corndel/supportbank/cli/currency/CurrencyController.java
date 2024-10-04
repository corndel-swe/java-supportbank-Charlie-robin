package com.corndel.supportbank.cli.currency;

import picocli.CommandLine;

@CommandLine.Command(name = "currency", subcommands = {CurrencyCommand.class, LatestCommand.class})
public class CurrencyController {
}

