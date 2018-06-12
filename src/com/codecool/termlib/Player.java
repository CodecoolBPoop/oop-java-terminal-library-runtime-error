package com.codecool.termlib;

public class Player {
    private String name;
    private int sumShipHealth = 0;
    private Board board = new Board();

    public boolean checkWin() {
            return this.sumShipHealth == 0;
    }

    public boolean shoot() {
        int[] coordinates = board.getCoordinates();
        int x = coordinates[0];
        int y = coordinates[1];
        if (this.board.board[x][y] > 1) {
            if (this.board.board[x][y] > 2) {
                System.out.print("Hit");
                this.board.board[x][y] = 0;
                this.sumShipHealth -= 1;
            } else {
                System.out.print("Miss");
                this.board.board[x][y] = 1;
            }
            return true;
        }
        return false;

    }

    public void placeShip(){

    }
    public void setName(String name){

    }
    public String getName(){
        return this.name;
    }
}
