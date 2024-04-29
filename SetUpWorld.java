import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SetUpWorld here.
 * 
 * @author Jerry, Jean Pan
 * @version (a version number or a date)
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
    //Set the button for spawn rate of robber
    private OptionButton spawnRateRobberButton;
    
    /**
     * Constructor for objects of class SetUpWorld.
     * 
     */
    public SetUpWorld(StartWorld sw)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        
        String[] tempTextGuards = {"Number Of Guards"};
        SuperTextBox editNumOfGuards = new SuperTextBox(tempTextGuards, Color.BLACK, Color.WHITE, boringFont, true, 300, 3, Color.YELLOW);
        
        editNumOfGuards.update();
        int tempY = getHeight() - editNumOfGuards.getImage().getHeight()/2;
        int tempX = editNumOfGuards.getImage().getWidth()/2;
        addObject(editNumOfGuards, tempX, tempY);
        
        homeButton = new HomeButton("home", 3, sw);
        homeButton.setScale(130, 75);
        addObject(homeButton, 75, 50);
        Button.init();
        
        setBackground(backGround1);
        
        //Set the buttons for guards, robbers, and valuables
        guardButton = new OptionButton("Number of Guards in World: ", 1, 3);
        robberButton = new OptionButton("Number of Robbers in World: ", 1, 3);
        valuableButton = new OptionButton("Number of Valuables in World: ", 2, 7);
        //Set the button for spawn rate of robber
        spawnRateRobberButton = new OptionButton("Spawn Rate of Robbers per 10s: ", 1, 5);
        
        //Add these buttons onto the world
        addObject(guardButton, getWidth()/2, getHeight()/9*3);
        addObject(robberButton, getWidth()/2, getHeight()/9*4);
        addObject(valuableButton, getWidth()/2, getHeight()/9*5);
        addObject(spawnRateRobberButton, getWidth()/2, getHeight()/9*6);
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
