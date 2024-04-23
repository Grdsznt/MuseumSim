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
    private HomeButton homeButton;
    
    //Set the buttons for guards, robbers, and valuables
    private OptionButton guardButton;
    private OptionButton robberButton;
    private OptionButton valuableButton;
    
    /**
     * Constructor for objects of class SetUpWorld.
     * 
     */
    public SetUpWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        
        String[] tempTextGuards = {"Number Of Guards"};
        SuperTextBox editNumOfGuards = new SuperTextBox(tempTextGuards, Color.BLACK, Color.WHITE, boringFont, true, 300, 3, Color.YELLOW);
        
        editNumOfGuards.update();
        int tempY = getHeight() - editNumOfGuards.getImage().getHeight()/2;
        int tempX = editNumOfGuards.getImage().getWidth()/2;
        addObject(editNumOfGuards, tempX, tempY);
        
        homeButton = new HomeButton("home", 3);
        homeButton.setScale(130, 75);
        addObject(homeButton, 75, 50);
        Button.init();
        
        
        
        //Set the buttons for guards, robbers, and valuables
        guardButton = new OptionButton("Number of Guards in World: ", 1, 10);
        robberButton = new OptionButton("Number of Robbers in World: ", 1, 10);
        valuableButton = new OptionButton("Number of Valuables in World: ", 5, 20);
        
        //Add these buttons onto the world
        addObject(guardButton, getWidth()/2, getHeight()/8*3);
        addObject(robberButton, getWidth()/2, getHeight()/8*4);
        addObject(valuableButton, getWidth()/2, getHeight()/8*5);
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
}
