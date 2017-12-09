/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.Random;

/**
 * This player gets the next column with a random number generator
 * @author ammarasmro
 */
public class EasyPlayer extends ComputerizedPlayer {
    
    public EasyPlayer(String playerName) {
        super(playerName);
    }
    
    
    @Override
    public int ratePlaces(MainGrid grid){
        Random rand = new Random();
        int  n = rand.nextInt(6);
        return n;
    }
    
}
