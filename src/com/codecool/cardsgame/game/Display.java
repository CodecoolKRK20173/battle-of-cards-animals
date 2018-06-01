package com.codecool.cardsgame.game;

import com.codecool.cardsgame.cards.*;
import com.codecool.cardsgame.iterator.*;
import com.codecool.cardsgame.players.*;


import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;



public class Display {

    private String fileName;


    public void displayMainMenu() {

        System.out.println("1. Start game.\n" + 
                            "2. About the game.\n" + 
                            "3. Exit game.");     

    }


    public void displayGameMode() {

        System.out.println("1. Player vs Player.\n" + 
                            "2. Player vs Computer.\n" + 
                            "3. Computer vs Computer.");

    }


    public void displayGameLevel() {

        System.out.println("1. Easy.\n" + 
                            "2. Hard."); 

    }


    public void displayAboutGame(String fileName) {

        try {
            Scanner sc = new Scanner(Paths.get(fileName));
            
            while(sc.hasNext()) {
                String[] columns = sc.nextLine().split(" ");
                System.out.println(Arrays.toString(columns)); 
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayCardStatistic() {
        System.out.println("1. Top speed.\n" + 
                            "2. Max length.\n" + 
                            "3. Max weight.\n" +
                            "4. Food.\n" + 
                            "5. Life span.");                  
    }

}