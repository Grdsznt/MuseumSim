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
    
    private static int numberOfRobbers;
    private static int numberOfGuards;
    private static int numberOfValubles;
    private static int startingCurrency;
    private static int museumTarget;
    
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
        
        
        Slider sliders[] = {
            new Slider(1, 698, 831, 10000, 1000000, museumTarget),
            new Slider(2, 698, 831, 1, 25, numberOfRobbers),
            new Slider(3, 698, 831, 5000, 10000, numberOfGuards),
            //new Slider(4, 698, 831, 1, 25, cheaterGamblerSpawnRate),
            new Slider(4, 698, 831, 1, 5000, startingCurrency),
            //new Slider(6, 698, 831, 1, 99, slotsWinRate),
            //new Slider(7, 698, 831, 7, 20, numberOfHorses)
        };
        
        addObject(sliders[0], calculateSliderXPosition(sliders[0], museumTarget), 219);
        addObject(sliders[1], calculateSliderXPosition(sliders[1], numberOfRobbers), 591);
        addObject(sliders[2], calculateSliderXPosition(sliders[2], numberOfGuards), 549);
        addObject(sliders[3], calculateSliderXPosition(sliders[3], cheaterGamblerSpawnRate), 637);
        addObject(sliders[4], calculateSliderXPosition(sliders[4], ), 503);
        addObject(sliders[5], calculateSliderXPosition(sliders[5], slotsWinRate), 269);
        addObject(sliders[6], calculateSliderXPosition(sliders[6], numberOfHorses), 312);
        
        
        
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
