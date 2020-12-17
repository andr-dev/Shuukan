package com.shuukan.cli.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "overview")
public class ShuukanOverview implements Runnable {
    @Override
    public void run() {
        System.out.println("overview command");
    }
}