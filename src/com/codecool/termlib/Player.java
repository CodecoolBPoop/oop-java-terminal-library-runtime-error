package com.codecool.termlib;

import java.util.Scanner;

public class Player {
    private String name;
    private int sumShipHealth = 0;
    private Board playerBoard;
    private int shipID = 3;

    public boolean checkWin() {
        if (this.sumShipHealth == 0) {
            return true;
        }
        return false;
    }

    public boolean shoot() {
        int[] coordinates = playerBoard.getCoordinates();
        int x = coordinates[0];
        int y = coordinates[1];
        if (this.playerBoard.board[x][y] > 1) {
            if (this.playerBoard.board[x][y] > 2) {
                System.out.print("Hit");
                this.playerBoard.board[x][y] = 0;
                return true;
            } else {
                System.out.print("Miss");
                this.playerBoard.board[x][y] = 1;
                return true;
            }
        }
        return false;
    }

    public void placeShip(int shipLength) {

        while (true) {
            int[] coordinates = playerBoard.getCoordinates();
            int x = coordinates[0];
            int y = coordinates[1];
            Scanner scanner = new Scanner(System.in);
            System.out.println("Declare orientation for the ship [h/v]:");
            char direction = scanner.next().charAt(0);

            if (direction == 'v' || direction == 'V') {
                if (y + shipLength >= this.playerBoard.board[x].length){
                    System.out.println("That field is unavailable");
                    continue;
                }
                for (int i = 0; i < shipLength; i++) {
                    if (this.playerBoard.board[x][y + i] != 2){
                        System.out.println("That field is unavailable");
                        continue;
                    }
                }
            } else {
                if (x + shipLength >= this.playerBoard.board[x].length){
                    System.out.println("That field is unavailable");
                    continue;
                }
                for (int i = 0; i < shipLength; i++) {
                    if (this.playerBoard.board[x + i][y] != 2){
                        System.out.println("That field is unavailable");
                        continue;
                    }
                }
            }
            break;
        }

        if (direction == 'v' || direction == 'V') {
            for (int i = 0; i < shipLength; i++) {
                this.playerBoard.board[x][y + i] = shipID;
            }
        } else {
            for (int i = 0; i < shipLength; i++) {
                this.playerBoard.board[x + i][y] = shipID;
            }
        }

        shipID++;
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
