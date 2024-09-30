package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.CurrencyService;
import picocli.CommandLine;

@CommandLine.Command(name = "currency", subcommands = {CurrencyService.class})
public class CurrencyController {

}

