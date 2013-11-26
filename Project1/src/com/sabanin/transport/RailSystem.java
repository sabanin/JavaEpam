/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author Евгений
 */
public class RailSystem {
    protected List<Train> trains;
    
    public RailSystem(){
        trains = new ArrayList<>();
    }
    
    protected Comparator comparatorByComfort = new Comparator<Wagon>() { 
            public int compare(Wagon a, Wagon b) {
            return (a.getComfort() - b.getComfort());  
            }
    };
    
    public List<Wagon> sortByComfort(Train train){
        List<Wagon> wagons = new ArrayList<>(train.getWagons());
        Collections.sort(wagons, comparatorByComfort);
        for(Wagon i:wagons){
            if (i.getType().equals("Baggage")) wagons.remove(i);
        }
        return wagons;
    }
    
    public int getNumberOfPassagers(Train train){
        int result = 0;
        List<Wagon> wagons = new ArrayList<>(train.getWagons());
        for (Wagon i:wagons){
            result += i.getPassagers();
        }
        return result;
    }
    
    public int getCapacity(Train train){
        int result = 0;
        List<Wagon> wagons = new ArrayList<>(train.getWagons());
        for (Wagon i:wagons){
            result += i.getCapacity();
        }
        return result;
    }
    
    public List<Wagon> getRangeSeatsWagons(Train train, int minSeats, int maxSeats){
        List<Wagon> result= new ArrayList<>();
        List<Wagon> wagons = new ArrayList<>(train.getWagons());
        for (Wagon i:wagons){
            if ((i.getType().equals("Passagers")) && (i.getPassagers() > minSeats)
                    && (i.getPassagers() < maxSeats)){
                result.add(i);
            }
        }
        return result;
    }
}
