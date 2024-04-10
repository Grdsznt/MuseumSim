import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class Valuable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Valuable extends Object
{
    /**
     * Act - do whatever the Valuable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private double price;
    private boolean isStolen;
    /**
     * A simple constructor that sets Right the stolen state and the price of a valuable
     * 
     * @param price   The price of this valuable
     */
    public Valuable(double price){
        this.price = price;
        isStolen = false;
    }
    public void act()
    {
        // Add your action code here.
    }
    /**
     * called by other class to steal this valuable
     * 
     */
    public void stealMe(){
        isStolen = true;
    }
    /**
     * returns the state of this valuable
     *  @return true if is stolen, false if it's not
     */
    public boolean isStolen(){
        return this.isStolen;
    }
    /**
     * returns the price of this valuable
     *  @return double price of this valuable
     */
    public double getPrice(){
        return this.price;
    }

}
