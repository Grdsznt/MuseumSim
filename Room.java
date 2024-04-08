import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Room extends Actor
{
    protected int width;
    protected int height;
    protected int amountOfObjects;
    protected int income;
    public Room(int wid, int hei, int aOfO, int inc) {
        width = wid;
        height = hei;
        amountOfObjects = aOfO;
        income = inc;
    }
    
    /**
     * Act - do whatever the Room wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
