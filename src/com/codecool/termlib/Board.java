package com.codecool.termlib;

import java.util.Scanner;

public class Board {

    int[][] board;

    static private String abc = "   A B C D E F G H I J";
    static private String [] abcArray = abc.trim().split(" ");

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
        System.out.println(abc);
        for (int i = 0; i < board.length; i++) {
            System.out.print(String.format("%1$2s", i + 1) + " ");
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
