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
    private Font boringFont = new Font ("Joystix", false, false, 18);
    private static GreenfootImage backGround1 = new GreenfootImage("museumFrontPage1.png");
    private HomeButton homeButton;
    
    //Set the SuperTextBoxes for guards, robbers, valuables, and spawnrates
    private SuperTextBox guardText;
    private SuperTextBox robberText;
    private SuperTextBox valuableText;
    private SuperTextBox spawnRateRobberText;
    private SuperTextBox spawnRateVisitorText;
    
    //Set the Sliders for guards, robbers, valuables, and spawnrates
    private Slider guardSlider;
    private Slider robberSlider;
    private Slider valuableSlider;
    private Slider spawnRateRobberSlider;
    private Slider spawnRateVisitorSlider;

    
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
        
        String[] guardTextContent = {"Number of Guards in World: " + 1};
        String[] robberTextContent = {"Number of Robbers in World: " + 1};
        String[] valuableTextContent = {"Number of Valuables in World: " + 2};
        String[] spawnRateRobberTextContent = {"Spawn Rate of Robbers per 10s: " + 1};
        String[] spawnRateVisitorTextContent = {"Spawn Rate of Visitors per 10s: " + 3};
        
        guardText = new SuperTextBox(guardTextContent, Color.BLACK, Color.WHITE, boringFont, true, 350, 5, Color.WHITE);
        
        robberText = new SuperTextBox(robberTextContent, Color.BLACK, Color.WHITE, boringFont, true, 350, 5, Color.WHITE);
        
        valuableText = new SuperTextBox(valuableTextContent, Color.BLACK, Color.WHITE, boringFont, true, 350, 5, Color.WHITE);
        
        spawnRateRobberText = new SuperTextBox(spawnRateRobberTextContent, Color.BLACK, Color.WHITE, boringFont, true, 350, 5, Color.WHITE);
        
        spawnRateVisitorText = new SuperTextBox(spawnRateVisitorTextContent, Color.BLACK, Color.WHITE, boringFont, true, 350, 5, Color.WHITE);
        //Set up all the sliders
        
        //Set up the guard slider
        
        guardSlider = new Slider("Number of Guards in World: ", guardText, 1);
        guardSlider.showPercentage(false);
        guardSlider.setMaximumValue(2); // Guard can have a value between 1-3
        guardSlider.setValue(0);
        guardSlider.setMinorSections(0);
        guardText.update();
        addObject(guardSlider, getWidth()/2+100, getHeight()/10*3);
        
        //Set up the robber slider
        
        robberSlider = new Slider("Number of Robbers in World: ", robberText, 1);
        robberSlider.showPercentage(false);
        robberSlider.setMaximumValue(2);
        robberSlider.setValue(0);
        robberSlider.setMinorSections(0);
        robberText.update();
        addObject(robberSlider, getWidth()/2+100, getHeight()/10*4);
        
        //Set up the valuable slider
        
        valuableSlider = new Slider("Number of Valuables in World: ", valuableText, 2);
        valuableSlider.showPercentage(false);
        valuableSlider.setMaximumValue(5);
        valuableSlider.setValue(0);
        valuableSlider.setMinorSections(0);
        valuableText.update();
        addObject(valuableSlider, getWidth()/2+100, getHeight()/10*5);
        
        //Set up the robber spawn rate slider
        
        spawnRateRobberSlider = new Slider("Spawn Rate of Robbers per 10s: ", spawnRateRobberText, 2);
        spawnRateRobberSlider.showPercentage(false);
        spawnRateRobberSlider.setMaximumValue(5);
        spawnRateRobberSlider.setValue(0);
        spawnRateRobberSlider.setMinorSections(0);
        spawnRateRobberText.update();
        addObject(spawnRateRobberSlider, getWidth()/2+100, getHeight()/10*6);
        
        //Set up the visitor spawn rate slider
        
        spawnRateVisitorSlider = new Slider("Spawn Rate of Visitors per 10s: ", spawnRateVisitorText, 3);
        spawnRateVisitorSlider.showPercentage(false);
        spawnRateVisitorSlider.setMaximumValue(7);
        spawnRateVisitorSlider.setValue(0);
        spawnRateVisitorSlider.setMinorSections(0);
        spawnRateVisitorText.update();
        addObject(spawnRateVisitorSlider, getWidth()/2+100, getHeight()/10*7);
        
        //Set the buttons for guards, robbers, and valuables
        //guardButton = new OptionButton("Number of Guards in World: ", guardSlider);
        //guardSlider = new Slider(125, 500, 1, 3, true);
        //addObject(guardSlider, getWidth()/2, getHeight()/10*3);
        //robberButton = new OptionButton("Number of Robbers in World: ", 1, 3);
        //valuableButton = new OptionButton("Number of Valuables in World: ", 2, 7);
        //Set the button for spawn rate of robber
        //spawnRateRobberButton = new OptionButton("Spawn Rate of Robbers per 10s: ", 1, 5);
        //Set the button for spawn rate of visitor
        //spawnRateVisitorButton = new OptionButton("Spawn Rate of Visitors per 10s: ", 3, 10);
        
        //Add these buttons onto the world
        addObject(guardText, getWidth()/2-200, getHeight()/10*3);
        addObject(robberText, getWidth()/2-200, getHeight()/10*4);
        addObject(valuableText, getWidth()/2-200, getHeight()/10*5);
        addObject(spawnRateRobberText, getWidth()/2-200, getHeight()/10*6);
        addObject (spawnRateVisitorText, getWidth()/2-200, getHeight()/10*7);
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
    public int getNumberOfValuables(){
        return valuableSlider.getValue();
    }
    
    public int getRobberSpawnRate() {
        return spawnRateRobberSlider.getValue();
    }
    
    public int getVisitorSpawnRate() {
        return spawnRateVisitorSlider.getValue();
    }
}
