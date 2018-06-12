package com.codecool.termlib;

public class Player {
    private String name;
    private int sumShipHealth = 0;
    private Board board;

    public boolean checkWin(){
       if (this.sumShipHealth == 0){
           return true;
       }
       return false;
    }
    public boolean shoot(){
        int[] coordinates = board.getCoordinates();
        int x = coordinates[0];
        int y = coordinates[1];
        if (this.board.board[x][y] > 1 ){
            if (this.board.board[x][y] > 2){
                System.out.print("Hit");
                this.board.board[x][y] = 0;
                return true;
            } else {
                System.out.print("Miss");
                this.board.board[x][y] = 1;
                return true;
            }
        return false;
    }
    public void placeShip(){

    }
    public void setName(String name){

    }
    public String getName(){

    }



}
