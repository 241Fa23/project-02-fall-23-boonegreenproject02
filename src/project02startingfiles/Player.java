/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project02startingfiles;

/**
 *
 * @author s543427
 */
public abstract class Player {

    private int health;
    private int score;
    
    public Player(){
        this.health = 10;
        this.score = 0;
    }
    
    public abstract String getSpecialMove();
    
    public abstract void useSpecialMove();
    
    public int getHealth(){
        return health;
    }
    
    public int getScore(){
        return score;
    }
    
    public void decreaseHealth(){
        health--;
    }
    
    public void increaseScore(){
        score++;
    }
    
    //add to String (don't know if need)
}
