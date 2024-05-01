import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the valuables.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class SilverPot extends Valuable
{
    public final static int price = 700;
    
    public SilverPot(){
        //Set the image, and set the price to $700
        super(new GreenfootImage("SilverPot.png"), price);
    }
}
