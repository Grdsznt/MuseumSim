import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Valuable Pots.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class AntiquePotTall extends Valuable
{
    public final static int price = 5000;
    
    public AntiquePotTall(){
        //Set the image, and set the price to $5000
        super(new GreenfootImage("valuableArtPot.png"), price);
    }
}
