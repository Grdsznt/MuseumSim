import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public Valuable(double price){
        this.price = price;
        isStolen = false;
    }
    public void act()
    {
        // Add your action code here.
    }
    public boolean isStolen(){
        return this.isStolen;
    }
}
