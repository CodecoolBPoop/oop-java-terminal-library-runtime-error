package com.codecool.termlib;

public class Game {
    public static void main(String[] args){
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("Player 1");
        player2.setName("Player 2");
        int[] ships = new int[] {5,4};
        for (int i=0; i< ships.length; i++){
            player1.placeShip(ships[i]);
        }
        for (int ship: ships){
            player2.placeShip(ship);
        }
        game:
        while(true){
            System.out.print(player1.getName() + "'s turn\n");
            while (player2.shoot()){
                if (player2.checkLose()) {
                    System.out.print(player1.getName() + " Win");
                    break game;
                }
            }

            System.out.print(player2.getName() + "'s turn\n");
            while (player1.shoot()){
                if (player1.checkLose()){
                    System.out.print(player2.getName() + " Win");
                    break game;
                }
            }
        }
    }
}
