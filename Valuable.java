import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class Valuable here.
 * 
 * @author (your name), Jean 
 * @version (a version number or a date)
 */
public class Valuable extends Actor
{
    private GreenfootImage image;
    private int price;
    private boolean isStolen;
    
    /**
     * A simple constructor that sets Right the stolen state and the price of a valuable
     * 
     * @param price   The price of this valuable
     */
    public Valuable(GreenfootImage image, int price){
        this.image = image;
        this.price = price;
        isStolen = false;
        
        setImage(image);
    }

    public void act()
    {
        
    }

    /**
     * called by other class to steal this valuable
     * 
     */
    public void setStolen(boolean b){
        isStolen = b;
    }
    
    //follow the robber after i have been stolen
    public void followRobber(Robber robber){
        int yOffset;
        int xOffset;
        switch(robber.getDirection()){
            case 1:
                //facing right
                yOffset = robber.getY();
                xOffset = robber.getX() + robber.getImage().getWidth()/2;
                setLocation(xOffset, yOffset);
                break;
            case 2:
                //facing up
                yOffset = robber.getY() - robber.getImage().getHeight()/2;
                xOffset = robber.getX();
                setLocation(xOffset, yOffset);
                break;
            case 3:
                //facing left
                yOffset = robber.getY();
                xOffset = robber.getX() - robber.getImage().getWidth()/2;
                setLocation(xOffset, yOffset);
                break;
            case 4:
                //facing down
                yOffset = robber.getY() + robber.getImage().getHeight()/2;
                xOffset = robber.getX();
                setLocation(xOffset, yOffset);
                break;
        }
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
     *  @return int price of this valuable
     */
    public int getPrice(){
        return this.price;
    }

}
