package com.shuukan.cli;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {
    private static Scanner scan = new Scanner(System.in);

    private static String BANNER1 =
            " _____  _                    _                  \n" +
            "/  ___|| |                  | |                 \n" +
            "\\ `--. | |__   _   _  _   _ | | __  __ _  _ __  \n" +
            " `--. \\| '_ \\ | | | || | | || |/ / / _` || '_ \\ \n" +
            "/\\__/ /| | | || |_| || |_| ||   < | (_| || | | |\n" +
            "\\____/ |_| |_| \\__,_| \\__,_||_|\\_\\ \\__,_||_| |_|\n";
    private static String BANNER2 =
            "  ██████  ██░ ██  █    ██  █    ██  ██ ▄█▀▄▄▄       ███▄    █ \n" +
            "▒██    ▒ ▓██░ ██▒ ██  ▓██▒ ██  ▓██▒ ██▄█▒▒████▄     ██ ▀█   █ \n" +
            "░ ▓██▄   ▒██▀▀██░▓██  ▒██░▓██  ▒██░▓███▄░▒██  ▀█▄  ▓██  ▀█ ██▒\n" +
            "  ▒   ██▒░▓█ ░██ ▓▓█  ░██░▓▓█  ░██░▓██ █▄░██▄▄▄▄██ ▓██▒  ▐▌██▒\n" +
            "▒██████▒▒░▓█▒░██▓▒▒█████▓ ▒▒█████▓ ▒██▒ █▄▓█   ▓██▒▒██░   ▓██░\n" +
            "▒ ▒▓▒ ▒ ░ ▒ ░░▒░▒░▒▓▒ ▒ ▒ ░▒▓▒ ▒ ▒ ▒ ▒▒ ▓▒▒▒   ▓▒█░░ ▒░   ▒ ▒ \n" +
            "░ ░▒  ░ ░ ▒ ░▒░ ░░░▒░ ░ ░ ░░▒░ ░ ░ ░ ░▒ ▒░ ▒   ▒▒ ░░ ░░   ░ ▒░\n" +
            "░  ░  ░   ░  ░░ ░ ░░░ ░ ░  ░░░ ░ ░ ░ ░░ ░  ░   ▒      ░   ░ ░ \n" +
            "      ░   ░  ░  ░   ░        ░     ░  ░        ░  ░         ░ \n";

    private static String BANNER3 =
            " ____ ____ ____ ____ ____ ____ ____ \n" +
            "||S |||h |||u |||u |||k |||a |||n ||\n" +
            "||__|||__|||__|||__|||__|||__|||__||\n" +
            "|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|\n";

    public static void flush() {
        scan.next();
    }

    public static String getInputString() throws InputMismatchException {
        return scan.nextLine();
    }

    public static int getInputInt() throws InputMismatchException {
        return scan.nextInt();
    }

    public static int mainMenu() {
        boolean repeat = true;

        int choice = 0;

        do {
            System.out.println(BANNER1);
            System.out.println(" 1) Overview");
            System.out.println(" 2) Stats");
            System.out.println(" 3) Chart");
            System.out.println(" 4) Today");
            System.out.println(" 5) Create");
            System.out.println(" 6) Add/Edit/Delete");
            System.out.println(" 7) View");
            System.out.println(" 0) Exit");

            try {
                choice = getInputInt();
                repeat = false;
            } catch (InputMismatchException e) {
                flush();
            } catch (Exception e) {
                System.out.println("Huh!");
                flush();
            }
        } while (repeat);

        return choice;
    }
}