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
     * @param image   The image of this valuable 
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
     * Called by other class to steal this valuable
     * 
     * @param b     Sets whether this valuable is stolen or not
     */
    public void setStolen(boolean b){
        isStolen = b;
    }
    
    /** 
     * followRobber is a method that is used to make this valuable follow the robbers movements when a valuable is being stolen
     * 
     * @param robber    The robber that this valuable will follow around
     */
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
     * Returns the state of this valuable
     *  @return true if is stolen, false if it's not
     */
    public boolean isStolen(){
        return this.isStolen;
    }

    /**
     * Returns the price of this valuable
     *  @return int price of this valuable
     */
    public int getPrice(){
        return this.price;
    }

}
