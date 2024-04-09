import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Room extends World
{
    protected int width;
    protected int height;
    protected int amountOfObjects;
    protected int income;

    /**
     * Constructor for objects of class Room.
     * 
     */
    public Room(int wid, int hei, int aOfO, int inc) {
        super(600, 400, 1);
        width = wid;
        height = hei;
        amountOfObjects = aOfO;
        income = inc;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getAmountOfObjects() {
        return amountOfObjects;
    }
    
    public int getIncome() {
        return income;
    }
}
