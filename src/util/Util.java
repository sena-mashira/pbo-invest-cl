package util;

import java.util.Scanner;

public class Util {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void addDelay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println("Terjadi kesalahan saat delay: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public static void successMsg(String message) {
        System.out.println(Util.ANSI_BLACK + Util.ANSI_GREEN_BACKGROUND + message + Util.ANSI_RESET);
    }

    public static void errorMsg(String message) {
        System.out.println(Util.ANSI_BLACK + Util.ANSI_RED_BACKGROUND + message + Util.ANSI_RESET);
    }

    public static void pressToContinue(Scanner sc) {
        System.out.println("Tekan \"ENTER\" untuk melanjutkan... ");
        sc.nextLine();
    }

}

