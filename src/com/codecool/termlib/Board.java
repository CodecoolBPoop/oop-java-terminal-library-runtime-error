package com.codecool.termlib;

import java.util.Scanner;

public class Board {

    int[][] board;

    static private String abc = "  A B C D E F G H I J";
    static private String [] abcArray = abc.trim().split(" ");

    Board() {
        board = new int[10][10];
    }

    public Board(int width, int height) {
        board = new int[height][width];
    }

    void displayBoard(boolean ownBoard) {
        System.out.println(abc);
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                if (ownBoard) {
                    System.out.print(board[i][j] + " ");
                } else {
                    switch (board[i][j]) {
                        case 1:
                            System.out.print("*");
                            break;
                        case 2:
                            System.out.print("-");
                            break;
                        default:
                            System.out.print(board[i][j]);
                    }
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    int[] getCoordinates() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please give a coordinate(e.g. A1, a1): ");
            String input = sc.nextLine();
            if (input.length() == 2) {
                try {
                    char inputLetter = Character.toUpperCase(input.charAt(0));
                    String inputStringLetter = String.valueOf(inputLetter);
                    int col = java.util.Arrays.asList(abcArray).indexOf(inputStringLetter);
                    int row = Character.getNumericValue(input.charAt(1));
                    System.out.println(col);
                    System.out.println(row);
                    if (row <= 9 && col <= 9) {
                        int[] returns = {row, col};
                        return returns;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            System.out.println("Invalid coordinate");
        }
    }

}
