
package com.corndel.supportbank.cli.bill;

import picocli.CommandLine.Command;

@Command(name = "bill", subcommands = SplitCommand.class)
public class BillController {
}
