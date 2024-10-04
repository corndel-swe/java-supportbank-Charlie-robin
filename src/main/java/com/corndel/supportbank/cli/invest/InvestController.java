package com.corndel.supportbank.cli.invest;

import picocli.CommandLine;

@CommandLine.Command(name = "invest", subcommands = {SimpleCommand.class, CompoundCommand.class})
public class InvestController {
}
