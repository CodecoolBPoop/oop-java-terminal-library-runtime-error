package com.codecool.termlib;

public class Game {
    private void turn(Player current, Player opponent){
        current.shoot();
        if (current.checkWin()) {
            System.out.print(player2.getName() + " Win");
            break;
        }
    }
    public static void main(String[] args){
        Player player1 = new Player();
        Player player2 = new Player();

        int[] ships = new int[] {5,4,3,3,2};
        for (int i=0; i< ships.length; i++){
            player1.placeShip(i);
        }
        for (int i=0; i< ships.length; i++){
            player2.placeShip(i);
        }
        while(true){
            player1.shoot();
            if (player1.checkWin()) {
                System.out.print(player2.getName() + " Win");
                break;
            }
            player2.shoot();
            if (player2.checkWin()){
                System.out.print(player1.getName() + " Win");
                break;
            }
        }
    }
}
