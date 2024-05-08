import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The start screen that introduces us to the simulation
 * Interactions:
 * Robber steals valuables
 * Guards catch robbers
 *  If the robber is caught, the valuable goes back to it's original slot
 * Valuables have special code to follow the robbers to seem like it's bringing it along
 * Guards, visitors and robbers are stopped by obstacles - they cannot move through them
 *  Robbers factor obstacles and guards in when calculating the path to steal the valuable
 *  Guards move until they hit an obstacle then move in the other direction
 *  Visitors randomly chose a tile to move to that is not covered by an obstacle
 * The sliders transfer to instance variables in the room, and how these variables change will affect the type of endscreen
 *
 * <h2>Images
 * <p>Antique Pot Short: https://www.christies.com/en/lot/lot-6084737
 * <p>Antique Pot Tall: https://www.cleveland.com/metro/2021/12/valuable-artifacts-considered-stolen-being-returned-to-italy-including-items-from-cleveland-museum-of-art.html
 * <p>Antique Tea Pot: https://www.amazon.ca/Blossom-Antique-Handmade-Kung-fu-Drinkware/dp/B0C7TLPK4Y
 * <p>Mona Lisa: https://www.arsmundi.de/en/service/our-art-report/the-secrets-behind-the-mona-lisa/
 * <p>Painting Man: Lavoie, https://www.historymuseum.ca/collections/artifact/2269907
 * <p>Icons: https://penzilla.itch.io/vector-icon-pack 
 * <p>Museum: https://limezu.itch.io/moderninteriors
 * 
 * <h2>Sounds
 * <p>Night time ambience: https://pixabay.com/sound-effects/the-ambience-room-tone-139064/
 * <p>Cash sound: https://www.youtube.com/watch?v=4kVTqUxJYBA 
 * @author Nick, Jean, Jerry, Edwin
 * @version May 2 2024
 */
public class StartWorld extends World
{    
    private StartButton startGame;
    private SettingsButton settings;
    private Button story;
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

    public static SuperSound music = new SuperSound("startMenuBGM.mp3");
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
        prepare();
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
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
