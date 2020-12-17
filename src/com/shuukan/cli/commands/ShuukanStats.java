package com.shuukan.cli.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "stats")
public class ShuukanStats implements Runnable {
    @Override
    public void run() {
        System.out.println("stats command");
    }
}