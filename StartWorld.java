import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A start image to introduce the game
 * 
 * @author Nick, Jean, Jerry
 * @version (a version number or a date)
 */
public class StartWorld extends World
{    
    private StartButton startGame;
    private SettingsButton settings;
    private Button story;
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

    public static GreenfootSound music = new GreenfootSound("startMenuBGM.mp3");
    private static GreenfootImage backGround1 = new GreenfootImage("museumFrontPage1.png");
    private static GreenfootImage backGround2 = new GreenfootImage("museumFrontPage2.png");

    //private GreenfootImage img = new GreenfootImage("");
    private int actNum;
    private boolean currentBGframe;//true is frame 1, false is frame 2
    
    private SetUpWorld setup = new SetUpWorld(this);
    
    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld(){    
        super(1000,800,1);
        setBackground(backGround1);
        actNum = 0;
        currentBGframe = true;
        startGame = new StartButton("startButton", 3);
        addObject(startGame, 500, 600);
        settings = new SettingsButton("settingsButton", 3, setup);
        addObject(settings, 500, 700);
        Button.init();
        
        //Load the animation images for the Guard
        Guard.loadAnimationImages();
        //Set paint order to put the detector under the guard
        setPaintOrder(Detector.class, Guard.class);
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
            if(Greenfoot.mouseClicked(settings)){
                music.pause();
                Button.playClickSound();
                Greenfoot.setWorld(setup);
            }
        }
        actNum++;
    }
    
    public SetUpWorld getSetUp() {
        return setup;
    }
    public void started(){
        music.playLoop();
    }

    public void stopped(){
        music.pause();
    }
}
