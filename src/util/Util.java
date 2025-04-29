package util;

import java.util.Scanner;

// Class that hold side function
public class Util {
//    Variable that change the color if text in console
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";

//    Function ot show success message
    public static void successMsg(String message) {
        System.out.println(Util.ANSI_BLACK + Util.ANSI_GREEN_BACKGROUND + message + Util.ANSI_RESET);
    }

//    Function to show error or failed message
    public static void errorMsg(String message) {
        System.out.println(Util.ANSI_BLACK + Util.ANSI_RED_BACKGROUND + message + Util.ANSI_RESET);
    }

//    Function to instruct user to press enter to continue
    public static void pressToContinue(Scanner sc) {
        System.out.println("Tekan \"ENTER\" untuk melanjutkan... ");
        sc.nextLine();
    }

}

