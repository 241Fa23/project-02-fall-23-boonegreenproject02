/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project02startingfiles;

/**
 *
 * @author S540473
 */
public class Knight extends Player {

    @Override
    public String getSpecialMove(){
        return "Slash with Sword";
    }
    
    @Override
    public void useSpecialMove(){
        System.out.println("The Knight slashes with sword1");
    }
    @Override
    public String toString(){
        return "Knight Status: \n" + super.toString() +"\nThe Knight's special move is 'Slash with Sword'";
    }
}
