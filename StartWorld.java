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
    // private GreenfootImage img = new GreenfootImage("");
    //private GreenfootImage img = new GreenfootImage("");

    private Button b;
    private Button startGame;
    private Button settings;
    private Button story;
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

    public static GreenfootSound music = new GreenfootSound("startMenuBGM.mp3");
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
        startGame = new Button("startButton", 3);
        addObject(startGame, 500, 400);
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
                Greenfoot.setWorld(new SetUpWorld());
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
