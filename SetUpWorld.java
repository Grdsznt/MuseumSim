import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A setting screen for the user to adjust some values.
 * 
 * @author Jerry, Jean Pan, Edwin，Nick
 * @version Apr 2024
 */
public class SetUpWorld extends World
{
    private Color white = Color.WHITE;
    private Color black = Color.BLACK;
    private Font boringFont = new Font ("Pixel", false, false, 18);
    private static GreenfootImage backGround1 = new GreenfootImage("settingsBackground.png");
    private HomeButton homeButton;
    
    //Set the SuperTextBoxes for guards, robbers, valuables, spawnrates, and day limit
    private SuperTextBox guardText;
    private SuperTextBox robberText;
    private SuperTextBox valuableText;
    private SuperTextBox spawnRateRobberText;
    private SuperTextBox spawnRateVisitorText;
    private SuperTextBox dayLimitText;
    
    //Set the Sliders for guards, robbers, valuables, spawnrates, and day limit
    private Slider guardSlider;
    private Slider robberSlider;
    // private Slider valuableSlider;
    private Slider spawnRateRobberSlider;
    private Slider spawnRateVisitorSlider;
    private Slider dayLimitSlider;
    private Color BROWN;
    private Color LIGHT_BROWN;
    
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
        BROWN = new Color(78,53,36);
        LIGHT_BROWN = new Color(189,154,122);
        setBackground(backGround1);
        
        String[] guardTextContent = {"Number of Guards in World: " + 1};
        String[] robberTextContent = {"Number of Robbers in World: " + 1};
        String[] valuableTextContent = {"Number of Valuables in World: " + 1};
        String[] spawnRateRobberTextContent = {"Spawn Rate of Robbers per 20s: " + 1};
        String[] spawnRateVisitorTextContent = {"Spawn Rate of Visitors per 10s: " + 3};
        String[] dayLimitTextContent = {"Number of Days: " + 3};
        
        guardText = new SuperTextBox(guardTextContent, BROWN, Color.WHITE, boringFont, true, 350, 5, LIGHT_BROWN);
        
        robberText = new SuperTextBox(robberTextContent, BROWN, Color.WHITE, boringFont, true, 350, 5, LIGHT_BROWN);
        
        spawnRateRobberText = new SuperTextBox(spawnRateRobberTextContent, BROWN, Color.WHITE, boringFont, true, 350, 5, LIGHT_BROWN);
        
        spawnRateVisitorText = new SuperTextBox(spawnRateVisitorTextContent, BROWN, Color.WHITE, boringFont, true, 350, 5, LIGHT_BROWN);
        
        dayLimitText = new SuperTextBox(dayLimitTextContent, BROWN, Color.WHITE, boringFont, true, 350, 5, LIGHT_BROWN);
        //Set up all the sliders
        
        //Set up the guard slider
        guardSlider = new Slider("Number of Guards in World: ", guardText, 1);
        guardSlider.showPercentage(false);
        guardSlider.setMaximumValue(2); // Guard can have a value between 1-3
        guardSlider.setValue(0); //Set the value to the lower bound
        guardSlider.setMinorSections(0); //Remove the little notches on the slider
        guardText.update(); //Update the SuperTextBox
        addObject(guardSlider, getWidth()/2+200, getHeight()/10*3);
        
        //Set up the robber slider
        robberSlider = new Slider("Number of Robbers in World: ", robberText, 1);
        robberSlider.showPercentage(false);
        robberSlider.setMaximumValue(2);
        robberSlider.setValue(0); //Set the value to the lower bound
        robberSlider.setMinorSections(0); //Remove the little notches on the slider
        robberText.update(); //Update the SuperTextBox
        addObject(robberSlider, getWidth()/2+200, getHeight()/10*4);
        
        //Set up the robber spawn rate slider
        spawnRateRobberSlider = new Slider("Spawn Rate of Robbers per 20s: ", spawnRateRobberText, 2);
        spawnRateRobberSlider.showPercentage(false);
        spawnRateRobberSlider.setMaximumValue(5);
        spawnRateRobberSlider.setValue(0); //Set the value to the lower bound
        spawnRateRobberSlider.setMinorSections(0);
        spawnRateRobberText.update();
        addObject(spawnRateRobberSlider, getWidth()/2+200, getHeight()/10*5);
        
        //Set up the visitor spawn rate slider
        spawnRateVisitorSlider = new Slider("Spawn Rate of Visitors per 10s: ", spawnRateVisitorText, 3);
        spawnRateVisitorSlider.showPercentage(false);
        spawnRateVisitorSlider.setMaximumValue(7); //This slider can give a value between 3 and 10
        spawnRateVisitorSlider.setValue(0); //Set the value to the lower bound
        spawnRateVisitorSlider.setMinorSections(0);
        spawnRateVisitorText.update(); //Update the SuperTextBox
        addObject(spawnRateVisitorSlider, getWidth()/2+200, getHeight()/10*6);
        
        //Set up the day limit slider
        dayLimitSlider = new Slider("Number of Days: ", dayLimitText, 3);
        dayLimitSlider.showPercentage(false);
        dayLimitSlider.setMaximumValue(7); //There can be between 3 and 10 days
        dayLimitSlider.setValue(0); //Set the value to the lower bound
        dayLimitSlider.setMinorSections(0);
        dayLimitText.update(); //Update the SuperTextBox
        addObject(dayLimitSlider, getWidth()/2+200, getHeight()/10*7);
        
        //Add these SuperTextBoxes onto the world
        addObject(guardText, getWidth()/2-150, getHeight()/10*3);
        addObject(robberText, getWidth()/2-150, getHeight()/10*4);
        addObject(spawnRateRobberText, getWidth()/2-150, getHeight()/10*5);
        addObject (spawnRateVisitorText, getWidth()/2-150, getHeight()/10*6);
        addObject(dayLimitText, getWidth()/2-150, getHeight()/10*7);
    }
    
    /**
     * Return the number of guards set by the user.
     */
    public int getNumberOfGuards(){
        return guardSlider.getValue();
    }
    
    /**
     * Return the number of robbers set by the user.
     */
    public int getNumberOfRobbers(){
        return robberSlider.getValue();
    }
    
    /**
     * Return the number of valuables set by the user.
     */
    // public int getNumberOfValuables(){
        // return valuableSlider.getValue();
    // }
    
    /**
     * Return the spawnrate of Robbers set by the user.
     */
    public int getRobberSpawnRate() {
        return spawnRateRobberSlider.getValue();
    }
    
    /**
     * Return the spawnrate of Visitors set by the user.
     */
    public int getVisitorSpawnRate() {
        return spawnRateVisitorSlider.getValue();
    }
    
    
    /**
     * Return the day limit set by the user.
     */
    public int getDayLimit() {
        return dayLimitSlider.getValue();
    }
}
