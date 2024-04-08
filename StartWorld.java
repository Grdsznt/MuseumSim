import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{

    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    
<<<<<<< HEAD
    // private GreenfootImage img = new GreenfootImage("");
=======
    //private GreenfootImage img = new GreenfootImage("");
>>>>>>> main
    private Button b;
    public StartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
<<<<<<< HEAD
        super(1536, 864, 1); // 1080x1920 80%
        // b = new Button();
        
=======
        super(600, 400, 1); 
        b = new Button();
        addObject(new MuseumRoom(600, 700, 400, 3), 0, 0);
>>>>>>> main
    }
}
