package com.corndel.supportbank.controllers;

import com.corndel.supportbank.controllers.commands.CompoundCommand;
import com.corndel.supportbank.controllers.commands.SimpleCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "invest", subcommands = {SimpleCommand.class, CompoundCommand.class})
public class InvestController {
}
