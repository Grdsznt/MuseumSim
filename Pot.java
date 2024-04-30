import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the valuables.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class Pot extends Valuable
{
    public Pot(){
        super("PinkPot.png");
    }
    public void act(){
        // Add your action code here.
        //Set the image, and set the price to $100
        super(new GreenfootImage("PinkPot.png"), 500);
    }
}
