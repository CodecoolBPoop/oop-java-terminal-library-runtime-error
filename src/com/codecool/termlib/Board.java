package com.codecool.termlib;

import java.util.Scanner;

public class Board {

    int[][] board;

    static private String abc = "    A   B   C   D   E   F   G   H   I   J";
    static private String [] abcArray = abc.trim().split("   ");

    Board() {
        board = createBoard(10, 10);
    }

    public Board(int width, int height) {
        board = createBoard(width, height);
    }

    private static int[][] createBoard(int width, int height) {
        int[][] tempBoard = new int[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tempBoard[i][j] = 2;
            }
        }
        return tempBoard;
    }

    void displayBoard(boolean ownBoard) {
        Terminal color = new Terminal();
        System.out.println(abc);
        for (int i = 0; i < board.length; i++) {
            System.out.print(String.format("%1$2s", i + 1) + " ");
            for (int j = 0; j < board[i].length; j++) {
                if (ownBoard) {
                    if (board[i][j] == 2) { // Displaying your own board
                        System.out.print(color.setBgColor("   ", color.BLUE_BACKGROUND)); // Water
                    } else {
                        System.out.print(color.setBgColor("   ", color.BLACK_BACKGROUND)); // Own ship
                    }
                } else {
                    switch (board[i][j]) { // Displaying opponent's board
                        case 0:
                            System.out.print(color.setBgColor(" * ", color.RED_BACKGROUND)); // Hit
                            break;
                        case 1:
                            System.out.print(color.setBgColor(" - ", color.WHITE_BACKGROUND)); // Miss
                            break;
                        default:
                            System.out.print(color.setBgColor("   ", color.BLUE_BACKGROUND)); // Hidden
                    }
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    int[] getCoordinates() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Please provide coordinates(e.g. A1, a1): ");
            String input = sc.nextLine();
            try {
                char inputLetter = Character.toUpperCase(input.charAt(0));
                String inputStringLetter = String.valueOf(inputLetter);
                int col = java.util.Arrays.asList(abcArray).indexOf(inputStringLetter);
                int row = Integer.parseInt(input.substring(1)) - 1;
                if (row <= 9 && row >= 0 && col <= 9 && col >= 0) {
                    int[] returns = {row, col};
                    return returns;
                }
            } catch (Exception e) {}
            System.out.println("Invalid coordinate");
        }
    }

}
