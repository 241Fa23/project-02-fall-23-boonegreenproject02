/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project02startingfiles;

import java.util.*;

/**
 *
 * @author
 */
public class Project02StartingFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //setting up variables and scanners
        Scanner inputClass = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        String user;
        String choice;
        Player player = null;

        //beginning menu
        System.out.println("Welcome to JavaQuest!");
        System.out.println("Stay alive and increase your score!");
        System.out.println("Choose a character...");
        System.out.println("{k}Knight || {h} Healer || {w}Wizard || {t}Thief");
        user = inputClass.next().toLowerCase();
        //loop for if they dont choose form the available classes
        while (!user.equals("k") && !user.equals("h") && !user.equals("w") && !user.equals("t")) {
            System.out.println("Invalid choice... Choose your class adventurer.");
            System.out.println("{k}Knight || {h} Healer || {w}Wizard || {t}Thief");
            user = inputClass.next().toLowerCase();
        }
        //sets player to the class that was chosen
        if (user.equals("k")) {
            player = new Knight();
            user = "Knight";
        } else if (user.equals("h")) {
            player = new Healer();
            user = "Healer";
        } else if (user.equals("w")) {
            player = new Wizard();
            user = "Wizard";
        } else if (user.equals("t")) {
            player = new Thief();
            user = "Thief";
        }

        //priming read of sentinel loop
        System.out.println("Get ready for your adventure as a " + user + "!!!");
        menu();
        choice = input.next().toLowerCase();

        //sentinel loop for game
        while (!choice.equals("q")) {
            if (choice.equals("n") || choice.equals("s") || choice.equals("e") || choice.equals("w")) {
                //if they chose to move, goes through the move() method
                move(player);
            } else if (choice.equals("?")) {
                //if they chose status report, give them a status report of their character
                statusReport(player);
            } else {
                //if they didnt chose one of the available menu options
                System.out.println("Invalid choice adventurer...Try again...");
            }
            menu();
            choice = input.next();
        }
        //prints out the ending screen with the final status report of the character
        System.out.println("*************************\n*************************");
        System.out.println("The game has come to an end! Your final stats were:\n");
        statusReport(player);
        System.out.println("Thanks for playing!");
    }

    public static void menu() {
        //prints out the menu
        System.out.println("\nWhat would you like to do?");
        System.out.println("{?}Status Report || {n}{s}{e}{w} Move 1 Space North, South, East, or West || {q} Quit");
    }

    public static void statusReport(Player player) {
        //prints out the stats of the player
        System.out.println(player);
    }

    public static void move(Player player) {
        //initialize variables
        Random rand = new Random();
        int scene;
        int move = rand.nextInt(5);
        //selection structure for if the player gets into a fight or continues moving
        if (move == 0) {
            //the player gets into a fight and goes through the fight() method
            fight(player);
        } else {
            //the player sees one of 4 scenes in front of them
            scene = rand.nextInt(4);
            switch (scene) {
                case 0:
                    System.out.println("********************\nNothing here...\n********************");
                    break;
                case 1:
                    System.out.println("********************\nNice trees around here...\n********************");
                    break;
                case 2:
                    System.out.println("********************\nInteresting cottage there...\n********************");
                    break;
                default:
                    System.out.println("********************\nPotty break...\n********************");
                    break;
            }
        }
    }

    public static void fight(Player player) {
        //create new random
        Random rand = new Random();
        int fight = rand.nextInt(3);
        String enemy = "";
        //determines which enemy the player is fighting
        switch (fight) {
            case 0:
                enemy = "zombie";
                break;
            case 1:
                enemy = "bandit";
                break;
            case 2:
                enemy = "lobbyist";
                break;
            default:
                break;
        }
        System.out.println("Oh no! You're being attacked by a " + enemy + "!");
        //moves onto the actual fighting by going into the fightMenu() method
        fightMenu(player, enemy);

    }

    public static void fightMenu(Player player, String enemy) {
        //creating variables
        Scanner input = new Scanner(System.in);
        Scanner battle = new Scanner(System.in);
        String choice;
        Random run = new Random();
        Random fight = new Random();
        int success;
        int fighting;
        String fightStart;

        //asking if the player wants to fight or run
        System.out.println("How would you like to handle this?");
        System.out.println("{s}Special Move || {r}Run!");
        choice = input.next().toLowerCase();
        //if the player chooses to fight using their classes special move
        if (choice.equals("s")) {
            System.out.println("Prepare for battle!");
            System.out.println("Press any key then ENTER to continue");
            fightStart = battle.next();
            System.out.println("***********************************");
            player.getSpecialMove();
            fighting = fight.nextInt(5);
            //selection structure to determine whether the player wins or the enemy
            if (fighting == 0 || fighting == 1 || fighting == 2) {
                System.out.println("Player wins! Increasing score by 2 points!");
                player.increaseScore();
            } else {
                System.out.println("The " + enemy + " wins...");
                System.out.println("You've taken 1 dmg...");
                player.decreaseHealth();
            }
            //if the player chooses to run from the fight
        } else if (choice.equals("r")) {
            success = run.nextInt(2);
            if (success == 0) {
                System.out.println("During your escape you were hit!\nYou took 1 dmg!");
                player.decreaseHealth();
            } else {
                System.out.println("You got away safely!");
            }
        }
    }

}
