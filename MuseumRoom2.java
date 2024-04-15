import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuseumRoom2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuseumRoom2 extends Room
{

    /**
     * Constructor for objects of class MuseumRoom2.
     * 
     */
    private GreenfootImage worldImage = new GreenfootImage("room2.png");
    private Object obj1 = new Object(84, 49); //  (285, 723), (369, 674)
    private Object obj2 = new Object(73, 64); // (144, 544), (217, 480)
    private Object obj3 = new Object(85, 118); // (283, 272), (368, 154) //broken glass
    private Object obj4 = new Object(31, 43); // (76, 140), (107, 97) // little top right box
    
    public MuseumRoom2()
    { 
        super(661,816,0, 0);
        setBackground(worldImage);
        
    }
}
