import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * A start image to introduce the game
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
=======
    private static GreenfootSound music = new GreenfootSound("startMenuBGM.mp3");
    private static GreenfootImage backGround1 = new GreenfootImage("museumFrontPage1.png");
    private static GreenfootImage backGround2 = new GreenfootImage("museumFrontPage2.png");

    //private GreenfootImage img = new GreenfootImage("");
    private int actNum;
    private boolean currentBGframe;//true is frame 1, false is frame 2
    public StartWorld(){    
        super(1000,800,1);
        setBackground(backGround1);
        actNum = 0;
        currentBGframe = true;
>>>>>>> main
    }

    public void act(){
        //switch between frame 1 and 2
        if(actNum % 60 == 0){
            currentBGframe = (currentBGframe)? false : true;
            setBackground((currentBGframe)? backGround1: backGround2);
        }
        //check if a key is clicked

        if(actNum > 15){
            //String keyPressed = Greenfoot.getKey();
            if(Greenfoot.mouseClicked(this)){
                music.pause();
                Greenfoot.setWorld(new SetUp());
            }
        }
        actNum++;
    }

    public void started(){
        music.playLoop();
    }

    public void stopped(){
        music.pause();
    }

}
