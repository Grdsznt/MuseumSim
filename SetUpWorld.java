import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A setting screen for the user to adjust some values.
 * 
 * @author Jerry, Jean Pan
 * @version Apr 2024
 */
public class SetUpWorld extends World
{
    private Color white = Color.WHITE;
    private Color black = Color.BLACK;
    private Font boringFont = new Font ("Joystix", false, false, 18);
    private static GreenfootImage backGround1 = new GreenfootImage("museumFrontPage1.png");
    private HomeButton homeButton;
    
    //Set the buttons for guards, robbers, and valuables
    private OptionButton guardButton;
    private OptionButton robberButton;
    private OptionButton valuableButton;
    private Slider guardSlider;
    //Set the button for spawn rate of robber
    private OptionButton spawnRateRobberButton;
    //Set the button for spawn rate of visitor
    private OptionButton spawnRateVisitorButton;
    
    /**
     * Constructor for objects of class SetUpWorld.
     * 
     */
    public SetUpWorld(StartWorld sw)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        homeButton = new HomeButton("home", 3, sw);
        homeButton.setScale(130, 75);
        addObject(homeButton, 75, 50);
        Button.init();
        
        setBackground(backGround1);
        
        //Set the buttons for guards, robbers, and valuables
        guardButton = new OptionButton("Number of Guards in World: ", 1, 3);
        guardSlider = new Slider(125, 500, 1, 3, true);
        addObject(guardSlider, getWidth()/2, getHeight()/10*3);
        robberButton = new OptionButton("Number of Robbers in World: ", 1, 3);
        valuableButton = new OptionButton("Number of Valuables in World: ", 2, 7);
        //Set the button for spawn rate of robber
        spawnRateRobberButton = new OptionButton("Spawn Rate of Robbers per 10s: ", 1, 5);
        //Set the button for spawn rate of visitor
        spawnRateVisitorButton = new OptionButton("Spawn Rate of Visitors per 10s: ", 3, 10);
        /*
        //Add these buttons onto the world
        addObject(guardButton, getWidth()/2, getHeight()/10*3);
        addObject(robberButton, getWidth()/2, getHeight()/10*4);
        addObject(valuableButton, getWidth()/2, getHeight()/10*5);
        addObject(spawnRateRobberButton, getWidth()/2, getHeight()/10*6);
        addObject(spawnRateVisitorButton, getWidth()/2, getHeight()/10*7);
        */
    }
    
    /**
     * Return the number of guards set by the user.
     */
    public int getNumberOfGuards(){
        return guardButton.getValue();
    }
    
    /**
     * Return the number of robbers set by the user.
     */
    public int getNumberOfRobbers(){
        return robberButton.getValue();
    }
    
    /**
     * Return the number of valuables set by the user.
     */
    public int getNumberOfValuables(){
        return valuableButton.getValue();
    }
    
    public int getSpawnRate() {
        return spawnRateRobberButton.getValue();
    }
}
