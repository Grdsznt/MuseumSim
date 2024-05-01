import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the valuables.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class GoldPot extends Valuable
{
    public final static int price = 900;
    
    public GoldPot(){
        //Set the image, and set the price to $900
        super(new GreenfootImage("GoldPot.png"), price);
    }
}
