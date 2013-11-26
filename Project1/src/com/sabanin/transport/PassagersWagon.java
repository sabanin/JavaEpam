/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.transport;

/**
 *
 * @author Евгений
 */
public class PassagersWagon implements Wagon{
    protected int id;
    protected int numberOfSeats;
    protected int comfortLevel;
    protected String type;
    
    public PassagersWagon(int id, int numberOfSeats,int comfortLevel){
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.comfortLevel = comfortLevel;
        type = "Passagers";
    }
    
    @Override
    public int getComfort(){
        return comfortLevel;
    }
    
    @Override
    public String getType(){
        return type;
    }
    
    @Override
    public int getPassagers(){
        return numberOfSeats;
    }
    
    @Override
    public int getCapacity(){
        return 0;
    }
}
