package com.shuukan.cli.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "today")
public class ShuukanToday implements Runnable {
    @Override
    public void run() {
        System.out.println("today command");
    }
}