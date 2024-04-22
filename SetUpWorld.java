import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SetUpWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SetUpWorld extends World
{
    private Color white = Color.WHITE;
    private Color black = Color.BLACK;
    private Font boringFont = new Font ("Joystix", false, false, 18);
    private HomeButton homeButton;
    
    private int numberOfRobbers = 1;
    private int numberOfGuards = 1;
    private int numberOfValubles = 3;
    private int startingCurrency = 10;
    
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
        
        Slider numOfGuardsSlider = new Slider();
        numOfGuardsSlider.setMaximumValue(3);
        numOfGuardsSlider.showPercentage(false);
        numOfGuardsSlider.showValue(true);
        numOfGuardsSlider.setMinorSections(1);
        addObject(numOfGuardsSlider, 500, 400);
        
        
        
        
        //Home Button
        homeButton = new HomeButton("home", 3);
        homeButton.setScale(130, 75);
        addObject(homeButton, 75, 50);
        Button.init();
    }
    
    public void started() {
        StartWorld.music.playLoop();
    }
    
    public void stopped() {
        StartWorld.music.pause();
    }
}
