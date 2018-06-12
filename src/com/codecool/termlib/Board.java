package com.codecool.termlib;

public class Board {

    int[][] board;

    static String abc = "  A B C D E F G H I J";

    public Board() {
        board = new int[10][10];
    }

    public Board(int width, int height) {
        board = new int[height][width];
    }

    public void displayBoard(boolean ownBoard) {
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

}
