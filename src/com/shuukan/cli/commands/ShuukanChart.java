package com.shuukan.cli.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "chart")
public class ShuukanChart implements Runnable {
    @Override
    public void run() {
        System.out.println("chart command");
    }
}