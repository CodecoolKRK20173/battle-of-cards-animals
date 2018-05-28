import java.util.Scanner;



public class Display {


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


    public void displayAboutGame() {



    }


    public void displayCardStatistic() {
        System.out.println("1. Top speed.\n" + 
                            "2. Max length.\n" + 
                            "3. Max weigth.\n" +
                            "4. Food.\n" + 
                            "5. Life span.");                  
    }


    // public void getShapesTable() {
    //     leftAlignFormat = "| %-4d | %-15s | %-15f | %-15f |%n";
        
    //     System.out.format("+------+------------------+-------------+--------+%n");
    //     System.out.format("|  ID  |     toString     |  Perimeter  |  Area  |%n");
    //     System.out.format("+------+------------------+-------------+--------+%n");
    //     for(int i = 0; i < shapeList.size(); i++) {
    //         System.out.format(leftAlignFormat, i + 
                                
    //                             shapeList.get(i).toString() + 
    //                             shapeList.get(i).calculatePerimeter() + 
                                 
    //                             shapeList.get(i).calculateArea());
                                
    //         System.out.format("+------+------------------+-------------+--------+%n");
    //     }
    //     System.out.format("+------+------------------+-------------+--------+%n");



    //     System.out.format("|--------------|");
    //     System.out.format("|--------------|");
    //     System.out.format("|--------------|");
    //     System.out.format("|--------------|");
    //     System.out.format("|--------------|");
    //     System.out.format("|-------+------|");
    //     System.out.format("|       |      |");
    //     System.out.format("|       |      |");
    //     System.out.format("|       |      |");
    //     System.out.format("|       |      |");
    //     System.out.format("|       |      |");
    //     System.out.format("|-------+------|");

    // }


}