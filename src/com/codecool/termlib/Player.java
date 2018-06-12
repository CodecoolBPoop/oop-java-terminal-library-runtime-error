package com.codecool.termlib;
import java.util.Scanner;

public class Player {
    private String name;
    private int sumShipHealth;
    private Board board;

    public boolean checkWin(){
       return false;
    }

    public boolean shoot(int x, int y){
        return false;
    }

    public void placeShip(){
        System.out.println("Set the starting position of your first ship");
        int[] coordinates = board.getCoordinates();
        int x = coordinates[0];
        int y = coordinates[1];
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
