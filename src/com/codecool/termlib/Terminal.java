package com.codecool.termlib;

class Terminal {

    // Reset Color - without this after using a color it will remain.
    private static final String RESET = "\033[0m";  // Text Reset

    // Background Colors
    static final String BLACK_BACKGROUND = "\u001B[40m";
    static final String RED_BACKGROUND = "\u001B[41m";
    static final String YELLOW_BACKGROUND = "\u001B[43m";
    static final String BLUE_BACKGROUND = "\u001B[44m";
    static final String WHITE_BACKGROUND = "\u001B[47m";


    void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
     * @param color obj.[BLACK_BACKGROUND, RED_BACKGROUND, GREEN_BACKGROUND, YELLOW_BACKGROUND,
     *              PURPLE_BACKGROUND, CYAN_BACKGROUND, WHITE_BACKGROUND, BLUE_BACKGROUND]
     */
    String setBgColor(String inputText, String color) {
        return color + inputText + RESET;
    }
}
