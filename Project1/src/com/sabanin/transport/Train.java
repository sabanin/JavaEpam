/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Евгений
 */
public class Train {
    protected int number;
    protected List<OneStop> stantions;
    protected List<Integer> departureDays;
    protected List<Wagon> wagons;
    
    public Train(){
        this.number = 0;
        wagons = new ArrayList<Wagon>();
        stantions = new ArrayList<OneStop>();
        departureDays = new ArrayList<Integer>();
    }
    
    public Train(int trainNumber, ArrayList<Integer> daysOfDeparture){
        number = trainNumber;
        departureDays = new ArrayList<Integer>(daysOfDeparture);
    }
    
    public void addWagon(Wagon wagon){
        wagons.add(wagon);
    }
    
    public List<Wagon> getWagons(){
        return wagons;
    }
    
     public void addStation(String name, int dayOfArrive, int hourOfArrive, int minuteOfArrive, 
            int hourOfDepart, int minuteOfDepart, int priceFromDispathStation){
        stantions.add(new OneStop(name, dayOfArrive, hourOfArrive, minuteOfArrive, 
            hourOfDepart, minuteOfDepart, priceFromDispathStation));
    }
    
    public boolean isPasses(String departureStation, String arrivalStation, int day){
        boolean departureFound = false;
        boolean arrivalFound = false;       
        int departureID = returnStationNumber(departureStation);
        int arrivalID = returnStationNumber(arrivalStation);
        if ((departureID != -1) && (arrivalID != -1) && (departureID < arrivalID)){
            return true;
        }
        return false;
    }
    
    public int findPrice(String departureStation, String arrivalStation){
        int departureID = returnStationNumber(departureStation);
        int arrivalID = returnStationNumber(arrivalStation);
        if ((departureID == -1) || (arrivalID == -1)){
            //throw exception
        }
        return (stantions.get(arrivalID).priceFromDispathStation 
                    - stantions.get(departureID).priceFromDispathStation);
    }
    
    protected int returnStationNumber(String stationName){
        for (int i = 0; i < stantions.size(); i++){
            if (stantions.get(i).name.equals(stationName)){
                return i;
            }
        }
        return -1;
    }
    
    protected int getNumber(){
        return this.number;
    }
    
    
    @Override
    public boolean equals(Object object){
        Train train= (Train) object;
        return (train.getNumber() == this.number);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.number;
        hash = 79 * hash + Objects.hashCode(this.stantions);
        hash = 79 * hash + Objects.hashCode(this.departureDays);
        hash = 79 * hash + Objects.hashCode(this.wagons);
        return hash;
    }
}
class OneStop{
    String name;
    int dayOfArrive; /* counting start from departure day */
    int hourOfArrive;
    int minuteOfArrive;
    int hourOfDepart;
    int minuteOfDepart;
    int priceFromDispathStation;
    
    OneStop(String name, int dayOfArrive, int hourOfArrive, int minuteOfArrive, 
            int hourOfDepart, int minuteOfDepart, int priceFromDispathStation){
        this.name = new String(name);
        this.dayOfArrive = dayOfArrive;
        this.hourOfArrive = hourOfArrive;
        this.minuteOfArrive = minuteOfArrive;
        this.hourOfDepart = hourOfDepart;
        this.minuteOfDepart = minuteOfDepart;
        this.priceFromDispathStation = priceFromDispathStation;
    }
}