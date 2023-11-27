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
        Scanner inputClass = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        String userClass;
        String choice;

        System.out.println("Welcome to JavaQuest!");
        System.out.println("Stay alive and increase your score!");
        System.out.println("Choose a character...");
        System.out.println("{k}Knight || {h} Healer || {w}Wizard || {t}Thief");
        userClass = inputClass.next().toLowerCase();
        //set the players class to what they asked for

        menu();
        choice = input.next().toLowerCase();

        while (!choice.equals("q")) {
            if (choice.equals("?")) {
                statusReport();
            } else if (choice.equals("n") || choice.equals("s") || choice.equals("e") || choice.equals("w")) {
                move();
            } else {
                System.out.println("You can't do that traveller... Try again!");
            }
            menu();
            choice = input.next();
        }
        System.out.println("*************************\n*************************");
        System.out.println("The game has come to an end! Your final stats were:\n");
        //print out character status
    }

    public static void menu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("{?}Status Report || {n}{s}{e}{w} Move 1 Space North, South, East, or West || {q} Quit");
    }

    public static void statusReport() {

    }

    public static void move() {
        Random rand = new Random();
        int scene;
        int move = rand.nextInt(5);
        if (move == 0) {
            fight();
        } else {
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

    public static void fight() {
        Random rand = new Random();
        int fight = rand.nextInt(3);
        String enemy = "";
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
        fightMenu();

    }

    public static void fightMenu() {
        Scanner input = new Scanner(System.in);
        Scanner battle = new Scanner(System.in);
        String choice;
        Random run = new Random();
        int success;
        String fighting;
        System.out.println("How would you like to handle this?");
        System.out.println("{s}Special Move || {r}Run!");
        choice = input.next().toLowerCase();
        if (choice.equals("s")) {
            System.out.println("Prepare for battle!");
            System.out.println("Press any key then ENTER to continue");
            fighting = battle.next();
            System.out.println("***********************************");
            //call up special move of character class to use
            //player has 60% chance to win battle
            //if they lose the battle, player health -= 1 //I created method decreaseHealth
            //if they win the battle, player score += 2 //I created increaseScore method
        } else if (choice.equals("r")) {
            success = run.nextInt(2);
            if (success == 0) {
                System.out.println("During your escape you were hit!\nYou took 1 dmg!");
                //player health -= 1
            } else {
                System.out.println("You got away safely! \nYouv'e gained 1 point!");
                //player score += 1
            }
        }
    }

}
