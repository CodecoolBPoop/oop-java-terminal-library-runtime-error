package com.codecool.termlib;

public class Game {
    public static void main(String[] args){
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("Player 1");
        player2.setName("Player 2");
        int[] ships = new int[] {3,2};
        for (int i=0; i< ships.length; i++){
            player1.placeShip(ships[i]);
        }
        for (int i=0; i< ships.length; i++){
            player2.placeShip(ships[i]);
        }
        while(true){
            player2.displayBoardToEnemy();
            while (!player2.shoot()){}
            if (player1.checkWin()) {
                System.out.print(player2.getName() + " Win");
                break;
            }

            player1.displayBoardToEnemy();
            while (!player1.shoot()){}
            if (player2.checkWin()){
                System.out.print(player1.getName() + " Win");
                break;
            }
        }
    }
}
