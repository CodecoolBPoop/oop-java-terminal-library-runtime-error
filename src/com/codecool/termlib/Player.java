package com.codecool.termlib;

import java.util.Scanner;

class Player {
    private String name;
    private int sumShipHealth = 0;
    private Board playerBoard = new Board();
    private int shipID = 3;

    boolean checkLose() {
            return this.sumShipHealth == 0;
    }

    boolean shoot(Player opponent) {
        opponent.displayBoardToEnemy();
        int[] coordinates;
        int x;
        int y;
        do {
            coordinates = playerBoard.getCoordinates();
            x = coordinates[0];
            y = coordinates[1];
            if (this.playerBoard.board[x][y] > 2) {
                System.out.println("Hit");
                this.playerBoard.board[x][y] = 0;
                this.sumShipHealth -= 1;
                return false;
            } else {
                if (this.playerBoard.board[x][y] == 2)
                System.out.println("Miss");
                this.playerBoard.board[x][y] = 1;
                return true;
            }
        } while (this.playerBoard.board[x][y] < 2);
    }


    public void displayBoard(){
        System.out.println("Own board: ");
        this.playerBoard.displayBoard(true);
    }
    public void displayBoardToEnemy(){
        System.out.println("Enemy board: ");
        this.playerBoard.displayBoard(false);
    }

    void placeShip(int shipLength) {
        checkStart:
        while (true) {
            playerBoard.displayBoard(true);
            System.out.printf("%s's ship placement with length: %d\n>> ",this.getName(), shipLength);
            int[] coordinates = playerBoard.getCoordinates();
            int x = coordinates[0];
            int y = coordinates[1];
            Scanner scanner = new Scanner(System.in);
            String message = "Declare orientation for the ship [h/v]:";
            char direction;

            while (true) {
                System.out.print(message);
                direction = Character.toUpperCase(scanner.next().charAt(0));
                if (direction == 'V' || direction == 'H') {
                    break;
                }
                message = "You gave a non-valid orientation, please use 'h' or 'v'";
            }

            if (direction == 'H') {
                if (y + shipLength > this.playerBoard.board[x].length) {
                    System.out.println("That field is unavailable");
                    continue;
                }
                for (int i = 0; i < shipLength; i++) {
                    if (this.playerBoard.board[x][y + i] != 2) {
                        System.out.println("That field is unavailable");
                        continue checkStart;
                    }
                }
            } else {
                if (x + shipLength > this.playerBoard.board[x].length) {
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


            if (direction == 'H') {
                for (int i = 0; i < shipLength; i++) {
                    this.playerBoard.board[x][y + i] = this.shipID;
                }
            } else {
                for (int i = 0; i < shipLength; i++) {
                    this.playerBoard.board[x + i][y] = this.shipID;
                }
            }

            this.sumShipHealth += shipLength;
            shipID++;
            break;
        }

    }

    void setName(String forWho){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Set a name for player %s: ", forWho);
        this.name = scanner.nextLine();
    }

    String getName(){
        return this.name;
    }

}
