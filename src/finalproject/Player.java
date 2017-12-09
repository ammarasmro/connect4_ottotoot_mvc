/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 * General class for all players
 * 
 *
 * @author ammarasmro
 */
public class Player {
    private String playerName;
    private Disc discType;
    
    public Player(String playerName){
        this.playerName = playerName;
    }
    
    /**
     * Sets the disc type that this player carries
     * Same as in picking a disc to play in real life
     * 
     * @param disc 
     * 
     */
    public void setDiscTypeForPlayer(Disc disc){
        this.discType = disc;
    }
    
    /**
     * 
     * @return diskType: The disk type that this user carries
     */
    public Disc getDiscTypeForPlayer(){
        return discType;
    }
    
    public String getName(){
        return playerName;
    }

    /**
     * A dummy method here but an essential one in the subclasses
     * 
     * @param gamePlay contains the grid and game status
     */
    void play(GamePlay gamePlay) {
        System.out.println(getName() + " is playing!");
    }
    
    @Override
    public String toString(){
        return getName();
    }
}
