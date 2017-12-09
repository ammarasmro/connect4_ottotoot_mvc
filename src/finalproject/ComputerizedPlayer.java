/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * An abstract class representing the basis for a computerized player for other players to inherit from
 * @author ammarasmro
 */
public abstract class ComputerizedPlayer extends Player {
    protected ArrayList<Disc> winningListForSelf;
    protected ArrayList<Disc> winningListForOpponent;
    
    public ComputerizedPlayer(String playerName) {
        super(playerName);
    }
    
    @Override
    public void play(GamePlay gamePlay){
        System.out.println("Computer is playing");
        winningListForSelf = gamePlay.winningTwo;
        winningListForOpponent = gamePlay.winningOne;
        if(!gamePlay.playTurn(ratePlaces(gamePlay.getGrid())))
            gamePlay.playTurn(ratePlaces(gamePlay.getGrid()));
    }
    
    public abstract int ratePlaces(MainGrid grid);
    
}
