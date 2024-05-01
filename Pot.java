import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the valuables.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class Pot extends Valuable
{
    public final static int price = 500;
    
    public Pot(){
        //Set the image, and set the price to $100
        super(new GreenfootImage("PinkPot.png"), 500);
    }
}