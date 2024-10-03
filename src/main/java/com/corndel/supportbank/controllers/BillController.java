
package com.corndel.supportbank.controllers;

import com.corndel.supportbank.controllers.commands.SplitCommand;
import picocli.CommandLine.Command;

@Command(name = "bill", subcommands = SplitCommand.class)
public class BillController {
}
