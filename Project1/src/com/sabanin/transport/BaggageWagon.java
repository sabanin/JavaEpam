/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.transport;

/**
 *
 * @author Евгений
 */
public class BaggageWagon implements Wagon{
    protected int id;
    protected int capacity;
    protected String type;
    
    public BaggageWagon(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
        type = "Baggage";
    }
    
    @Override
    public int getComfort(){
        return 0;
    }
    
    @Override
    public String getType(){
        return type;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
        
    
    @Override
    public int getPassagers() {
        return 0;
    }
}
