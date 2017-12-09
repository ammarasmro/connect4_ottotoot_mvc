/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.Objects;
import javafx.scene.paint.Color;

/**
 * A flexible and handy disc class that can be used by various games
 * @author ammarasmro
 */
public class Disc implements DiscInt{
    private String label;
    private Color color;
    private boolean labelVisibility;
    private boolean active;
    private Coordinates coordinates;
    
    public Disc(int x, int y){
        this.color = Color.TRANSPARENT;
        this.label = "";
        this.labelVisibility = false;
        this.active = false;
        this.coordinates = new Coordinates(x,y);
    }
    
    public Disc(Color color, String label){
        this.color = color;
        this.label = label;
    }
    
    public Coordinates getCoordinates(){
        return coordinates;
    }
    
    public boolean isLabelVisible(){
        return labelVisibility;
    }
    
    @Override
    public void setColor(Color color){
        this.color = color;
    }
    
    public Color getColor(){
        return color;
    }
    
    @Override
    public void setLabel(String label){
        this.label = label;
    }
    
    public void activate(){
        this.active = true;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public boolean isEmpty(){
        return label.isEmpty();
    }
    
    @Override
    public String toString(){
        return getLabel() + " ";
    }

    @Override
    public void setLabelVisibility(boolean activeLabel) {
        this.labelVisibility = activeLabel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disc other = (Disc) obj;
        if (!Objects.equals(this.label, other.label)) {
            return false;
        }
        return true;
    }
    
    
}
