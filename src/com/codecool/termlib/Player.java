package com.codecool.termlib;

import java.util.Scanner;

public class Player {
    private String name;
    private int sumShipHealth = 0;
    private Board playerBoard = new Board();
    private int shipID = 3;

    public boolean checkWin() {
            return this.sumShipHealth == 0;
    }

    public boolean shoot() {
        int[] coordinates = playerBoard.getCoordinates();
        int x = coordinates[0];
        int y = coordinates[1];
        if (this.playerBoard.board[x][y] > 1) {
            if (this.playerBoard.board[x][y] > 2) {
                System.out.print("Hit");
                this.playerBoard.board[x][y] = 0;
                this.sumShipHealth -= 1;
            } else {
                System.out.print("Miss");
                this.playerBoard.board[x][y] = 1;
            }
            return true;
        }
        return false;
    }

    public void placeShip(int shipLength) {
        checkStart:
        while (true) {
            playerBoard.displayBoard(true);
            int[] coordinates = playerBoard.getCoordinates();
            int x = coordinates[0];
            int y = coordinates[1];
            Scanner scanner = new Scanner(System.in);
            System.out.println("Declare orientation for the ship [h/v]:");
            char direction = Character.toUpperCase(scanner.next().charAt(0));

            if (direction == 'H') {
                if (y + shipLength >= this.playerBoard.board[x].length) {
                    System.out.println("That field is unavailable");
                    continue;
                }
                for (int i = 0; i < shipLength; i++) {
                    if (this.playerBoard.board[x][y + i] != 2) {
                        System.out.println("That field is unavailable");
                        break checkStart;
                    }
                }
            } else {
                if (x + shipLength >= this.playerBoard.board[x].length) {
                    System.out.println("That field is unavailable");
                    continue;
                }
                for (int i = 0; i < shipLength; i++) {
                    if (this.playerBoard.board[x + i][y] != 2) {
                        System.out.println("That field is unavailable");
                        continue checkStart;
                    }
                }
            }


            System.out.print(shipLength);
            if (direction == 'H') {
                for (int i = 0; i < shipLength; i++) {
                    System.out.print("hello");
                    this.playerBoard.board[x][y + i] = this.shipID;
                }
            } else {
                for (int i = 0; i < shipLength; i++) {
                    System.out.print("hello");
                    this.playerBoard.board[x + i][y] = this.shipID;
                }
            }

            shipID++;
            break;
        }

    }

    public void setName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        this.name = scanner.nextLine();
    }

    public String getName(){
        return this.name;
    }

}
