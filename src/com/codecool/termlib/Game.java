package com.codecool.termlib;

public class Game {
    public static void main(String[] args){
        Terminal terminal = new Terminal();
        terminal.printLogo();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("Player 1");
        player2.setName("Player 2");
        int[] ships = new int[] {5,4};
        for (int i=0; i< ships.length; i++){
            terminal.clearConsole();
            terminal.printLogo();
            player1.placeShip(ships[i]);
        }
        for (int ship: ships){
            terminal.clearConsole();
            terminal.printLogo();
            player2.placeShip(ship);
        }
        while(true){
            terminal.clearConsole();
            terminal.printLogo();
            player2.displayBoardToEnemy();
            System.out.print(player1.getName() + "'s turn\n");
            while (!player2.shoot()){}
            if (player2.checkLose()) {
                System.out.print(player1.getName() + " Win");
                break;
            }

            player1.displayBoardToEnemy();

            System.out.print(player2.getName() + "'s turn\n");
            while (!player1.shoot()){}
            if (player1.checkLose()){
                System.out.print(player2.getName() + " Win");
            }
        }
    }
}
