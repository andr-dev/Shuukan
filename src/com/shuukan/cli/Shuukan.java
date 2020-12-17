package com.shuukan.cli;

import com.shuukan.db.ShuukanDB;
import picocli.CommandLine.Command;

import com.shuukan.cli.commands.ShuukanChart;
import com.shuukan.cli.commands.ShuukanOverview;
import com.shuukan.cli.commands.ShuukanStats;
import com.shuukan.cli.commands.ShuukanToday;

import java.io.IOException;

@Command(name = "Shuukan", mixinStandardHelpOptions = true, version = "Shuukan 1.0",
subcommands = {
        ShuukanOverview.class,
        ShuukanStats.class,
        ShuukanChart.class,
        ShuukanToday.class
})
public class Shuukan implements Runnable {

    @Override
    public void run() {
        int lastInput = 0;

        ShuukanDB sdb = new ShuukanDB();

        do {
            //clear();
            lastInput = MenuManager.mainMenu();

            switch (lastInput) {
                case 1:
                    System.out.println("command -> 1");
                    break;
                case 2:
                    System.out.println("command -> 2");
                    break;
                default:
                    System.out.println("command -> unknown");
                    break;
            }
        } while (lastInput != 0);
    }

    public static void main (String[] args) {
        int exitCode = new picocli.CommandLine(new Shuukan()).execute(args);
        System.exit(exitCode);
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("cls");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}