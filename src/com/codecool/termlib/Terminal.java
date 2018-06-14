package com.codecool.termlib;

public class Terminal {
    // Reset Color - without this after using a color it will remain.
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Background Colors
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    /**
     * @param inputText The text which's background color should be set.
     * @param color obj.[BLACK_BACKGROUND, RED_BACKGROUND, GREEN_BACKGROUND, YELLOW_BACKGROUND,
     *              PURPLE_BACKGROUND, CYAN_BACKGROUND, WHITE_BACKGROUND, BLUE_BACKGROUND]
     */

    String setBgColor(String inputText, String color) {
        return color + inputText + RESET;
    }

    void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    void printLogo() {
        System.out.println(" _           _   _   _           _     _       \n" +
                "| |         | | | | | |         | |   (_)      \n" +
                "| |__   __ _| |_| |_| | ___  ___| |__  _ _ __  \n" +
                "| '_ \\ / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\ \n" +
                "| |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |\n" +
                "|_.__/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/ \n" +
                "                                        | |    \n" +
                "                                        |_|    ");
    }

    /**
     * @param inputText The text which's background color should be set.
     * @param bgColor obj.[BLACK_BACKGROUND, RED_BACKGROUND, GREEN_BACKGROUND, YELLOW_BACKGROUND,
     *              PURPLE_BACKGROUND, CYAN_BACKGROUND, WHITE_BACKGROUND, BLUE_BACKGROUND]
     * @param textColor obj.[BLACK, RED, GREEN, YELLOW, PURPLE, CYAN, WHITE, BLUE]
     */

    public String setBgAndTextColor(String inputText, String bgColor, String textColor) {
        return bgColor + textColor + inputText + RESET;
    }




}
